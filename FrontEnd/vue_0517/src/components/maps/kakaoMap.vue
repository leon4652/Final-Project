<template>
  <div>
    <div id="map"></div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import { mapMutations } from "vuex";
import axios from "axios";
export default {
  name: "kakaoMap",
  components: {},
  computed: {
    ...mapState("mapStore", ["sidoCode", "sidoName", "gugunList"]),
  },
  data() {
    return {
      map: null,
      positions: [],
      markers: [],
      lat: 36.354935,
      lan: 127.298259,
      maplevel: 3,
      geocoder: null,
    };
  },

  watch: {
    sidoCode() {
      this.maplevel = 10; //맵사이즈 변경

      var geocoder = new kakao.maps.services.Geocoder();
      geocoder.addressSearch(this.sidoName, (result, status) => {
        if (status === kakao.maps.services.Status.OK) {
          var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
          this.lat = coords.getLat();
          this.lan = coords.getLng();
          this.loadMap(); //지도 다시 실행
        }
      });

      //바뀐 sidoCode를 토대로 axios를 통해 해당 시도의 구군리스트를 담아 vuex에 배열 형태로 저장
      axios
        .get(`http://localhost/api/attraction/gugun/${this.sidoCode}`)
        .then((response) => {
          const getGugunList = response.data;
          this.SET_GUGUN_LIST(getGugunList); //구군리스트 등록
          this.loadMaker(); //시도를 기반으로 구군별 마커 장착
        })
        .catch((error) => {
          // 요청이 실패하면 에러를 처리합니다.
          console.error(error);
        });

      
    },
  },
  created() {},
  mounted() {
    // api 스크립트 소스 불러오기 및 지도 출력
    if (window.kakao && window.kakao.maps) {
      this.loadMap();
    } else {
      this.loadScript();
    }
  },
  methods: {
    ...mapMutations("mapStore",["SET_GUGUN_LIST"]),
    // api 불러오기
    loadScript() {
      const script = document.createElement("script");
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?appkey=" +
        process.env.VUE_APP_KAKAO_MAP_API_KEY +
        "&libraries=services,clusterer,drawing" +
        "&autoload=false";
      /* global kakao */
      script.onload = () => window.kakao.maps.load(this.loadMap);

      document.head.appendChild(script);
    },
    // 맵 출력하기
    loadMap() {
      const container = document.getElementById("map");
      const options = {
        center: new window.kakao.maps.LatLng(this.lat, this.lan),
        level: this.maplevel,
      };

      this.map = new window.kakao.maps.Map(container, options);

      // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성
      var zoomControl = new window.kakao.maps.ZoomControl();
      this.map.addControl(zoomControl, window.kakao.maps.ControlPosition.RIGHT);

      // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성
      var mapTypeControl = new window.kakao.maps.MapTypeControl();
      this.map.addControl(
        mapTypeControl,
        window.kakao.maps.ControlPosition.TOPRIGHT
      ); // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의, TOPRIGHT는 오른쪽 위를 의미한다.

    },
    // 지정한 위치에 마커 불러오기

    loadMaker() {
      //gugunList의 크기만큼 반복문 사용
      for (let i = 0; i < this.gugunList.length; i++) {
      var geocoder = new kakao.maps.services.Geocoder();
      geocoder.addressSearch(this.gugunList[i].gugunName, (result, status) => {
        if (status === kakao.maps.services.Status.OK) {
          //마커 생성
          var coords = new kakao.maps.LatLng(result[0].y, result[0].x); //검색 구군 좌표
          var mLat = coords.getLat(); 
          var mLan = coords.getLng();
          var markerPosition  = new kakao.maps.LatLng(mLat, mLan); // 마커 좌표

          var marker = new kakao.maps.Marker({ //마커 객체 생성
            position: markerPosition
          });
          console.dir(this.gugunList[i].gugunName + "좌표 : " + mLat + " " + mLan)
          marker.setMap(this.map); //맵에 부착
        }
      });
    }


      // // 현재 표시되어있는 marker들이 있다면 marker에 등록된 map을 없애준다.
      // this.deleteMarker();
      // // 마커 이미지를 생성합니다
      // //   const imgSrc = require("@/assets/map/markerStar.png");
      // // 마커 이미지의 이미지 크기 입니다
      // //   const imgSize = new kakao.maps.Size(24, 35);
      // //   const markerImage = new kakao.maps.MarkerImage(imgSrc, imgSize);

      // // 마커를 생성합니다
      // this.markers = [];
      // this.positions.forEach((position) => {
      //   const marker = new kakao.maps.Marker({
      //     map: this.map, // 마커를 표시할 지도
      //     position: position.latlng, // 마커를 표시할 위치
      //     title: position.title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
      //     //   image: markerImage, // 마커의 이미지
      //   });
      //   this.markers.push(marker);
      // });
      // console.log("마커수 ::: " + this.markers.length);

      // // 4. 지도를 이동시켜주기
      // // 배열.reduce( (누적값, 현재값, 인덱스, 요소)=>{ return 결과값}, 초기값);
      // const bounds = this.positions.reduce(
      //   (bounds, position) => bounds.extend(position.latlng),
      //   new kakao.maps.LatLngBounds()
      // );

      // this.map.setBounds(bounds);
    },
    deleteMarker() {
      console.log("마커 싹 지우자!!!", this.markers.length);
      if (this.markers.length > 0) {
        this.markers.forEach((item) => {
          console.log(item);
          item.setMap(null);
        });
      }
    },
  },
};
</script>

<style scoped>
#map {
  width: 100%;
  height: 500px;
}
</style>

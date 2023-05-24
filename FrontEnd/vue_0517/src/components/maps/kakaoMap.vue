<template>
  <div>
    <div id="map"></div>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions } from "vuex";
import axios from "axios";
const baseURL = process.env.VUE_APP_API_BASE_URL;

export default {
  name: "kakaoMap",
  components: {},
  computed: {
    ...mapState("mapStore", [
      "cnt",
      "sidoCode",
      "sidoName",
      "gugunList",
      "gugunCode",
      "gugunName",
      "lan",
      "lat",
      "nowContentType",
      "attInfoList",
      "contentTypeList",
      "isTripPlan",
      "myRoute",
      "mobility"
    ]),
  },
  data() {
    return {
      map: null,
      positions: [],
      markers: [],
      maplevel: 10,
      geocoder: null,
      makerInfo: [], //markerInfo 정보 저장
      eLat:null, //좌표 거리(시간) 계산용 좌표
      eLng:null,
    };
  },

  watch: {
    sidoCode() {
      //시도 코드 변경 시 해당 시도에 맞는 지역 탐색 후 로딩
      this.maplevel = 11; //맵사이즈 변경

      var geocoder = new kakao.maps.services.Geocoder();
      var searchName = this.sidoName;
      if (this.sidoCode === 5) searchName = "광주광역시"; //광주의 경우 동명 처리

      geocoder.addressSearch(searchName, (result, status) => {
        if (status === kakao.maps.services.Status.OK) {
          var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
          this.SET_LAN_LAT({ lat: coords.getLat(), lan: coords.getLng() });
          this.loadMap(); //지도 다시 실행
        }
      });

      //바뀐 sidoCode를 토대로 axios를 통해 해당 시도의 구군리스트를 담아 vuex에 배열 형태로 저장
      axios
        .get(baseURL + `/attraction/gugun/${this.sidoCode}`)
        .then((response) => {
          const getGugunList = response.data;
          this.SET_GUGUN_LIST(getGugunList); //구군리스트 등록
          this.loadGugunMaker(); //시도를 기반으로 구군별 마커 장착
        })
        .catch((error) => {
          // 요청이 실패하면 에러를 처리합니다.
          console.error(error);
        });
    },

    gugunName() {
      //구군 이름 변경 시 해당 구군에 맞는 좌표 탐색 후 저장, 이후 로딩 다시 진행
      // this.maplevel = 7; //맵사이즈 변경
      // var geocoder = new kakao.maps.services.Geocoder();
      // geocoder.addressSearch(
      //   this.sidoName + " " + this.gugunName,
      //   (result, status) => {
      //     if (status === kakao.maps.services.Status.OK) {
      //       var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
      //       this.SET_LAN_LAT({ lat: coords.getLat(), lan: coords.getLng() });
      //     }
      //   }
      // );
    },
  },
  created() {},
  async mounted() {
    // api 스크립트 소스 불러오기 및 지도 출력
    if (window.kakao && window.kakao.maps) {
      //컨텐츠 관련 맵일 경우 추가적인 마커 띄우기 실행

      if (this.nowContentType != 0) {
        if (this.nowContentType == 10) {
          //전체 콘텐츠 보기
          this.SET_IS_TRIP_PLAN(true);
          for (var i = 0; i < this.contentTypeList.length; i++) {
            this.SET_CNT(i); //cnt
            this.loadContentMaker(this.contentTypeList[i]);
          }
        } else {
          this.SET_IS_TRIP_PLAN(false);
          this.loadContentMaker(this.nowContentType);
        }
      }
      //아닐 경우 기존 지도 띄우기
      else this.loadMap();
    } else {
      this.loadScript();
    }
  },
  methods: {
    ...mapActions("mapStore", ["getDetailsFromLatLng"]),
    ...mapMutations("mapStore", [
      "SET_LAN_LAT",
      "SET_GUGUN_LIST",
      "SET_GUGUN",
      "SET_ATTINFO_LIST",
      "SET_NOW_CONTENT_TYPE",
      "SET_IS_TRIP_PLAN",
      "SET_CNT",
      "DEL_EXPECT_TIME",
      "ADD_EXPECT_TIME"

    ]),
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


      /// KAKAO_DRAW
    },

    // 지정한 위치에 마커 불러오기
    async loadGugunMaker() {
      const markerPositions = []; // 좌표를 저장할 배열
      const markerName = []; //마커(인포윈도우) 이름

      //비동기 탐색 : 구군 마커 저장
      const getAddressSearch = (gugunName) => {
        return new Promise((resolve, reject) => {
          const geocoder = new kakao.maps.services.Geocoder();
          geocoder.addressSearch(
            this.sidoName + " " + gugunName,
            (result, status) => {
              if (status === kakao.maps.services.Status.OK) {
                const coords = new kakao.maps.LatLng(result[0].y, result[0].x);
                const mLat = coords.getLat();
                const mLan = coords.getLng();
                const markerPosition = new kakao.maps.LatLng(mLat, mLan);
                resolve(markerPosition); // 성공적으로 좌표를 얻으면 resolve 호출
              } else {
                reject(status); // 좌표를 얻지 못하면 reject 호출
              }
            }
          );
        });
      };

      //동기 탐색(후처리)
      await Promise.all(
        this.gugunList.map(async (gugun) => {
          try {
            const markerPosition = await getAddressSearch(gugun.gugunName);
            markerPositions.push(markerPosition); //배열에 값 추가
            markerName.push(gugun.gugunName);
          } catch (error) {
            console.error("Error occurred during addressSearch:", error);
          }
        })
      );

      // 모든 마커 위치 정보가 추가된 후에 추가 로직 실행
      markerPositions.forEach((markerPosition, index) => {
        // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
        var imageSrc = "/assets/pin12.png",
          imageSize = new kakao.maps.Size(20, 24), // 마커이미지의 크기입니다
          imageOption = { offset: new kakao.maps.Point(27, 69) }; // 마커이미지의 옵션입니다.
        var markerImage = new kakao.maps.MarkerImage(
          imageSrc,
          imageSize,
          imageOption
        );

        //마커 생성
        const marker = new kakao.maps.Marker({
          position: markerPosition,
          image: markerImage, // 마커이미지 설정
        });
        marker.setMap(this.map);
        this.markers.push(marker); //마커 붙이기

        // 마커에 표시할 인포윈도우를 생성합니다
        var infowindow = new kakao.maps.InfoWindow({
          content: `<div class = "info-window">${markerName[index]}</div>`, // 인포윈도우에 표시할 내용
        });

        //마커 이벤트
        kakao.maps.event.addListener(
          marker,
          "mouseover",
          this.makeOverListener(this.map, marker, infowindow)
        );

        kakao.maps.event.addListener(marker, "mouseout", function () {
          infowindow.close();
        });

        //클릭이벤트 : markerName으로 저장. gugunUseName 처리 이후 라우터뷰 푸쉬
        kakao.maps.event.addListener(marker, "click", async () => {
          await this.getGugunUseName(markerName[index]); //정보 저장
          const path = "/rsMain"; // 경로와 쿼리 파라미터 설정

          this.$router.push(path); // 다른 뷰로 이동
        });
      });
    },
    makeOverListener(map, marker, infowindow) {
      return function () {
        infowindow.open(map, marker);
      };
    },
    closeInfoWindowListener(infowindow) {
      return function () {
        infowindow.close();
      };
    },
    async getGugunUseName(regionName) {
      axios
        .get(baseURL + `/attraction/search/name/${regionName}/${this.sidoCode}`)
        .then((response) => {
          this.SET_GUGUN({
            gugunCode: response.data.gugunCode,
            gugunName: response.data.gugunName,
            sidoCode: response.data.sidoCode,
          });
        })
        .catch((error) => {
          console.error(error);
        });
    },

    async loadContentMaker(code) {
      // //콘텐츠 타입 변경 시 해당 정보에 맞는 마커 생성
      //0. 지도 객체 생성
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

      // 1. 비동기 탐색 : 구군 마커 저장
      const response = await axios.get(
        baseURL + `/attraction/view/${code}/${this.sidoCode}/${this.gugunCode}`
      );
      this.SET_ATTINFO_LIST(response.data);

      //2. attInfoList에 저장한 개수만큼 반복하여 마커 생성(타입 0일 경우 모든 ContentType만큼 반복)
      for (let i = 0; i < this.attInfoList.length; i++) {
        // 1. 마커이미지를 생성

        var imageSrc =
            "/assets/pin" + this.attInfoList[i].contentTypeId + ".png",
          imageSize = new kakao.maps.Size(30, 30), // 마커이미지의 크기입니다
          imageOption = { offset: new kakao.maps.Point(27, 69) }; // 마커이미지의 옵션입니다.
        var markerImage = new kakao.maps.MarkerImage(
          imageSrc,
          imageSize,
          imageOption
        );

        // 2. 마커 생성
        const marker = new kakao.maps.Marker({
          position: new kakao.maps.LatLng(
            this.attInfoList[i].latitude,
            this.attInfoList[i].longitude
          ),
          image: markerImage, // 마커이미지 설정
        });
        marker.setMap(this.map); //마커 붙이기

        //3. 마커에 표시할 인포윈도우를 생성
        //3-1. 인포윈도우 설명 처리. 글이 길면 줄여서 보여주기
        var maxOverviewLength = 30; // 최대 표시 길이 설정
        var overview = this.attInfoList[i].overview;
        if (overview.length > maxOverviewLength) {
          overview = overview.substring(0, maxOverviewLength) + "...(생략)";
        }

        var infowindow = new kakao.maps.InfoWindow({
          content: `<div style=
        "max-width: 300px; background-color: #fff; border:1px solid #ccc; border-radius: 10px; box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3); color: #333;
        font-family: Arial, sans-serif; font-size: 16px; padding: 10px;">
          <h3 style="font-size: 18px; font-weight: bold;">${
            this.attInfoList[i].title
          }</h3>
          <span style="color: #0000FF; font-size: 14px;">${
            this.attInfoList[i].addr1
          }</span><br>
          ${overview}<br>
          ${
            this.attInfoList[i].firstImage
              ? `<img src="${this.attInfoList[i].firstImage}" style="max-width: 250px; height: 200px;" alt="Image">`
              : ""
          }
        </div>`, // 인포윈도우에 표시할 내용
        });

        //4. 마커 이벤트 처리
        kakao.maps.event.addListener(
          marker,
          "mouseover",
          this.makeOverListener(this.map, marker, infowindow)
        );

        kakao.maps.event.addListener(
          marker,
          "mouseout",
          this.closeInfoWindowListener(infowindow)
        );

        //우클릭 이벤트 로직
        kakao.maps.event.addListener(
          marker,
          "click",
          function () {
            const nowlat = marker.getPosition().getLat();
            const nowlng = marker.getPosition().getLng();
            //1. 거리 계산 로직
            //처음 스타트일 경우 현재 마커 좌표를 저장
            if(this.myRoute.length == 0) {
              this.DEL_EXPECT_TIME();
              //현재 값이자, 다음 마커 선택 시 거리 비교용 값
              this.eLat = nowlat; this.eLng = nowlng;
            }
            else {
              //아닐 경우 이전 좌표값과 거리 비교
              this.calDist(this.eLat, this.eLng, nowlat, nowlng); 
              this.eLat = nowlat; this.eLng = nowlng; //계산 후 좌표 초기화
            }
            //2. 지역 정보 수집
            this.getDetailsFromLatLng({
              lat: nowlat,
              lan: nowlng,
            });
            if (!this.isTripPlan)
              alert("장소가 여행계획에 추가되었습니다. 확인해보세요!");
          }.bind(this)
        );
      }
    },

    calDist(lat1, lon1, lat2, lon2) {
      //위도와 경도를 기반으로 거리를 계산
      const earthRadius = 6371; // 지구 반경 (단위: km)

      // 위도와 경도를 라디안 단위로 변환
      const radianLat1 = lat1 * (Math.PI / 180);
      const radianLon1 = lon1 * (Math.PI / 180);
      const radianLat2 = lat2 * (Math.PI / 180);
      const radianLon2 = lon2 * (Math.PI / 180);

      // 두 지점의 차이 계산
      const deltaLat = radianLat2 - radianLat1;
      const deltaLon = radianLon2 - radianLon1;

      // Haversine 공식 계산
      const a = Math.sin(deltaLat / 2) ** 2
        + Math.cos(radianLat1) * Math.cos(radianLat2) * Math.sin(deltaLon / 2) ** 2;
      const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

      // 거리 계산
      const result = earthRadius * c;// dist(km)
      this.ADD_EXPECT_TIME(Math.round((result / this.mobility * 60 * 100))/100);
    }

  },
};
</script>

<style scoped>
#map {
  width: 100%;
  height: 650px;
  border: 2px solid #ccc; /* 테두리 스타일 추가 */
  border-radius: 5px; /* 테두리 둥글게 설정 */
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.2); /* 그림자 효과 추가 */
}
</style>

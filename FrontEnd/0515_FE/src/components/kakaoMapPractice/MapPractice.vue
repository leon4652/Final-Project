<template>
  <div>
    Map01입니다.
    <div id="map" style="width: 600px; height: 600px"></div>
    
    lat : {{ lat }}
    lng : {{ lng }}
    <p></p>
    <button @click="panTo">이동</button>
    <input v-model="lat" type="text" placeholder="위도" />
    <input v-model="lng" type="text" placeholder="경도" />
    <p></p>
    <button @click="setMarker(mlat, mlng)">마커 등록</button>
    <input v-model="mlat" type="text" placeholder="마커 위도" />
    <input v-model="mlng" type="text" placeholder="마커 경도" />
  </div>
</template>

<script>
import { panTo, setMarker } from '@/api/marker.js';
export default {
  name: "MapPractice",
  data() {
    return {
      lat: 33.450701, //위도
      lng: 126.570667, //경도
      mlat : 33.450701, //마커 위도
      mlng : 126.570667,//마커 경도
    };
  },
  mounted() {
    // api 스크립트 소스 불러오기 및 지도 출력
    if (window.kakao && window.kakao.maps) {
      this.loadMap(this.lat, this.lng);
    } else {
      this.loadScript();
    }
  },
  methods: {
    ...panTo,
    ...setMarker,
    // api 불러오기
    loadScript() {
      console.dir("loadScript");
      const key = "19e886f21a48e41e0c5e607ebfe3ed26"; //JS API KEY
      const script = document.createElement("script");
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?appkey=" + key + "&autoload=false";
      script.onload = () => window.kakao.maps.load(this.loadMap);
      document.head.appendChild(script);
    },

    // 맵 출력하기
    loadMap(lat, lng) {
      console.dir("loadMap")
      const container = document.getElementById("map");
      const options = {
        center: new window.kakao.maps.LatLng(lat, lng),
        level: 3,
      };
      map = new window.kakao.maps.Map(container, options);

      // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
      var mapTypeControl = new window.kakao.maps.MapTypeControl();
      map.addControl(
        mapTypeControl,
        window.kakao.maps.ControlPosition.TOPRIGHT
      ); // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의, TOPRIGHT는 오른쪽 위를 의미한다.

      // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
      var zoomControl = new window.kakao.maps.ZoomControl();
      map.addControl(zoomControl, window.kakao.maps.ControlPosition.RIGHT);

      // this.loadMaker();
    },

    // //위도 경도 부드럽게 이동
    // panTo() {
    //   var moveLatLon = new window.kakao.maps.LatLng(this.lat, this.lng); // 이동 위치 생성
    //   map.panTo(moveLatLon);
    // },

    // //마커 관련
    // setMarker(lat, lng) {
    //   // 마커가 표시될 위치입니다 
    //   var markerPosition  = new window.kakao.maps.LatLng(lat, lng); 
    //   // 마커를 생성합니다
    //   var marker = new window.kakao.maps.Marker({
    //     position: markerPosition,
    //     text: '텍스트입니다'
    //   });
    //   marker.setMap(map); // 마커가 지도 위에 표시
    //   //marker.setMap(null); : 마커 제거
    // }
  },
};
</script>

<style scoped></style>

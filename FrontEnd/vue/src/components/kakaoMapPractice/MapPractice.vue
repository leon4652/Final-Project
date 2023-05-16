<template>
  <div>
    Map01입니다.
    <div id="map" style="width: 600px; height: 600px"></div>
    <button @click="panTo">이동</button>
    {{ test }}

    <input v-model="lat" type="text" placeholder="위도" />
    <input v-model="lng" type="text" placeholder="경도" />
  </div>
</template>

<script>
export default {
  name: "MapPractice",
  data() {
    return {
      lat: 33.450701, //위도
      lng: 126.570667, //경도
    };
  },
  mounted() {
    // api 스크립트 소스 불러오기 및 지도 출력
    if (window.kakao && window.kakao.maps) {
      this.loadMap();
    } else {
      this.loadScript();
    }
  },
  methods: {
    // api 불러오기
    loadScript() {
      const key = "19e886f21a48e41e0c5e607ebfe3ed26"; //JS API KEY
      const script = document.createElement("script");
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?appkey=" + key + "&autoload=false";
      script.onload = () => window.kakao.maps.load(this.loadMap);
      document.head.appendChild(script);
    },

    // 맵 출력하기
    loadMap() {
      const container = document.getElementById("map");
      const options = {
        center: new window.kakao.maps.LatLng(this.lat, this.lng),
        level: 3,
      };
      this.map = new window.kakao.maps.Map(container, options);

      // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
      var mapTypeControl = new window.kakao.maps.MapTypeControl();
      this.map.addControl(
        mapTypeControl,
        window.kakao.maps.ControlPosition.TOPRIGHT
      ); // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의, TOPRIGHT는 오른쪽 위를 의미한다.

      // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
      var zoomControl = new window.kakao.maps.ZoomControl();
      this.map.addControl(zoomControl, window.kakao.maps.ControlPosition.RIGHT);

      // this.loadMaker();
    },

    //위도 경도 부드럽게 이동, 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
    panTo() {
      // 이동할 위도 경도 위치를 생성합니다
      var moveLatLon = new window.kakao.maps.LatLng(this.lat, this.lng);
      this.map.panTo(moveLatLon);
    },
  },
};
</script>

<style scoped></style>

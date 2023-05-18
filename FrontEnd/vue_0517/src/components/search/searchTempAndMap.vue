<template>
  <div class="container">
    <div class="map-container">
      <kakao-map></kakao-map>
    </div>

    <h1>여기 날씨 들어감</h1>
    <h2>여기 시도별 내부 지역</h2>
  </div>
</template>

<script>
import kakaoMap from "@/components/maps/kakaoMap.vue";

export default {
  name: "SearchTempAndMap",
  components: { kakaoMap },
  data() {
    return {
      message: "",
    };
  },
  created() {},
  methods: {},
};
</script>

<style scoped>
.container {
  display: flex;
}

.map-container {
  float: left;
  width: 60%;
  height: 600px;
}

.map-container #map {
  width: 100%;
  height: 100%;
}

.info-container {
  margin-left: 10px; /* 필요한 간격을 설정하세요 */
  flex: 1;
}
</style>

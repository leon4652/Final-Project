<template>
  <div>
    <div class="flex-container">
      <div class="container">
        <kakao-map class="map-container"></kakao-map>
      </div>
      <div class="rsa-search-container">
        <search-result></search-result>
      </div>
    </div>
  </div>
</template>

<script>
import kakaoMap from "@/components/maps/kakaoMap.vue";
import searchResult from "@/components/searchResult/resultComp.vue";
import { mapMutations } from "vuex";
export default {
  name: "rsAmenity",
  components: { kakaoMap, searchResult },
  data() {
    return {
      message: "",
    };
  },
  beforeMount() {
    if (this.$route.query.nowContentType) {
      //컨텐츠 타입 감지
      this.SET_NOW_CONTENT_TYPE(this.$route.query.nowContentType);
    }
  },
  methods: {
    ...mapMutations("mapStore", ["SET_NOW_CONTENT_TYPE"]),
  },
};
</script>

<style scoped>
.flex-container {
  display: flex;

  justify-content: space-between;
  align-items: flex-start;
}

.map-container {
  width: 100%;
  height: 100%;
}
.container {
  flex: 1; /* 자동으로 너비를 조절하여 공간을 차지 */
  width: 30%;
  height: 30%;
  padding: 23px;
  margin-right: 10px; /* 요소 사이의 우측 간격 설정 */
  margin-left: 10px; /* 요소 사이의 우측 간격 설정 */
}

.rsa-search-container {
  flex: 1; /* 자동으로 너비를 조절하여 공간을 차지 */
  margin-right: 10px;
  margin-bottom: 30px;
}
</style>

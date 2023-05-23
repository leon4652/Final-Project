<template>
  <div>
    <div class="flex-container">
      <div class="container">
        <kakao-map class="map-container"></kakao-map>
      </div>
      <div class="search-container">
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
  name: "rsReview",
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
  padding: 20px;
  margin-right: 10px; /* 요소 사이의 우측 간격 설정 */
  margin-left: 10px; /* 요소 사이의 우측 간격 설정 */
}

.search-container {
  flex: 1; /* 자동으로 너비를 조절하여 공간을 차지 */
  overflow: hidden; /* 부모 요소의 영역을 넘어가는 내용을 숨김 */
}
</style>

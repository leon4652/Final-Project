<template>
  <div>
    <div class="flex-container">
      <div class="container">
        <kakao-map class="map-container"></kakao-map>
      </div>
      <div class="rssp-search-container">
        <add-my-favorite></add-my-favorite>
      </div>
    </div>
  </div>
</template>

<script>
import kakaoMap from "@/components/maps/kakaoMap.vue";
import addMyFavorite from "@/components/searchResult/addMyFavorite.vue";
import { mapMutations } from "vuex";
export default {
  name: "rsSetPlan",
  components: { kakaoMap, addMyFavorite },
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

.rssp-search-container {
  flex: 1; /* 자동으로 너비를 조절하여 공간을 차지 */
  margin-right: 10px;
  margin-bottom: 30px;
}
</style>

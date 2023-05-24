<template>
  <div>
    <div class="flex-container">
      <kakao-map class="map-container"></kakao-map>

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
  name: "rsTravel",
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
  flex: 1; /* 자동으로 너비를 조절하여 공간을 차지 */
  margin-left: 30px;
}

.search-container {
  flex: 1; /* 자동으로 너비를 조절하여 공간을 차지 */
}
</style>

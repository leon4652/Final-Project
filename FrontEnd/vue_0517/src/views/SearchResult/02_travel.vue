<template>
  <div>
    
    <p>===========================</p>
    하위 라우터 뷰 2 : 관광지
    <p>===================</p>
    <kakao-map></kakao-map>
    <search-result></search-result>
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
  created() {
    if (this.$route.query.nowContentType) { //컨텐츠 타입 감지
      this.SET_NOW_CONTENT_TYPE(this.$route.query.nowContentType);
    }
  },
  methods: {
    ...mapMutations("mapStore", ["SET_NOW_CONTENT_TYPE"]),
  },
};
</script>

<style scoped></style>

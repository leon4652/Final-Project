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
export default {
  name: "rsTravel",
  components: { kakaoMap, searchResult },
  data() {
    return {
      message: "",
    };
  },
  created() {},
  methods: {},
};
</script>

<style scoped></style>

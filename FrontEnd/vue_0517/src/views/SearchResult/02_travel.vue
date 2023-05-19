<template>
  <div>
    <p>===========================</p>
    하위 라우터 뷰 2 : 관광지
    <p>===================</p>
    <kakao-map></kakao-map>
    <rs-travel-comp>asd</rs-travel-comp>
  </div>
</template>

<script>
import KakaoMap from "@/components/maps/kakaoMap.vue";
import rsTravelComp from "@/components/searchResult/rsTravelComp.vue";
export default {
  name: "rsTravel",
  components: { KakaoMap, rsTravelComp },
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

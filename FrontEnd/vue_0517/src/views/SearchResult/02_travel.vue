<template>
  <div>
    <p>===========================</p>
    하위 라우터 뷰 2 : 관광지
    <p>===================</p>
    <kakao-map></kakao-map>
  </div>
</template>

<script>
import KakaoMap from "@/components/maps/kakaoMap.vue";
export default {
  name: "SRView2",
  components: { KakaoMap },
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

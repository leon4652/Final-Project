<template>
  <div>
    <p>===========================</p>
    하위 라우터 뷰 3 : plan
    <p>===================</p>
    <kakao-map></kakao-map>
  </div>
</template>

<script>
import KakaoMap from "@/components/maps/kakaoMap.vue";
export default {
  name: "rsPlan",
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

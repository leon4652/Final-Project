<template>
  <div>
    <p>===========================</p>
    하위 라우터 뷰 3 : restaurant
    <p>===================</p>
    <kakao-map></kakao-map>
  </div>
</template>

<script>
import KakaoMap from "@/components/maps/kakaoMap.vue";
export default {
  name: "rsRestaurant",
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

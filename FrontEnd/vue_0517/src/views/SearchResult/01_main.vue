<template>
  <div>
    <p>===========================</p>
    하위 라우터 뷰 1 : 홈 이미지 / 날씨
    <p>===================</p>
    <kakao-map></kakao-map>
  </div>
</template>

<script>
import kakaoMap from "@/components/maps/kakaoMap.vue";
export default {
  name: "rsMain",
  components: { kakaoMap },
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

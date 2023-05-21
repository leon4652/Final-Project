<template>
  <div>
    <p>===========================</p>
    하위 라우터 뷰 1 : 홈 이미지 / 날씨
    <p>===================</p>
    <kakao-map></kakao-map>
  </div>
</template>

<script>
import { mapMutations } from "vuex";
import kakaoMap from "@/components/maps/kakaoMap.vue";
export default {
  name: "rsMain",
  components: { kakaoMap },
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

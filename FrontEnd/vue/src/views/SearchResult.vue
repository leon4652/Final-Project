<template>
  <div>
    <h1>SearchResult, 검색 결과 페이지</h1>
    <div id="nav"><router-link to="/srView1">자식 1</router-link> |</div>
    <router-view />
    <!-- 라우터 뷰 -->

    <result-comp></result-comp>
  </div>
</template>

<script>
import resultComp from "@/components/kakaoMapPractice/resultComp.vue"; //컴포넌트
export default {
  name: "SearchResult",
  components: { resultComp },
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

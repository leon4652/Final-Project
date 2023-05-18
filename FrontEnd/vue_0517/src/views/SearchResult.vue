<template>
  <div>
    <h1>SearchResult, 검색 결과 : {{ searchWord }}</h1>
    <div id="nav">
      <router-link to="/srView1">자식 1</router-link> |
      <router-link to="/srView2">자식 2</router-link> |
      <router-link to="/srView3">자식 3</router-link> |
      <router-link to="/srView4">자식 4</router-link> |
      <router-link to="/srView5">자식 5</router-link> |
    </div>
    <router-view />
    <!-- 라우터 뷰 -->

    <result-comp></result-comp>
  </div>
</template>

<script>
import { mapState } from "vuex";
import resultComp from "@/components/search/resultComp.vue"; //컴포넌트
export default {
  name: "SearchResult",
  components: { resultComp },
  computed: {
    ...mapState("mapStore", ["searchWord"]),
  },
  data() {
    return {};
  },
  created() {},
  methods: {},
};
</script>

<style scoped></style>

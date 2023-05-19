<template>
  <div>
    <h1>SearchResult, 검색 결과 : {{ gugunName }}</h1>
    <div id="nav">
      <router-link to="/main">메인화면</router-link> |
      <router-link to="/travel">관광지</router-link> |
      <router-link to="/culture">문화시설</router-link> |
      <router-link to="/festival">축제공연행사</router-link> |
      <router-link to="/plan">여행코스</router-link> |
      <router-link to="/leisure">레포츠</router-link> |
      <router-link to="/amenity">숙박</router-link> |
      <router-link to="/shopping">쇼핑</router-link> |
      <router-link to="/restaurant">음식점</router-link> |
      <router-link to="/review">지역 후기</router-link> |
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
    ...mapState("mapStore", ["searchWord", "gugunName"]),
  },
  data() {
    return {};
  },
  created() {},
  methods: {},
};
</script>

<style scoped></style>

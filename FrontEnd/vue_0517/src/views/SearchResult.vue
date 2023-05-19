<template>
  <div>
    <h1>SearchResult, 검색 결과 : {{ gugunName }}</h1>
    <div id="nav">
      <router-link to="/rsMain">메인화면</router-link> |
      <router-link to="/rsTravel">관광지</router-link> |
      <router-link to="/rsCulture">문화시설</router-link> |
      <router-link to="/rsFestival">축제공연행사</router-link> |
      <router-link to="/rsPlan">여행코스</router-link> |
      <router-link to="/rsLeisure">레포츠</router-link> |
      <router-link to="/rsAmenity">숙박</router-link> |
      <router-link to="/rsShopping">쇼핑</router-link> |
      <router-link to="/rsRestaurant">음식점</router-link> |
      <router-link to="/rsReview">지역 후기</router-link> |
    </div>
    <router-view />
    <!-- 라우터 뷰 -->
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "SearchResult",
  components: {},
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

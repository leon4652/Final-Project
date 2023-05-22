<template>
  <div>
    <h1>검색 결과 : {{ gugunName }}</h1>
    <div id="nav">
      <router-link :to="{ path: '/rsSetPlan', query: { nowContentType: 10 } }"
        >여행계획</router-link
      >
      |
      <router-link :to="{ path: '/rsTravel', query: { nowContentType: 12 } }"
        >관광지</router-link
      >
      |
      <router-link :to="{ path: '/rsCulture', query: { nowContentType: 14 } }"
        >문화시설</router-link
      >
      |
      <router-link :to="{ path: '/rsFestival', query: { nowContentType: 15 } }"
        >축제공연행사</router-link
      >
      |
      <router-link :to="{ path: '/rsPlan', query: { nowContentType: 25 } }"
        >여행코스</router-link
      >
      |
      <router-link :to="{ path: '/rsLeisure', query: { nowContentType: 28 } }"
        >레포츠</router-link
      >
      |
      <router-link :to="{ path: '/rsAmenity', query: { nowContentType: 32 } }"
        >숙박</router-link
      >
      |
      <router-link :to="{ path: '/rsShopping', query: { nowContentType: 38 } }"
        >쇼핑</router-link
      >
      |
      <router-link
        :to="{ path: '/rsRestaurant', query: { nowContentType: 39 } }"
        >음식점</router-link
      >
      |
      <router-link :to="{ path: '/rsReview', query: { nowContentType: 0 } }"
        >지역 후기</router-link
      >
      |
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

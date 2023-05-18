<template>
  <div>
    <search-comp></search-comp>
    <search-temp-and-map></search-temp-and-map>
  </div>
</template>

<script>
import SearchComp from "@/components/search/searchComp.vue";
import SearchTempAndMap from "@/components/search/searchTempAndMap.vue";
//핫게시글, 추천 경로 등 추가할 필요 있음.
//comp1 추가 : 날씨

//comp2 추가

export default {
  components: { SearchComp, SearchTempAndMap },
};
</script>
<style></style>

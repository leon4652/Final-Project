<template>
  <div>
    <map-practice></map-practice>
    <test-view></test-view>
    검색어 : {{ this.$store.state.searchWord }}
  </div>
</template>

<script>
import MapPractice from "@/components/kakaoMapPractice/MapAPI.vue";
import testView from "@/components/kakaoMapPractice/inputTest.vue";
export default {
  components: { MapPractice, testView },
};
</script>

<style></style>

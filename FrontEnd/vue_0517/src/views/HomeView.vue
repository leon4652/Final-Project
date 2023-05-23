<template>
  <div>
    <homeSwiperComp></homeSwiperComp>
    <homeSearchComp> </homeSearchComp>
  </div>
</template>

<script>
import homeSwiperComp from "@/components/search/homeSwiperComp.vue";
import homeSearchComp from "@/components/search/homeSearchComp.vue";
export default {
  name: "HomeView",
  components: { homeSearchComp, homeSwiperComp },
};
</script>
<style scoped></style>

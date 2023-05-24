<template>
  <div>
    <main-carousel></main-carousel>
    <homeSwiperComp></homeSwiperComp>
    <homeSearchComp> </homeSearchComp>
  </div>
</template>

<script>
import homeSwiperComp from "@/components/search/homeSwiperComp.vue";
import homeSearchComp from "@/components/search/homeSearchComp.vue";
import MainCarousel from '@/components/item/MainCarousel.vue';
export default {
  name: "HomeView",
  components: { homeSearchComp, homeSwiperComp, MainCarousel },
};
</script>
<st,
    MainCarouselyle scoped></style>

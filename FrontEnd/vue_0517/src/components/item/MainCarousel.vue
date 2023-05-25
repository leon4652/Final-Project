<template>
  <div class="carousel-container">
    <b-carousel
      id="carousel-1"
      v-model="slide"
      :interval="4000"
      controls
      indicators
      background="#ababab"
      img-width="1024"
      img-height="480"
      style="text-shadow: 1px 1px 2px #333"
      @sliding-start="onSlideStart"
      @sliding-end="onSlideEnd"
    >
      <b-carousel-slide img-src="https://picsum.photos/1024/480/?image=52" />

      <b-carousel-slide img-src="https://picsum.photos/1024/480/?image=54" />

      <b-carousel-slide img-src="https://picsum.photos/1024/480/?image=12" />

      <b-carousel-slide img-src="https://picsum.photos/1024/480/?image=55" />

      <b-carousel-slide img-src="https://picsum.photos/1024/480/?image=10" />
    </b-carousel>
  </div>
</template>

<script>
export default {
  name: 'MainCarousel',
  data() {
    return {
      slide: 0,
    };
  },
  methods: {
    onSlideStart(slide) {
      this.slide = slide;
      this.sliding = true;
    },
    onSlideEnd(slide) {
      this.slide = slide;
      this.sliding = false;
    },
  },
};
</script>

<style scoped>
.carousel-container {
  margin-left: 10%;
  margin-right: 10%;
  margin-bottom: 20px;
}
</style>

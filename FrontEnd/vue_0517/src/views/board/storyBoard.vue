<template>
  <b-container>
    <!-- <router-link :to="{ name: 'write' }">글 작성 |</router-link> -->
    <!-- <storyboard-comp></storyboard-comp> -->
    <router-view></router-view>
  </b-container>
</template>

<script>
// import storyboardComp from '@/components/board/storyboardComp.vue';
export default {
  name: 'storyBoard',
  // components: { storyboardComp },
  components: {},
  data() {
    return {
      message: '',
    };
  },
  created() {},
  methods: {},
};
</script>

<style scoped></style>

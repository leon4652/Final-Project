<template>
  <h2>{{ total }}</h2>
</template>

<script>
export default {
  // props: ["total"],
  computed: {
    total() {
      return this.$store.state.count; //store 저장값을 가져온다.
    },
  },
};
</script>

<style></style>

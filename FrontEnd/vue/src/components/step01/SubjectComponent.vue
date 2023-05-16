<template>
  <button @click="addCount">{{ title }} - {{ count }}</button>
</template>

<script>
export default {
  name: "SubjectComponent",
  props: ["title"],
  data() {
    return {
      count: 0,
    };
  },
  methods: {
    addCount: function () {
      this.count += 1; //여기까진 똑같았다.
      // this.$emit("addtotcount");
      this.$store.state.count++;
    },
  },
};
</script>

<style></style>

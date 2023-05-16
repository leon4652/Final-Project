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
      this.count += 1; //data의 카운트가 증가
      this.$emit("add-tot-count"); //emit을 통해 vue에서 add-tot-count 실행
    },
  },
};
</script>

<style></style>

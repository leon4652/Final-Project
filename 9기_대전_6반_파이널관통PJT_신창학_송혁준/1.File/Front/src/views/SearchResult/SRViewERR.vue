<template>
  <div>
    <p>===========================</p>
    에러 페이지 : 검색 결과가 없습니다.
    <p>===================</p>
    <button @click="goToMain">돌아가기</button>
  </div>
</template>

<script>
export default {
  name: "SRViewERR",
  components: {},
  data() {
    return {
      message: "",
    };
  },
  created() {},
  methods: {
    goToMain() {
      this.$router.push("/");
    },
  },
};
</script>

<style scoped></style>

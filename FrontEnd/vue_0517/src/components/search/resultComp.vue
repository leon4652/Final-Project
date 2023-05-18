<template>
  <div>
    테스트 result값 :
    {{ message }}
    구군코드 : {{ gugunCode }} 구군이름 : {{ gugunName }} 시도코드 :
    {{ sidoCode }}
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "resultComp",
  components: {},
  computed: {
    ...mapState("mapStore", ["gugunCode", "gugunName", "sidoCode"]),
  },
  data() {
    return {
      message: "",
    };
  },
  created() {},
  methods: {},
};
</script>

<style scoped></style>

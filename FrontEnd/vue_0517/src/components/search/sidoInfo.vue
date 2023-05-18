<template>
  <div>
    들어갈 것 : 시도 이미지 시도에 속한 구군 정보
    <img :src="sidoImg" alt="이미지" />

    이미지 : {{ sidoImg }}
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "sidoInfo",
  components: {},
  data() {
    return {
      message: "",
    };
  },
  computed: {
    ...mapState("mapStore", ["sidoImg"]),
  },
  created() {},
  methods: {},
};
</script>

<style scoped></style>

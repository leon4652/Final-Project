<template>
  <div>
    <img :src="sidoImg" alt="지역" class="fixed-size-image" />
    <b></b>
    <ul>
      <li
        v-for="gugun in gugunList"
        :key="gugun.gugunCode"
        @click="gugunClick(gugun)"
      >
        지역 : {{ gugun.gugunName }}
      </li>
    </ul>
  </div>
</template>

<script>
import { mapMutations, mapState } from "vuex";
export default {
  name: "sidoInfo",
  components: {},
  data() {
    return {
      message: "",
    };
  },
  computed: {
    ...mapState("mapStore", ["sidoImg", "gugunList", "sidoCode"]),
  },
  created() {},
  methods: {
    ...mapMutations("mapStore", ["SET_GUGUN"]),
    async gugunClick(gugun) {
      await this.SET_GUGUN({
        gugunCode: gugun.gugunCode,
        sidoCode: this.sidoCode,
        gugunName: gugun.gugunName,
      });
      this.$router.push("/srView1"); // 다른 뷰로 이동
    },
  },
};
</script>

<style scoped>
.fixed-size-image {
  width: 400px; /* 원하는 가로 크기 */
  height: auto; /* 세로 크기는 가로 크기에 비례하여 자동으로 조정됩니다 */
}
</style>

<template>
  <div>
    <img :src="sidoImg" alt="지역" class="fixed-size-image"/>
    <b></b>
    <ul>
      <li v-for="gugun in gugunList" :key="gugun.gugunCode" @click="gugunClick(gugun)">
        지역 : {{ gugun.gugunName }}
      </li>
    </ul>
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
    ...mapState("mapStore", ["sidoImg", "gugunList"]),
  },
  created() {},
  methods: {
    gugunClick(gugun) {
      // 클릭 이벤트 처리
      console.log("Clicked:", gugun.gugunName);
      // 여기서 추가로 필요한 로직을 작성하세요
      alert(gugun.gugunName + " 을 클릭하셨군요!")
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

<template>
  <div>
    <h1>테스트 뷰 01</h1>
    <h2>{{ posMsg }}</h2>
    <input v-model="lan" type="text" placeholder="lan 값 입력" />
    <input v-model="lat" type="text" placeholder="lat 값 입력" />
    <button @click="saveValue">저장</button>
  </div>
</template>

<script>
import { mapMutations } from "vuex";
export default {
  name: "testView",
  components: {},
  computed: {
    posMsg() {
      return this.$store.getters["mapStore/posMsg"]; //getters를 통해 얻어오기
    },
  },

  data() {
    return {
      lan: 0,
      lat: 0,
      message: "",
    };
  },

  created() {
    console.log(this.lan, this.lat);
  },

  methods: {
    ...mapMutations("mapStore", ["MOD_LAN_LAT"]),

    saveValue() {
      this.MOD_LAN_LAT({ lan: this.lan, lat: this.lat });
    },
  },
};
</script>

<style scoped></style>

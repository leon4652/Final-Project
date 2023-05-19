<template>
  <div>
    관광지 컴포넌트
    <div>"here" : 여기 들어갈 것 : 관광지 이름 : 관광지 정보 : 위치 + 마커</div>
    <div v-for="att in this.attInfoList" :key="att.title">
      {{ att.title }} | {{ att.addr1 }} | {{ att.overview }}
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { mapMutations, mapState } from "vuex";
export default {
  name: "rsTravelComp",
  components: {},
  data() {
    return {
      message: "",
    };
  },
  computed: {
    ...mapState("mapStore", ["sidoCode", "gugunCode", "attInfoList"]),
  },
  created() {
    axios
      .get(
        `http://localhost/api/attraction/view/12/${this.sidoCode}/${this.gugunCode}`
      )
      .then((response) => {
        this.SET_ATTINFO_LIST(response.data); // 받아온 데이터를 attList에 저장
      })
      .catch((error) => {
        console.error(error);
      });
  },
  methods: {
    ...mapMutations("mapStore", ["SET_ATTINFO_LIST"]),
  },
};
</script>

<style scoped></style>

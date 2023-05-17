<template>
  <div>
    테스트 result값 :
    {{ message }}
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "resultComp",
  components: {},
  data() {
    return {
      message: "",
    };
  },
  created() {
    // 이전 맵에서 저장해놨던 값을 토대로 검색 결과를 수행
    axios
      .get("http://localhost/api/shareboard/list")
      .then((response) => {
        const data = response.data;

        console.dir(data);
        console.dir("regist : " + data[0].registDate);
        console.dir("name : " + data[0].userName);
        console.dir("update : " + data[0].updateDate);
        this.message = data[0].updateDate;
        // 추출한 값들을 활용하여 추가적인 작업 수행
        // ...
      })
      .catch((error) => {
        console.error(error);
      });
  },
  methods: {},
};
</script>

<style scoped></style>

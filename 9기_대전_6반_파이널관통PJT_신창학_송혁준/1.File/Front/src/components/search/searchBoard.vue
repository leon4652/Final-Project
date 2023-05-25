<template>
  <div>
    <h1>여행지 검색 페이지</h1>

    <div class="select-container">
      <div style="display: flex">
        <div class="my-text-style">여행지역을 선택하세요</div>
        <select
          class="custom-select"
          v-model="sidoCode"
          @change="handleSidoCodeChange"
        >
          <option value="0" disabled>여행지역 선택</option>
          <option
            v-for="sido in sidoOptions"
            :key="sido.sidoCode"
            :value="sido.sidoCode"
          >
            {{ sido.sidoName }}
          </option>
        </select>
      </div>
      <div style="display: flex">
        <div class="my-text-style">이동수단을 선택하세요</div>
        <select class="custom-select" v-model="mobility">
          <option value="60" selected>자동차</option>
          <option value="20">자전거</option>
          <option value="5">도보</option>
        </select>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { mapMutations } from "vuex";
export default {
  name: "SearchBoard",
  components: {},
  computed: {},
  data() {
    return {
      searchInput: "",
      sidoCode: 0,
      mobility: 60,
      sidoOptions: [],
    };
  },
  created() {
    this.fetchSidoOptions(); // 컴포넌트가 생성되면 서버에서 지역 옵션들을 가져온다.
  },
  watch: {
    mobility(newMobility) {
      this.SET_MOBILITY(newMobility);
    },
  },
  methods: {
    ...mapMutations("mapStore", [
      "MOD_SEARCH_WORD",
      "SET_GUGUN",
      "SET_NOW_SIDO",
      "SET_MOBILITY",
    ]),
    search() {
      //검색 결과 푸쉬
      if (this.sidoCode === 0) alert("지역을 선택하세요!");
      else {
        this.MOD_SEARCH_WORD(this.searchInput);

        //검색어 및 옵션 기반으로 검색
        axios
          .get(
            process.env.VUE_APP_API_BASE_URL +
              `/attraction/search/${this.searchWord}/${this.sidoCode}`
          )
          .then((response) => {
            const data = response.data;
            const { gugunCode, sidoCode, gugunName } = data;
            this.SET_GUGUN({ gugunCode, sidoCode, gugunName });
            this.$router.push("/rsMain"); // 다른 뷰로 이동
          })
          .catch((error) => {
            // 에러 처리
            console.error(error);
          });
      }
    },
    fetchSidoOptions() {
      // 서버에서 지역 옵션 가져오기
      axios
        .get(process.env.VUE_APP_API_BASE_URL + "/attraction/sido")
        .then((response) => {
          this.sidoOptions = response.data.map((sido) => ({
            sidoCode: sido.sidoCode,
            sidoName: sido.sidoName,
            sidoImg: sido.sidoImg,
          }));
        })
        .catch((error) => {
          console.error(error);
        });
    },
    handleSidoCodeChange() {
      // sidoName, sidoImg 값을 가져와서 SET_NOW_SIDO 뮤테이션에 함께 전달
      const sido = this.sidoOptions.find(
        (sido) => sido.sidoCode === this.sidoCode
      );
      const sidoName = sido ? sido.sidoName : "";
      const sidoImg = sido ? sido.sidoImg : "";
      this.SET_NOW_SIDO({ sidoCode: this.sidoCode, sidoName, sidoImg });
    },
  },
};
</script>

<style scoped>
.my-text-style {
  display: inline-block;
  padding: 5px 10px;
  font-size: 16px;
  line-height: 1.5;
  color: #555555;
  vertical-align: middle;
  background-color: #ffffff;
  border: 1px solid #cccccc;
  border-radius: 4px;
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  margin-right: 30px;
}
.select-container {
  padding: 10px;
}

.custom-select {
  display: inline-block;
  padding: 5px 10px;
  font-size: 16px;
  line-height: 1.5;
  color: #555555;
  vertical-align: middle;
  background-color: #ffffff;
  border: 1px solid #cccccc;
  border-radius: 4px;
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  width: 500px;
}

.custom-select:focus {
  border-color: #333333;
  outline: 0;
  box-shadow: 0 0 0 2px rgba(51, 51, 51, 0.1);
}
</style>

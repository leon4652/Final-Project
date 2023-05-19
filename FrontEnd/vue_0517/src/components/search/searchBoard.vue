<template>
  <div>
    <h1>searchComp, 여행지 검색 페이지</h1>
    <select v-model="mobility">
      <option value="0" selected>교통수단</option>
      <option value="1">자동차</option>
      <option value="2">자전거</option>
      <option value="3">도보</option>
    </select>
    <select v-model="sidoCode" @change="handleSidoCodeChange">
      <option value="0" selected>지역</option>
      <option
        v-for="sido in sidoOptions"
        :key="sido.sidoCode"
        :value="sido.sidoCode"
      >
        {{ sido.sidoName }}
        {{ sido.sidoCode }}
      </option>
    </select>
    <input
      v-model="searchInput"
      type="text"
      placeholder="지역을 검색하세요."
    /><button @click="search">검색</button>
  </div>
</template>

<script>
import axios from "axios";
import { mapState } from "vuex";
import { mapMutations } from "vuex";
export default {
  name: "SearchBoard",
  components: {},
  computed: {
    ...mapState("mapStore", ["searchWord"]),
  },
  data() {
    return {
      searchInput: "",
      sidoCode: 0,
      mobility: 0,
      sidoOptions: [],
    };
  },
  created() {
    this.fetchSidoOptions(); // 컴포넌트가 생성되면 서버에서 지역 옵션들을 가져온다.
  },
  methods: {
    ...mapMutations("mapStore", [
      "MOD_SEARCH_WORD",
      "SET_GUGUN",
      "SET_NOW_SIDO",
    ]),
    search() {
      //검색 결과 푸쉬
      if (this.sidoCode == 0) alert("세부지역을 검색해보세요.");
      else {
        this.MOD_SEARCH_WORD(this.searchInput);

        //검색어 및 옵션 기반으로 검색
        axios
          .get(
            `http://localhost/api/attraction/search/${this.searchWord}/${this.sidoCode}`
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
        .get("http://localhost/api/attraction/sido")
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

<style scoped></style>

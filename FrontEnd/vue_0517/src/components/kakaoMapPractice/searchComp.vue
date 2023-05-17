<template>
  <div>
    <h1>searchComp, 여행지 검색 페이지</h1>
    <select v-model="mobility">
      <option value="">교통수단</option>
      <option value="1">자동차</option>
      <option value="2">자전거</option>
      <option value="3">도보</option>
    </select>
    <select v-model="sidoCode">
      <option value="">지역</option>
      <option value="1">서울</option>
      <option value="2">인천</option>
      <option value="3">대전</option>
      <option value="4">대구</option>
      <option value="5">광주</option>
      <option value="6">부산</option>
      <option value="7">울산</option>
      <option value="8">세종</option>
      <option value="31">경기도</option>
      <option value="32">강원도</option>
      <option value="33">충청북도</option>
      <option value="34">충청남도</option>
      <option value="35">경상북도</option>
      <option value="36">경상남도</option>
      <option value="37">전라북도</option>
      <option value="38">전라남도</option>
      <option value="39">제주</option>
    </select>
    <input v-model="searchInput" type="text" placeholder="지역을 검색하세요." />
    <button @click="search">검색</button>
  </div>
</template>

<script>
import { mapState } from "vuex";
import { mapMutations } from "vuex";
export default {
  name: "SearchMapComp",
  components: {},
  computed: {
    ...mapState("mapStore", ["searchWord"]),
  },
  data() {
    return {
      searchInput: "",
      sidoCode: 0,
      mobility: 0,
    };
  },
  created() {},
  methods: {
    ...mapMutations("mapStore", ["MOD_SEARCH_WORD"]),
    search() {
      this.MOD_SEARCH_WORD(this.searchInput);
      this.$router.push("/srView1"); // 다른 뷰로 이동
    },
  },
};
</script>

<style scoped></style>

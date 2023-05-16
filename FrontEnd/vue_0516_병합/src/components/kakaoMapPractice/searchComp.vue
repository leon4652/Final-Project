<template>
  <div>
    <h1>searchComp, 여행지 검색 페이지</h1>
    <input v-model="searchWord" type="text" placeholder="지역을 검색하세요." />
    <button @click="search">검색</button>

    <!-- 지표 보여주기 -->
    <p></p>
    store : {{ this.$store.state.searchWord }}
    <p></p>
    local : {{ searchWord }}
  </div>
</template>

<script>
import { mapMutations } from "vuex";
export default {
  name: "SearchMapComp",
  components: {},
  data() {
    return {
      searchWord: "",
    };
  },
  created() {},
  methods: {
    ...mapMutations(["MOD_SEARCH_WORD"]),
    search() {
      this.MOD_SEARCH_WORD(this.searchWord);
      this.$router.push("/searchResult"); // 다른 뷰로 이동
    },
  },
};
</script>

<style scoped></style>

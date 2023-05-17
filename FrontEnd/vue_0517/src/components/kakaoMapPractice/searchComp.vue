<template>
  <div>
    <h1>searchComp, 여행지 검색 페이지</h1>
    <input v-model="searchInput" type="text" placeholder="지역을 검색하세요." />
    <button @click="search">검색</button>

    <!-- 지표 보여주기 -->
    <p></p>
    store : {{ searchWord }}
    <p></p>
    local : {{ searchInput }}
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

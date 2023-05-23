<template>
  <div>
    <div class="background-image"></div>
    <div class="search-container">
      <div class="search-wrapper">
        <input
          type="text"
          class="search-input"
          placeholder="여행지를 검색하세요!"
          v-model="searchValue"
        />
        <button class="search-button" @click="search">검색</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeSearchComp",
  components: {},
  computed: {},
  data() {
    return {
      searchValue: "", // 입력된 검색어를 저장할 데이터 속성
    };
  },
  methods: {
    search() {
      alert(this.searchValue + "A");
    },
  },
};
</script>

<style scoped>
@import url("@/assets/background/bg.css");
@import url("@/assets/search.css");
</style>

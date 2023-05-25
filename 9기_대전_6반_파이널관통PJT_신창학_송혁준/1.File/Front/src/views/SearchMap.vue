<template>
  <div class="container">
    <div class="top">
      <search-board></search-board>
    </div>
    <div class="bottom">
      <div class="left">
        <kakao-map></kakao-map>
      </div>
      <div class="right">
        <sido-info></sido-info>
      </div>
    </div>
  </div>
</template>

<script>
import { mapMutations } from "vuex";
import SearchBoard from "@/components/search/searchBoard.vue";
import kakaoMap from "@/components/maps/kakaoMap.vue";
import sidoInfo from "@/components/search/sidoInfo.vue";

export default {
  components: { SearchBoard, kakaoMap, sidoInfo },

  mounted() {
    this.SET_NOW_CONTENT_TYPE(0);
  },
  methods: {
    ...mapMutations("mapStore", ["SET_NOW_CONTENT_TYPE"]),
  },
};
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  height: 900px; /* 원하는 높이로 고정 */
  border: 2px solid #ccc; /* 테두리 스타일 추가 */
  border-radius: 5px; /* 테두리 둥글게 설정 */
  overflow: hidden; /* 내용이 넘칠 경우 숨김 처리 */
  box-shadow: 0 2px 20px rgba(0, 0, 0, 0.2); /* 그림자 효과 추가 */
}

.top {
  flex: 1; /* 상위 절반 공간을 차지 */
  margin-bottom: 1px;
  background-color: #f9fcff; /* 배경색 설정 */
  padding: 20px; /* 여백 추가 */

  display: flex;
  flex-direction: column;
  border: 2px solid #ffffff; /* 테두리 스타일 추가 */
  border-radius: 5px; /* 테두리 둥글게 설정 */
  overflow: hidden; /* 내용이 넘칠 경우 숨김 처리 */
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2); /* 그림자 효과 추가 */
}

.bottom {
  flex: 1; /* 하위 절반 공간을 차지 */
  display: flex;
  margin-bottom: 30px;
}

.left {
  flex: 1; /* 좌측 공간을 차지 */
  padding: 20px; /* 여백 추가 */
  background-color: #ffffff; /* 배경색 설정 */
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2); /* 그림자 효과 추가 */
}

.right {
  flex: 1; /* 우측 공간을 차지 */
  padding: 20px; /* 여백 추가 */
  background-color: #ffffff; /* 배경색 설정 */
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2); /* 그림자 효과 추가 */
}
</style>

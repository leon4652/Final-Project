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
import SearchBoard from "@/components/search/searchBoard.vue";
import kakaoMap from "@/components/maps/kakaoMap.vue";
import sidoInfo from "@/components/search/sidoInfo.vue";

export default {
  components: { SearchBoard, kakaoMap, sidoInfo },
};
</script>

<style>
.container {
  display: flex;
  flex-direction: column;
  height: 100vh; /* 전체 화면 높이 기준 */
}

.top {
  flex: 1; /* 상위 절반 공간을 차지 */
  margin-bottom: 1px;
}

.bottom {
  flex: 1; /* 하위 절반 공간을 차지 */
  display: flex;
}

.left {
  flex: 1; /* 좌측 공간을 차지 */
}

.right {
  flex: 1; /* 우측 공간을 차지 */
}
</style>

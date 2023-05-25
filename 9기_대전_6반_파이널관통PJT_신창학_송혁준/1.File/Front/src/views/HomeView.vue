<template>
  <div>
    <main-carousel></main-carousel>
    <div class="container">
      <div class="left-component">
        <!-- 왼쪽 컴포넌트의 내용 -->
        <notice-sub-list></notice-sub-list>
      </div>
      <div class="right-component">
        <!-- 오른쪽 컴포넌트의 내용 -->
        <story-board-sub-list></story-board-sub-list>
      </div>
    </div>
  </div>
</template>

<script>
import MainCarousel from '@/components/item/MainCarousel.vue';
import NoticeSubList from '@/components/notice/NoticeSubList.vue';
import StoryBoardSubList from '@/components/board/StoryBoardSubList.vue';

export default {
  name: 'HomeView',
  components: { MainCarousel, NoticeSubList, StoryBoardSubList },
};
</script>
<style scoped>
.container {
  display: flex; /* Flexbox 사용 */
  justify-content: space-between;
  /* margin-left: 10%;
    margin-right: 10%; */
  width: 80%;
}

.left-component,
.right-component {
  /* 각 컴포넌트가 화면의 50%를 차지하도록 설정 */
  width: 50%;
  /* 컴포넌트의 높이를 전체 화면 높이로 설정 */
  /* height: 100vh;  */
}
.left-component {
  /* background-color: aqua; */
  margin-right: 20px;
}
.right-component {
  /* background-color: brown; */
  margin-right: 20px;
}
</style>

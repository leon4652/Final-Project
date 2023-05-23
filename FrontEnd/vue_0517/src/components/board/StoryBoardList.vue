<template>
  <div>
    <!-- 
      글 작성 버튼으로 바꾸던지 수정 필요 
    -->
    <header class="top-menu con row">
      <div class="cell-right">
        <a href="#">회원가입 |</a>
        <a href="#">글 목록 |</a>
        <router-link :to="{ name: 'write' }">글 작성 |</router-link>
      </div>
    </header>

    <h1 class="con">게시글 목록</h1>
    <section class="article-list table-common con">
      <table border="1">
        <thead>
          <tr>
            <th>글 번호</th>
            <th>제목</th>
            <th>조회수</th>
            <th>작성자</th>
            <th>작성일</th>
          </tr>
        </thead>
        <tbody>
          <story-board-list-item v-for="board in storyBoards" :key="board.boardNo" v-bind="board" />
        </tbody>
      </table>
    </section>
  </div>
</template>

<script>
import StoryBoardListItem from "@/components/board/item/StoryBoardListItem.vue";
import { mapActions, mapState } from 'vuex';

const storyBoardStore = "storyBoardStore";

export default {
  name: 'StoryBoardList',
  components: {
    StoryBoardListItem
  },
  data() {
    return {
        boards: [],
    };
  },
  computed: {
    ...mapState(storyBoardStore, ['storyBoards'])
  },
  created() {
    // let param = {
    //   pg: 1,
    //   spp: 20,
    //   key: null,
    //   word: null,
    // };
    this.getStoryBoardList();
    this.boards = this.storyBoards;
  },
  methods : {
    ...mapActions(storyBoardStore, ['getStoryBoardList']),
  }
};
</script>

<style scoped>
@import url('@/assets/board/board.css');
</style>

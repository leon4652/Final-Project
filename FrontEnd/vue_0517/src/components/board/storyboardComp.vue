<template>
  <div>
    <header class="top-menu con row">
      <div class="cell-right">
        <a href="#">회원가입</a>
        <a href="#">글 목록</a>
        <a href="#">글 작성</a>
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
          <tr>
            <td>내용1</td>
            <td>내용2</td>
            <td>내용3</td>
            <td>내용4</td>
            <td>내용5</td>
          </tr>
          <story-board-list-item v-for="board in boards" :key="board.boardNo" v-bind="board" />
        </tbody>
      </table>
    </section>
  </div>
</template>

<script>
import StoryBoardListItem from "@/components/board/item/StoryBoardListItem.vue";
import { mapActions } from 'vuex';

const storyBoardStore = "storyBoardStore";

export default {
  name: 'storyBoardComp',
  components: {
    StoryBoardListItem
  },
  data() {
    return {
        boards: [],
    };
  },
  created() {
    let param = {
      pg: 1,
      spp: 20,
      key: null,
      word: null,
    };
    getStoryBoardList(
      param,
      ({ data }) => {
        this.articles = data;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  methods : {
    ...mapActions(storyBoardStore, ['getStoryBoardList']),
  }
};
</script>

<style scoped>
@import url('@/assets/board/board.css');
</style>

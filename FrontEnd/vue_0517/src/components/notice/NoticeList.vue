<template>
  <div>
    <!-- 
      글 작성 버튼으로 바꾸던지 수정 필요 
    -->
    <!-- <header class="top-menu con row">
      <div class="cell-right">
        <a href="#">회원가입 |</a>
        <a href="#">글 목록 |</a>
        <router-link :to="{ name: 'noticeWrite' }">글 작성 |</router-link>
      </div>
    </header> -->

    <h1 class="con">공지사항</h1>
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
          <notice-list-item v-for="notice in noticeList" :key="notice.noticeNo" v-bind="notice" />
        </tbody>
      </table>

      <b-col class="text-right">
        <b-button variant="info" @click="moveWrite">글 작성</b-button>
      </b-col>
    </section>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import NoticeListItem from "./item/NoticeListItem.vue";

const noticeStore = "noticeStore";

export default {
  name: "NoticeList",
  components: {
    NoticeListItem,
  },
  data() {
    return {
      noticeList: [],
    };
  },
  computed: {
    ...mapState(noticeStore, ["notices"]),
  },
  created() {
    // let param = {
    //   pg: 1,
    //   spp: 20,
    //   key: null,
    //   word: null,
    // };
    this.getNoticeList();
    this.noticeList = this.notices;
  },
  methods: {
    ...mapActions(noticeStore, ["getNoticeList"]),
    moveWrite() {
      this.$router.push({ name: "noticeWrite" });
    },
  },
};
</script>

<style scoped>
@import url("@/assets/board/board.css");
</style>

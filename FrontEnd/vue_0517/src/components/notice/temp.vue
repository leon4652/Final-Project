<template>
  <div>
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
          <notice-list-item v-for="notice in notices" :key="notice.noticeNo" v-bind="notice" />
        </tbody>
      </table>

      <b-col class="text-right" v-if="this.isAdmin === 1">
        <b-button variant="info" @click="moveWrite">글 작성</b-button>
      </b-col>
    </section>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import NoticeListItem from "./item/NoticeListItem.vue";
import jwt_decode from 'jwt-decode';

const noticeStore = "noticeStore";

export default {
  name: "NoticeList",
  components: {
    NoticeListItem,
  },
  data() {
    return {
      noticeList: [],
      isAdmin : '',
    };
  },
  computed: {
    ...mapState(noticeStore, ["notices"]),
  },
  watch: {
    notices(){
      this.noticeList = this.notices;
    }
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

    let user = jwt_decode(sessionStorage.getItem('access-token'));
    this.isAdmin = user.isAdmin;
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
/* @import url("@/assets/board/board.css"); */
</style>

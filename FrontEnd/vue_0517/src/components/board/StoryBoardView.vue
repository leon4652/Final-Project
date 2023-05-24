<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>글보기</h3></b-alert>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col class="text-left">
        <b-button variant="outline-primary" @click="moveList">목록</b-button>
      </b-col>
      <!-- 현재 로그인한 사람과 글쓴이가 같은 사람인지 확인 -->
      <b-col class="text-right" v-if="isWriter">
        <b-button variant="outline-info" size="sm" @click="moveModifyBoard" class="mr-2"
          >글수정</b-button
        >
        <b-button variant="outline-danger" size="sm" @click="deleteBoard">글삭제</b-button>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col>
        <b-card
          :header-html="`<h3>${board.storyBoardNo}.
          ${board.storyBoardTitle} [${board.storyBoardHit}]</h3><div><h6>${board.userId}</div><div>${board.registDate}</h6></div>`"
          class="mb-2"
          border-variant="dark"
          no-body
        >
          <b-card-body class="text-left">
            <!-- <div v-html="message"></div> -->
            <div v-html="`${board.storyBoardContent}`"></div>
          </b-card-body>
        </b-card>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapActions, mapState } from "vuex";
import jwt_decode from "jwt-decode";

const storyBoardStore = "storyBoardStore";

export default {
  name: "BoardDetail",
  data() {
    return {
      board: {},
      // 글쓴이와 현재 접속자가 같은지 확인하기 위한 변수
      isWriter: "",
    };
  },
  computed: {
    ...mapState(storyBoardStore, ["storyBoard", "isDelete", "isUpdate"]),
  },
  async created() {
    // 기존에 있는 board를 초기화
    this.board = {};
    // 링크에 있는 parameter인 storyBoardNo를 가져옴
    let param = this.$route.params.storyBoardNo;
    await this.getStoryBoard(param);
    this.board = this.storyBoard;

    // token에 있는 user 정보를 decode
    let user = jwt_decode(sessionStorage.getItem("access-token"));

    if (this.board.userNo === user.userNo) this.isWriter = true;
    else this.isWriter = false;
  },
  methods: {
    ...mapActions(storyBoardStore, ["getStoryBoard", "deleteStoryBoard"]),
    moveModifyBoard() {
      this.$router.replace({
        name: "storyboardModify",
        params: { storyBoardNo: this.board.storyBoardNo },
      });
    },
    async deleteBoard() {
      // 글 삭제 후 목록 리스트로 이동
      if (confirm("정말로 삭제?")) {
        await this.deleteStoryBoard(this.board.storyBoardNo);
        this.moveList();
      }
    },
    moveList() {
      this.$router.push({ name: "storyboard" });
    },
  },
};
</script>

<style></style>

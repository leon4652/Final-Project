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
        <b-button variant="outline-info" size="sm" @click="moveModifyArticle" class="mr-2">글수정</b-button>
        <b-button variant="outline-danger" size="sm" @click="deleteBoard">글삭제</b-button>
      </b-col>
      <!-- <b-col class="text-right" v-if="userInfo.userid === board.userNo">
        <b-button variant="outline-info" size="sm" @click="moveModifyArticle" class="mr-2">글수정</b-button>
        <b-button variant="outline-danger" size="sm" @click="deleteArticle">글삭제</b-button>
      </b-col> -->
    </b-row>
    <b-row class="mb-1">
      <b-col>
        <b-card
          :header-html="`<h3>${board.storyBoardNo}.
          ${board.storyBoardTitle} [${board.storyBoardHit}]</h3><div><h6>${board.userNo}</div><div>${board.registDate}</h6></div>`"
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

const storyBoardStore = "storyBoardStore";

export default {
  name: "BoardDetail",
  data() {
    return {
      board: {},
    };
  },
  computed: {
    ...mapState(storyBoardStore, ["storyBoard", 'isDelete', 'isUpdate']),
    // message() {
    //   if (this.article.content) return this.article.content.split("\n").join("<br>");
    //   return "";
    // },
  },
  created() {
    let param = this.$route.params.storyBoardNo;
    // getArticle(
    //   param,
    //   ({ data }) => {
    //     this.article = data;
    //   },
    //   (error) => {
    //     console.log(error);
    //   }
    // );
    this.getStoryBoard(param)
    this.board = this.storyBoard;
  },
  methods: {
    ...mapActions(storyBoardStore, ['getStoryBoard', 'deleteStoryBoard']),
    moveModifyArticle() {
      this.$router.replace({
        name: "boardmodify",
        params: { articleno: this.article.articleno },
      });
    },
    deleteBoard() {
      if (confirm("정말로 삭제?")) {
        this.deleteStoryBoard(this.board.storyBoardNo)
        // console.log("여기")
        // if (this.isDelete === true) {
        //     console.log("성공")
        // }

        // 삭제 성공하면 다시 목록으로 보내기
        // if (this.isDelete === true){
        //     this.this.$router.replace({
        //     name: "boarddelete",
        //     params: { articleno: this.article.articleno },
        //     });
        //     };
        // }


        // this.$router.replace({
        //   name: "boarddelete",
        //   params: { articleno: this.article.articleno },
        // });
      }
    },
    moveList() {
      this.$router.push({ name: "storyboard" });
    },
  },
};
</script>

<style></style>

<template>
  <b-row class="mb-1">
    <b-col style="text-align: left">
      <b-form @submit="onSubmit" @reset="onReset">
        <b-form-group id="userid-group" label="작성자:" label-for="userId" description="작성자를 입력하세요.">
          <b-form-input
            id="userId"
            :disabled="isUserid"
            v-model="board.userId"
            type="text"
            required
            ref="userId"
            readonly
          ></b-form-input>
        </b-form-group>

        <b-form-group id="subject-group" label="제목:" label-for="title" description="제목을 입력하세요.">
          <b-form-input
            id="title"
            v-model="board.storyBoardTitle"
            type="text"
            required
            ref="title"
            placeholder="제목 입력..."
          ></b-form-input>
        </b-form-group>

        <b-form-group id="content-group" label="내용:" label-for="content">
          <b-form-textarea
            id="content"
            v-model="board.storyBoardContent"
            placeholder="내용 입력..."
            rows="10"
            max-rows="15"
            ref="content"
          ></b-form-textarea>
        </b-form-group>
       <b-button type="submit" variant="primary" class="m-1" v-if="this.type === 'write'">글작성</b-button>
        <b-button type="submit" variant="primary" class="m-1" v-else>글수정</b-button>
        
        <b-button type="reset" variant="danger" class="m-1">초기화</b-button>
      </b-form>
    </b-col>
  </b-row>
</template>

<script>
import { mapActions, mapState } from 'vuex';
import jwt_decode from 'jwt-decode';

const storyBoardStore = "storyBoardStore";

export default {
  name: "StoryBoardInput",
  data() {
    return {
      board: {
        storyBoardNo: 0,
        userId: "",
        userName: "",
        userNo: "",
        storyBoardTitle: "",
        storyBoardContent: "",
      },
      isUserid: false,
    };
  },
  props: {
    type: { type: String },
  },
  computed: {
    ...mapState(storyBoardStore, ['storyBoard'])
  },
  async created() {
    if (this.type === "modify") {
      let param = this.$route.params.storyBoardNo;
      await this.getStoryBoard(param);
      this.board = this.storyBoard;
      this.isUserid = true;
    }
    let user = jwt_decode(sessionStorage.getItem('access-token'));
    this.board.userId = user.userId;
    this.board.userNo = user.userNo;
  },
  methods: {
    ...mapActions(storyBoardStore, ['writeStoryBoard', 'getStoryBoard', 'modifyStoryBoard']),
    async onSubmit(event) {
      event.preventDefault();

      let err = true;
      let msg = "";
      !this.board.userNo   && ((msg = "작성자 입력해주세요"), (err = false), this.$refs.userId.focus());
      err && !this.board.storyBoardTitle && ((msg = "제목 입력해주세요"), (err = false), this.$refs.title.focus());
      err && !this.board.storyBoardContent && ((msg = "내용 입력해주세요"), (err = false), this.$refs.content.focus());

      if (!err) alert(msg);
      else this.type === 'write' ? await this.writeStoryBoard(this.board) : await this.modifyStoryBoard(this.board);

      this.moveList();
    },
    onReset(event) {
      event.preventDefault();
      this.board.storyBoardNo = 0;
      this.board.storyBoardTitle = "";
      this.board.storyBoardContent = "";
      this.moveList();
    },
    moveList() {
      this.$router.push({ name: "storyboard" });
    },
  },
};
</script>

<style></style>
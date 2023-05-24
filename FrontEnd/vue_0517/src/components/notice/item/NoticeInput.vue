<template>
  <b-row class="mb-1">
    <b-col style="text-align: left">
      <b-form @submit="onSubmit" @reset="onReset">
        <b-form-group
          id="userid-group"
          label="작성자:"
          label-for="userId"
          description="작성자를 입력하세요."
        >
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

        <b-form-group
          id="subject-group"
          label="제목:"
          label-for="title"
          description="제목을 입력하세요."
        >
          <b-form-input
            id="title"
            v-model="board.noticeTitle"
            type="text"
            required
            ref="title"
            placeholder="제목 입력..."
          ></b-form-input>
        </b-form-group>

        <b-form-group id="content-group" label="내용:" label-for="content">
          <b-form-textarea
            id="content"
            v-model="board.noticeContent"
            placeholder="내용 입력..."
            rows="10"
            max-rows="15"
            ref="content"
          ></b-form-textarea>
        </b-form-group>
        <b-button type="submit" variant="primary" class="m-1" v-if="this.type === 'write'"
          >글작성</b-button
        >
        <b-button type="submit" variant="primary" class="m-1" v-else>글수정</b-button>

        <b-button type="reset" variant="danger" class="m-1">초기화</b-button>
      </b-form>
    </b-col>
  </b-row>
</template>

<script>
import { mapActions, mapState } from "vuex";
import jwt_decode from "jwt-decode";

const noticeStore = "noticeStore";

export default {
  name: "NoticeInput",
  data() {
    return {
      board: {
        noticeNo: 0,
        userId: "",
        userName: "",
        userNo: "",
        noticeTitle: "",
        noticeContent: "",
      },
      isUserid: false,
    };
  },
  props: {
    // <story-board-input type="write" />의 type 속성을 props
    type: { type: String },
  },
  computed: {
    ...mapState(noticeStore, ["notice"]),
  },
  async created() {
    if (this.type === "modify") {
      // 쿼리문에 내가 필요한 parameter가 있을때 params.변수명으로 접근
      let param = this.$route.params.noticeNo;
      await this.getNotice(param);
      console.dir(this.notice);
      this.board = this.notice;
      this.isUserid = true;
    }
    // 세션에서 정보 가져오기
    // jwt_decode inport하기
    let user = jwt_decode(sessionStorage.getItem("access-token"));
    this.board.userId = user.userId;
    this.board.userNo = user.userNo;
  },
  methods: {
    ...mapActions(noticeStore, ["writeNotice", "getNotice", "modifyNotice"]),
    async onSubmit(event) {
      event.preventDefault();

      let err = true;
      let msg = "";
      // 각 항목의 입력값이 있는지 확인, 없다면 해당 ref로 focus가 이동함
      !this.board.userNo &&
        ((msg = "작성자 입력해주세요"), (err = false), this.$refs.userId.focus());
      err &&
        !this.board.noticeTitle &&
        ((msg = "제목 입력해주세요"), (err = false), this.$refs.title.focus());
      err &&
        !this.board.noticeContent &&
        ((msg = "내용 입력해주세요"), (err = false), this.$refs.content.focus());

      if (!err) alert(msg);
      else
        this.type === "write"
          ? await this.writeNotice(this.board)
          : await this.modifyNotice(this.board);

      this.moveList();
    },
    onReset(event) {
      // 초기화 버튼 눌렀을 때 실행하는 함수
      event.preventDefault();
      this.board.noticeNo = 0;
      this.board.noticeTitle = "";
      this.board.noticeContent = "";
      this.moveList();
    },
    moveList() {
      this.$router.push({ name: "notice" });
    },
  },
};
</script>

<style scoped></style>

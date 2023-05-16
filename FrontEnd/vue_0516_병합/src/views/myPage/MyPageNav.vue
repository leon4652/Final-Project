<template>
  <div>
    <router-link to="/mypage/info">정보 조회</router-link> |
    <router-link to="/mypage/board">작성 게시글</router-link> |
    <router-link to="/mypage/comment">작성 댓글</router-link> |
    <!-- <my-page-info></my-page-info>
    <my-page-board></my-page-board>
    <my-page-comment></my-page-comment> -->
    
  </div>
</template>

<script>
// import MyPageInfo from "@/components/myPage/MyPageInfo.vue";
// import MyPageBoard from "@/components/myPage/MyPageBoard.vue";
// import MyPageComment from "@/components/myPage/MyPageComment.vue"


export default {
  name: "MypageNav",
  components: {   },
  data() {
    return {
      message: "",
    };
  },
  created() {},
  methods: {},
};
</script>

<style scoped></style>
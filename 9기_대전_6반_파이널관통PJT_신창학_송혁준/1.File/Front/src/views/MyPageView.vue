<template>
  <div>
    <!-- <router-link to="/mypage/info">정보 조회</router-link> |
    <router-link to="/mypage/board">작성 게시글</router-link> |
    <router-link to="/mypage/comment">작성 댓글</router-link> -->
    
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "MypageView",
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

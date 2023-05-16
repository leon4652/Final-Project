<template>
  <div>
    <!-- <router-link to="/mypage/info">정보 조회</router-link> | -->
    <!-- <my-page-info></my-page-info> -->
    <!-- <my-page-board></my-page-board> -->
    <!-- <my-page-nav></my-page-nav> -->
    <!-- <router-link to="/mypage/info">정보 조회</router-link> |
    <router-link to="/mypage/board">작성 게시글</router-link> |
    <router-link to="/mypage/comment">작성 댓글</router-link> | -->
    <my-page-nav></my-page-nav>
    <div>
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
// import MyPageNav from '@/components/myPage/myPageCommon/MyPageNav.vue';
import MyPageNav from "@/views/myPage/MyPageNav.vue"
// import MyPageInfo from "@/components/myPage/MyPageInfo.vue";
// import MyPageBoard from "@/components/myPage/MyPageBoard.vue";


export default {
  name: "MypageView",
  components: {MyPageNav   },
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

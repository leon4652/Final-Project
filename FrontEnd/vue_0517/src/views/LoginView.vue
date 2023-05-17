<template>
  <!-- <div>
    <h3>Login</h3>
     <b-form @submit="login">
      <b-row class="my-1">
        <b-col sm="3">
          <label for="username">Username:</label>
        </b-col>
        <b-col sm="9">
          <b-form-input id="username" type="text" v-model="username" required></b-form-input>
        </b-col>
      </b-row>
      <b-row class="my-1">
        <b-col sm="3">
          <label for="password">Password:</label>
        </b-col>
        <b-col sm="9">
          <b-form-input id="password" type="password" v-model="password" required></b-form-input>
        </b-col>
      </b-row>
      <b-button type="submit" variant="primary">Login</b-button>
    </b-form>
  </div> -->
    <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert variant="secondary" show><h3>로그인</h3></b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <b-card class="text-center mt-3" style="max-width: 40rem" align="left">
          <b-form class="text-left">
            <b-alert show variant="danger" v-if="isLoginError">아이디 또는 비밀번호를 확인하세요.</b-alert>
            <b-form-group label="아이디:" label-for="userid">
              <b-form-input
                id="userid"
                v-model="user.userid"
                required
                placeholder="아이디 입력...."
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="비밀번호:" label-for="userpwd">
              <b-form-input
                type="password"
                id="userpwd"
                v-model="user.userpwd"
                required
                placeholder="비밀번호 입력...."
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-button type="button" variant="primary" class="m-1" @click="confirm">로그인</b-button>
            <b-button type="button" variant="success" class="m-1" @click="movePage">회원가입</b-button>
          </b-form>
        </b-card>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container>
</template>

// <script>
// export default {
//   name: 'LoginView',
//   components: {},
//   data() {
//     return {
//       message: '',
//     };
//   },
//   created() {},
//   methods: {},
// };
// </script>

<script>
import { mapState, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
  name: "LoginView",
  data() {
    return {
      // isLoginError: false,
      user: {
        userid: null,
        userpwd: null,
      },
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "isLoginError", "userInfo"]),
  },
  methods: {
    ...mapActions(memberStore, ["userConfirm", "getUserInfo"]),
    async confirm() {
      await this.userConfirm(this.user);
      let token = sessionStorage.getItem("access-token");
      // console.log("1. confirm() token >> " + token);
      if (this.isLogin) {
        await this.getUserInfo(token);
        // console.log("4. confirm() userInfo :: ", this.userInfo);
        this.$router.push({ name: "main" });
      }
    },
    movePage() {
      this.$router.push({ name: "join" });
    },
  },
};
</script>

<style scoped></style>

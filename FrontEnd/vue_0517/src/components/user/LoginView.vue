<template>
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
            <b-alert show variant="danger" v-if="isFailLogin"
              >아이디 또는 비밀번호를 확인하세요.</b-alert
            >
            <b-form-group label="아이디:" label-for="userId">
              <b-form-input
                id="userId"
                v-model="user.userId"
                required
                placeholder="아이디 입력...."
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="비밀번호:" label-for="userPw">
              <b-form-input
                type="password"
                id="userPw"
                v-model="user.userPw"
                required
                placeholder="비밀번호 입력...."
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-button type="button" variant="primary" class="m-1 loginBtn" @click="confirm"
              >로그인</b-button
            >
            <b-button type="button" variant="success" class="m-1 signUp" @click="movePage"
              >회원가입</b-button
            >
          </b-form>
        </b-card>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapState, mapActions } from 'vuex';

const userStore = 'userStore';

export default {
  name: 'LoginView',
  data() {
    return {
      // isLoginError: false,
      user: {
        userId: null,
        userPw: null,
      },
      isFailLogin: false,
    };
  },
  computed: {
    ...mapState(userStore, ['isLogin', 'isLoginError', 'userInfo']),
  },

  methods: {
    ...mapActions(userStore, ['userConfirm', 'getUserInfo']),
    async confirm() {
      await this.userConfirm(this.user);
      let token = sessionStorage.getItem('access-token');
      if (this.isLogin) {
        await this.getUserInfo(token);
        this.$router.push({ name: 'Home' });
        // location.reload();
      } else {
        this.isFailLogin = true;
      }
    },
    movePage() {
      this.$router.push({ name: 'signup' });
    },
  },
};
</script>

<style scoped>
.loginBtn {
  background-color: #00c9ff;
  border: none;
}
.loginBtn:hover {
  background-color: #0586aa;
}
.signUp {
    background-color: #23d335;
  border: none;
}
.signUp:hover {
    background-color: #14a323;
  border: none;
}
</style>

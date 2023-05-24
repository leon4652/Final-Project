<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="danger">
      <b-navbar-brand class="routerLink">
        <router-link to="/">Home</router-link>
      </b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item><router-link to="/storyboard">자유게시판</router-link></b-nav-item>
          <b-nav-item><router-link to="/notice">공지사항</router-link></b-nav-item>
          <b-nav-item><router-link to="/searchMap">여행지 검색</router-link></b-nav-item>
          <b-nav-item><router-link to="/searchResult">여행지 검색 결과</router-link></b-nav-item>
        </b-navbar-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
          <b-nav-form>
            <b-form-input size="m" class="mr-sm-2" placeholder="여행지를 검색하세요"></b-form-input>
            <b-button size="m" class="my-2 my-sm-0" type="submit">검색</b-button>
          </b-nav-form>

          <!-- 로그인 전 -->
          <div class="loginBtn" v-if="!isLogin">
            <b-button @click="moveLogin">로그인</b-button>
          </div>

          <div v-if="isLogin">
            <b-nav-item-dropdown right>
              <!-- Using 'button-content' slot -->
              <template #button-content>
                <em>{{user.userId}}</em>
              </template>
              <b-dropdown-item href=""><router-link to="/mypage">Profile</router-link></b-dropdown-item>
              <b-dropdown-item href="" @click="logout">Sign Out</b-dropdown-item>
            </b-nav-item-dropdown>
          </div>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
import jwtDecode from "jwt-decode";

import { mapMutations, mapState } from "vuex";

const userStore = "userStore";

export default {
  name: "NavBar",
  components: {},
  data() {
    return {
      user: {
        userId: "",
        userName: "",
      },
    };
  },
  computed: {
    ...mapState(userStore, ["isLogin", "userInfo"]),
  },
  created() {
    if (sessionStorage.getItem("access-token")) {
      this.user = jwtDecode(sessionStorage.getItem("access-token"));
    }
  },
  methods: {
    ...mapMutations(userStore, ["SET_LOGOUT"]),
    logout() {
      this.SET_LOGOUT();
      location.reload();
    },
    moveLogin() {
      // this.$router.push({ name: "login" });
      this.$router.push({ name: "login" }).catch((err) => {
        if (err.name !== "NavigationDuplicated") {
          throw err;
        }
      });
    },
  },
};
</script>

<style scoped>
.loginBtn {
  margin-left: 5px;
}
.routerLink{
  text-decoration: none !important;
}
</style>

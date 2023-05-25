<template>
  <div class="navbarContainer">
    <b-navbar
      toggleable="lg"
      type="dark"
      variant="light"
      class="gradient-navbar"
    >
      <b-navbar-brand class="routerLink">
        <router-link to="/">Home</router-link>
      </b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav class="routerLink">
          <b-nav-item
            ><router-link to="/storyboard">자유게시판</router-link></b-nav-item
          >
          <b-nav-item
            ><router-link to="/notice">공지사항</router-link></b-nav-item
          >
          <b-nav-item
            ><router-link to="/searchMap">여행지 검색</router-link></b-nav-item
          >
          <b-nav-item
            ><router-link to="/rsMain"
              >여행지 검색 결과</router-link
            ></b-nav-item
          >
        </b-navbar-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
          <b-nav-form>
            <b-form-input
              size="m"
              class="mr-sm-2"
              placeholder="여행지를 검색하세요"
              v-model="keyWord"
            ></b-form-input>
            <b-button
              size="m"
              class="my-2 my-sm-0"
              type="submit"
              @click="searchKeyWord"
              >검색</b-button
            >
          </b-nav-form>

          <!-- 로그인 전 -->
          <div v-if="!isLogin">
            <b-button class="loginBtn" @click="moveLogin">로그인</b-button>
          </div>

          <div v-if="isLogin">
            <b-nav-item-dropdown right>
              <!-- Using 'button-content' slot -->
              <template #button-content>
                <em>{{ user.userId }}</em>
              </template>
              <b-dropdown-item href="">
                <router-link to="/mypage" class="profileLink"
                  >Profile</router-link
                >
              </b-dropdown-item>
              <b-dropdown-item href="" @click="logout"
                >Sign Out</b-dropdown-item
              >
            </b-nav-item-dropdown>
          </div>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
import axios from "axios";
import jwtDecode from "jwt-decode";

import { mapMutations, mapState, mapActions } from "vuex";
const userStore = "userStore";

export default {
  name: "NavBar",
  components: {},
  data() {
    return {
      user: {
        userId: "",
        userName: "",
        keyWord: "",
      },
    };
  },
  computed: {
    ...mapState(userStore, ["isLogin", "userInfo"]),
  },
  watch: {
    isLogin() {
      this.parseUser();
    },
  },
  created() {
    if (sessionStorage.getItem("access-token")) {
      this.user = jwtDecode(sessionStorage.getItem("access-token"));
    }
  },
  methods: {
    ...mapMutations(userStore, ["SET_LOGOUT"]),
    ...mapActions("mapStore", ["searchKeyWord"]),
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
    parseUser() {
      if (sessionStorage.getItem("access-token")) {
        this.user = jwtDecode(sessionStorage.getItem("access-token"));
      }
    },
    async searchKeyWord() {
      alert(process.env.VUE_APP_API_BASE_URL + `attraction/search/keyword/${this.keyWord}`)
      await axios
        .get(
          process.env.VUE_APP_API_BASE_URL + `attraction/search/keyword/`
        )
        .then((response) => {
          alert("진입")
          console.dir(response);

        })
        .catch((error) => {
          console.error(error);
        });
      alert("끝");
    },
  },
};
</script>

<style scoped>
.navbarContainer {
  margin-bottom: 20px;
}
.gradient-navbar {
  /* background: linear-gradient(to right, #ff8a00, #e52e71); */
  /* 그라데이션 색상 설정 */
  /* #FF9F00와 #FFD700 */
  /* #FF6B6B와 #F8B500 */
  /* #F7971E와 #FFD200 */
  /* #FF416C와 #FF4B2B */
  background: linear-gradient(to right, #00c9ff, #92fe9d);
}
.loginBtn {
  margin-left: 5px;
  background-color: #ff8a00;
  color: white;
  border: none;
}
.loginBtn:hover {
  background-color: orange;
}
a {
  color: white;
}
a:hover {
  /* 마우스 올리면 글자 색 바꾸는 코드 */
  text-decoration: none;
  color: black;
}
.profileLink {
  color: black;
}
em {
  color: black;
  opacity: 0.7;
}
</style>

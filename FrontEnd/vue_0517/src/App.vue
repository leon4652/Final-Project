<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/storyboard">자유게시판</router-link> |
      <router-link to="/notice">공지사항</router-link> |
      <router-link to="/searchMap">여행지 검색</router-link> |
      <router-link to="/searchResult">여행지 검색 결과</router-link> |

      <!-- 로그인 전-->
      <template v-if="!isLogin"> <router-link to="/user/login">로그인</router-link> | </template>
      <!-- 로그인 후 -->
      <template v-if="isLogin">
        <router-link to="/mypage">마이페이지</router-link> |
        <span>{{ user.userId }}({{ user.userName }}) |</span>
        <span @click="logout">로그아웃</span>
      </template>
    </div>
    <router-view />
  </div>
</template>

<script>
import jwtDecode from 'jwt-decode';
import { mapMutations, mapState } from 'vuex';

const userStore = 'userStore';

export default {
  name: 'app',
  components: {},
  data() {
    return {
      user: {
        userId: '',
        userName: '',
      },
    };
  },
  computed: {
    ...mapState(userStore, ['isLogin', 'userInfo']),
  },
  created() {
    // 아이디랑 이름 나오고 싶은데
    if (sessionStorage.getItem('access-token')) {
      this.user = jwtDecode(sessionStorage.getItem('access-token'));
      // let id = jwtDecode(sessionStorage.getItem("userId"));
      // let name = jwtDecode(sessionStorage.getItem("userName"));
      // this.userId = id;
      // this.userName = name;
    }
  },
  methods: {
    ...mapMutations(userStore, ['SET_LOGOUT']),
    logout() {
      // 로그아웃하면 바로 로그아웃만 되는 문제 발생 -> 새로고침이 되면 좋겠음
      // 밑에 코드를 다 실행 안함

      this.SET_LOGOUT();

      location.reload();
    },
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>

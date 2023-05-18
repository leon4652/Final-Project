import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "@/views/HomeView.vue";

import SearchMap from "@/views/SearchMap.vue"; //검색하는 창
import SearchResult from "@/views/SearchResult.vue"; //검색결과 창
import SRView1 from "@/views/SearchResult/SRView1.vue"; //검색결과 창 자식 1
import SRView2 from "@/views/SearchResult/SRView2.vue"; //검색결과 창 자식 2
import SRView3 from "@/views/SearchResult/SRView3.vue"; //검색결과 창 자식 3
import SRView4 from "@/views/SearchResult/SRView4.vue"; //검색결과 창 자식 4
import SRView5 from "@/views/SearchResult/SRView5.vue"; //검색결과 창 자식 5
import SRViewERR from "@/views/SearchResult/SRViewERR.vue"; //검색결과 창 - ERR

import MypageView from "@/views/MyPageView.vue"; // 마이페이지
import UserView from "@/views/UserView.vue"; // 로그인

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: HomeView,
  },
  {
    path: "/searchMap",
    name: "SearchMap",
    component: SearchMap,
  },
  {
    path: "/searchResult",
    name: "SearchResult",
    component: SearchResult,
    children: [
      //자식 컴포넌트 선언
      {
        path: "/srView1",
        name: "SRView1",
        component: SRView1,
      },
      {
        path: "/srView2",
        name: "SRView2",
        component: SRView2,
      },
      {
        path: "/srView3",
        name: "SRView3",
        component: SRView3,
      },
      {
        path: "/srView4",
        name: "SRView4",
        component: SRView4,
      },
      {
        path: "/srView5",
        name: "SRView5",
        component: SRView5,
      },
      {
        path: "/srViewERR",
        name: "SRViewERR",
        component: SRViewERR,
      },
    ],
  },
  {
    path: "/mypage",
    name: "myPage",
    component: MypageView,
    children: [
      {
        path: "info",
        name: "myPageInfo",
        component: () =>
          import(
            /* webpackChunkName: "myPage" */ "@/components/myPage/MyPageInfo.vue"
          ),
      },
      {
        path: "board",
        name: "myPageBoard",
        component: () =>
          import(
            /* webpackChunkName: "myPage" */ "@/components/myPage/MyPageBoard.vue"
          ),
      },
      {
        path: "comment",
        name: "myPageComment",
        component: () =>
          import(
            /* webpackChunkName: "myPage" */ "@/components/myPage/MyPageComment.vue"
          ),
      },
    ],
  },
  {
    path: "/user",
    name: "user",
    component: UserView,
    children: [
      {
        path: "login",
        name: "login",
        component: () =>
          import(
            /* webpackChunkName: "user" */ "@/components/user/LoginView.vue"
          ),
      },
      {
        path: "logout",
        name: "logout",
        component: () =>
          import(/* webpackChunkName: "user" */ "@/components/user/SignUp.vue"),
      },
      {
        path: "signup",
        name: "signup",
        component: () =>
          import(/* webpackChunkName: "user" */ "@/components/user/SignUp.vue"),
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;

import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "@/views/HomeView.vue";

import SearchMap from "@/views/SearchMap.vue"; //검색하는 창
import SearchResult from "@/views/SearchResult.vue"; //검색결과 창

import rsSetPlan from "@/views/SearchResult/00_setPlan.vue";
import rsMain from "@/views/SearchResult/01_main.vue";
import rsTravel from "@/views/SearchResult/02_travel.vue";
import rsCulture from "@/views/SearchResult/03_culture.vue";
import rsFestival from "@/views/SearchResult/04_festival.vue";
import rsPlan from "@/views/SearchResult/05_plan.vue";
import rsLeisure from "@/views/SearchResult/06_leisure.vue";
import rsAmenity from "@/views/SearchResult/07_amenity.vue";
import rsShopping from "@/views/SearchResult/08_shopping.vue";
import rsRestaurant from "@/views/SearchResult/09_restaurant.vue";
import rsReview from "@/views/SearchResult/10_review.vue";
import SRViewERR from "@/views/SearchResult/SRViewERR";

import StoryBoard from "@/views/board/storyBoard.vue"; // 자유게시판

import MypageView from "@/views/MyPageView.vue"; // 마이페이지
import UserView from "@/views/UserView.vue"; // 로그인

Vue.use(VueRouter);

const routes = [
  {
    path: "/storyBoard",
    name: "storyBoard",
    component: StoryBoard,
  },
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
        path: "/rsSetPlan",
        name: "/rsSetPlan",
        component: rsSetPlan,
      },
      {
        path: "/rsMain",
        name: "rsMain",
        component: rsMain,
      },
      {
        path: "/rsTravel",
        name: "rsTravel",
        component: rsTravel,
      },
      {
        path: "/rsCulture",
        name: "rsCulture",
        component: rsCulture,
      },
      {
        path: "/rsFestival",
        name: "rsFestival",
        component: rsFestival,
      },
      {
        path: "/rsPlan",
        name: "rsPlan",
        component: rsPlan,
      },
      {
        path: "/rsLeisure",
        name: "rsLeisure",
        component: rsLeisure,
      },
      {
        path: "/rsAmenity",
        name: "rsAmenity",
        component: rsAmenity,
      },
      {
        path: "/rsShopping",
        name: "rsShopping",
        component: rsShopping,
      },
      {
        path: "/rsRestaurant",
        name: "rsRestaurant",
        component: rsRestaurant,
      },
      {
        path: "/rsReview",
        name: "rsReview",
        component: rsReview,
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

  {
    path: "/storyboard",
    name: "storyboard",
    component: StoryBoard,
    children: [],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;

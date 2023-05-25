import Vue from "vue";
import VueRouter from "vue-router";
import store from "@/store";

Vue.use(VueRouter);

// https://v3.router.vuejs.org/kr/guide/advanced/navigation-guards.html
const onlyAuthUser = async (to, from, next) => {
  const checkUserInfo = store.getters["userStore/checkUserInfo"];
  const checkToken = store.getters["userStore/checkToken"];
  let token = sessionStorage.getItem("access-token");
  console.log("로그인 처리 전", checkUserInfo, token);

  if (checkUserInfo != null && token) {
    console.log("토큰 유효성 체크하러 가자!!!!");
    await store.dispatch("userStore/getUserInfo", token);
  }
  if (!checkToken || checkUserInfo === null) {
    alert("로그인이 필요한 페이지입니다..");
    router.push({ name: "login" });
  } else {
    console.log("로그인 했다!!!!!!!!!!!!!.");
    next();
  }
};

const routes = [
  {
    path: "/",
    name: "Home",
    component: () => import(/* webpackChunkName: "Home" */ "@/views/HomeView.vue"),
  },
  {
    path: "/searchMap",
    name: "SearchMap",
    component: () => import(/* webpackChunkName: "SearchMap" */ "@/views/SearchMap.vue"),
  },
  {
    path: "/searchResult",
    name: "SearchResult",
    component: () => import(/* webpackChunkName: "SearchResult" */ "@/views/SearchResult.vue"),
    children: [
      //자식 컴포넌트 선언
      {
        path: "/rsSetPlan",
        name: "rsSetPlan",
        component: () =>
          import(/* webpackChunkName: "SearchResult" */ "@/views/SearchResult/00_setPlan.vue"),
      },
      {
        path: "/rsMain",
        name: "rsMain",
        component: () =>
          import(/* webpackChunkName: "SearchResult" */ "@/views/SearchResult/01_main.vue"),
      },
      {
        path: "/rsTravel",
        name: "rsTravel",
        component: () =>
          import(/* webpackChunkName: "SearchResult" */ "@/views/SearchResult/02_travel.vue"),
      },
      {
        path: "/rsCulture",
        name: "rsCulture",
        component: () =>
          import(/* webpackChunkName: "SearchResult" */ "@/views/SearchResult/03_culture.vue"),
      },
      {
        path: "/rsFestival",
        name: "rsFestival",
        component: () =>
          import(/* webpackChunkName: "SearchResult" */ "@/views/SearchResult/04_festival.vue"),
      },
      {
        path: "/rsPlan",
        name: "rsPlan",
        component: () =>
          import(/* webpackChunkName: "SearchResult" */ "@/views/SearchResult/05_plan.vue"),
      },
      {
        path: "/rsLeisure",
        name: "rsLeisure",
        component: () =>
          import(/* webpackChunkName: "SearchResult" */ "@/views/SearchResult/06_leisure.vue"),
      },
      {
        path: "/rsAmenity",
        name: "rsAmenity",
        component: () =>
          import(/* webpackChunkName: "SearchResult" */ "@/views/SearchResult/07_amenity.vue"),
      },
      {
        path: "/rsShopping",
        name: "rsShopping",
        component: () =>
          import(/* webpackChunkName: "SearchResult" */ "@/views/SearchResult/08_shopping.vue"),
      },
      {
        path: "/rsRestaurant",
        name: "rsRestaurant",
        component: () =>
          import(/* webpackChunkName: "SearchResult" */ "@/views/SearchResult/09_restaurant.vue"),
      },
      {
        path: "/rsReview",
        name: "rsReview",
        component: () =>
          import(/* webpackChunkName: "SearchResult" */ "@/views/SearchResult/10_review.vue"),
      },
      {
        path: "/srViewERR",
        name: "SRViewERR",
        component: () =>
          import(/* webpackChunkName: "SearchResult" */ "@/views/SearchResult/SRViewERR"),
      },
    ],
  },
  {
    path: "/mypage",
    name: "myPage",
    redirect: "/myPage/info",
    component: () => import(/* webpackChunkName: "myPage" */ "@/views/MyPageView.vue"),
    children: [
      {
        path: "info",
        name: "myPageInfo",
        beforeEnter: onlyAuthUser,
        component: () =>
          import(/* webpackChunkName: "myPage" */ "@/components/myPage/MyPageInfo.vue"),
      },
      {
        path: "board",
        name: "myPageBoard",
        beforeEnter: onlyAuthUser,
        component: () =>
          import(/* webpackChunkName: "myPage" */ "@/components/myPage/MyPageBoard.vue"),
      },
      {
        path: "comment",
        name: "myPageComment",
        beforeEnter: onlyAuthUser,
        component: () =>
          import(/* webpackChunkName: "myPage" */ "@/components/myPage/MyPageComment.vue"),
      },
    ],
  },
  {
    path: "/user",
    name: "user",
    component: () => import(/* webpackChunkName: "user" */ "@/views/UserView.vue"),
    children: [
      {
        path: "login",
        name: "login",
        component: () => import(/* webpackChunkName: "user" */ "@/components/user/LoginView.vue"),
      },
      {
        path: "logout",
        name: "logout",
        component: () => import(/* webpackChunkName: "user" */ "@/components/user/SignUp.vue"),
      },
      {
        path: "signup",
        name: "signup",
        component: () => import(/* webpackChunkName: "user" */ "@/components/user/SignUp.vue"),
      },
    ],
  },
  {
    path: "/storyboard",
    name: "storyboard",
    component: () => import(/* webpackChunkName: "storyboard" */ "@/views/board/StoryBoard.vue"),
    redirect: "/storyboard/list",
    children: [
      {
        path: "list",
        name: "storyboardList",
        component: () =>
          import(/* webpackChunkName: "storyboard" */ "@/components/board/StoryBoardList.vue"),
      },
      {
        path: "info/:storyBoardNo",
        name: "storyboardView",
        component: () =>
          import(/* webpackChunkName: "storyboard" */ "@/components/board/StoryBoardView.vue"),
      },
      {
        path: "write",
        name: "storyboardWrite",
        beforeEnter: onlyAuthUser,
        component: () =>
          import(/* webpackChunkName: "storyboard" */ "@/components/board/StoryBoardWrite.vue"),
      },
      {
        path: "modify/:storyBoardNo",
        name: "storyboardModify",
        beforeEnter: onlyAuthUser,
        component: () =>
          import(/* webpackChunkName: "storyboard" */ "@/components/board/StoryBoardModify.vue"),
      },
    ],
  },
  {
    path: "/notice",
    name: "notice",
    component: () => import(/* webpackChunkName: "notice" */ "@/views/Notice.vue"),
    redirect: "/notice/list",
    children: [
      {
        path: "list",
        name: "noticeList",
        component: () =>
          import(/* webpackChunkName: "notice" */ "@/components/notice/NoticeList.vue"),
      },
      {
        path: "info/:noticeNo",
        name: "noticeView",
        component: () =>
          import(/* webpackChunkName: "notice" */ "@/components/notice/NoticeView.vue"),
      },
      {
        path: "write",
        name: "noticeWrite",
        beforeEnter: onlyAuthUser,
        component: () =>
          import(/* webpackChunkName: "notice" */ "@/components/notice/NoticeWrite.vue"),
      },
      {
        path: "modify/:noticeNo",
        name: "noticeModify",
        beforeEnter: onlyAuthUser,
        component: () =>
          import(/* webpackChunkName: "notice" */ "@/components/notice/NoticeModify.vue"),
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

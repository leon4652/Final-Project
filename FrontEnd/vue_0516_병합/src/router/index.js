import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "@/views/HomeView.vue";
import kakaoMap from "@/views/KakaoMap.vue"; //카카오 지도 API
import SearchMap from "@/views/SearchMap.vue"; //검색하는 창
import SearchResult from "@/views/SearchResult.vue"; //검색결과 창
import SRView1 from "@/views/SearchResult/SRView1.vue"; //검색결과 창 자식 1

import MypageView from "@/views/MyPageView.vue";
import MyPageInfo from "@/components/myPage/MyPageInfo.vue";
import MyPageBoard from "@/components/myPage/MyPageBoard.vue";
import MyPageComment from "@/components/myPage/MyPageComment.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: HomeView,
  },

  {
    path: "/kakaoMap",
    name: "kakaoMap",
    component: kakaoMap,
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
    ],
  },
  {
    path: "/mypage",
    name: "myPage",
    component: MypageView,
    children: [
      {
        path: "/info",
        name: "myPageInfo",
        component: MyPageInfo,
      },
      {
        path: "/board",
        name: "myPageBoard",
        component: MyPageBoard,
      },
      {
        path: "/comment",
        name: "myPageComment",
        component: MyPageComment,
      },
    ]
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;

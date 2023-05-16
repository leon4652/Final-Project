import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "@/views/HomeView.vue";
import Step00View from "@/views/Step00View.vue";
import Step01View from "@/views/Step01View.vue";
import Step02View from "@/views/Step02View.vue";
import Step03View from "@/views/Step03View.vue";
import Step04View from "@/views/Step04View.vue";
import Step05View from "@/views/Step05View.vue";
import Step06View from "@/views/Step06View.vue";
import Step07View from "@/views/Step07View.vue";
import kakaoMap from "@/views/KakaoMap.vue"; //카카오 지도 API
import SearchMap from "@/views/SearchMap.vue"; //검색하는 창
import SearchResult from "@/views/SearchResult.vue"; //검색결과 창
import SRView1 from "@/views/SearchResult/SRView1.vue"; //검색결과 창 자식 1

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: HomeView,
  },
  {
    path: "/step00",
    name: "Step00",
    component: Step00View,
  },
  {
    path: "/step01",
    name: "Step01",
    component: Step01View,
  },
  {
    path: "/step02",
    name: "Step02",
    component: Step02View,
  },
  {
    path: "/step03",
    name: "Step03",
    component: Step03View,
  },
  {
    path: "/step04",
    name: "Step04",
    component: Step04View,
  },
  {
    path: "/step05",
    name: "Step05",
    component: Step05View,
  },
  {
    path: "/step06",
    name: "Step06",
    component: Step06View,
  },
  {
    path: "/step07",
    name: "Step07",
    component: Step07View,
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
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;

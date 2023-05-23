import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import(/* webpackChunkName: "Home" */ '@/views/HomeView.vue'),
  },
  {
    path: '/searchMap',
    name: 'SearchMap',
    component: () => import(/* webpackChunkName: "SearchMap" */ '@/views/SearchMap.vue'),
  },
  {
    path: '/searchResult',
    name: 'SearchResult',
    component: () => import(/* webpackChunkName: "SearchResult" */ '@/views/SearchResult.vue'),
    children: [
      //자식 컴포넌트 선언
      {
        path: '/rsSetPlan',
        name: 'rsSetPlan',
        component: () => import(/* webpackChunkName: "SearchResult" */ '@/views/SearchResult/00_setPlan.vue'),
      },
      {
        path: '/rsMain',
        name: 'rsMain',
        component: () => import(/* webpackChunkName: "SearchResult" */ '@/views/SearchResult/01_main.vue'),
      },
      {
        path: '/rsTravel',
        name: 'rsTravel',
        component: () => import(/* webpackChunkName: "SearchResult" */ '@/views/SearchResult/02_travel.vue'),
      },
      {
        path: '/rsCulture',
        name: 'rsCulture',
        component: () => import(/* webpackChunkName: "SearchResult" */ '@/views/SearchResult/03_culture.vue'),
      },
      {
        path: '/rsFestival',
        name: 'rsFestival',
        component: () => import(/* webpackChunkName: "SearchResult" */ '@/views/SearchResult/04_festival.vue'),
      },
      {
        path: '/rsPlan',
        name: 'rsPlan',
        component: () => import(/* webpackChunkName: "SearchResult" */ '@/views/SearchResult/05_plan.vue'),
      },
      {
        path: '/rsLeisure',
        name: 'rsLeisure',
        component: () => import(/* webpackChunkName: "SearchResult" */ '@/views/SearchResult/06_leisure.vue'),
      },
      {
        path: '/rsAmenity',
        name: 'rsAmenity',
        component: () => import(/* webpackChunkName: "SearchResult" */ '@/views/SearchResult/07_amenity.vue'),
      },
      {
        path: '/rsShopping',
        name: 'rsShopping',
        component: () => import(/* webpackChunkName: "SearchResult" */ '@/views/SearchResult/08_shopping.vue'),
      },
      {
        path: '/rsRestaurant',
        name: 'rsRestaurant',
        component: () => import(/* webpackChunkName: "SearchResult" */ '@/views/SearchResult/09_restaurant.vue'),
      },
      {
        path: '/rsReview',
        name: 'rsReview',
        component: () => import(/* webpackChunkName: "SearchResult" */ '@/views/SearchResult/10_review.vue'),
      },
      {
        path: '/srViewERR',
        name: 'SRViewERR',
        component: () => import(/* webpackChunkName: "SearchResult" */ '@/views/SearchResult/SRViewERR'),
      },
    ],
  },
  {
    path: '/mypage',
    name: 'myPage',
    component: () => import(/* webpackChunkName: "myPage" */ '@/views/MyPageView.vue'),
    children: [
      {
        path: 'info',
        name: 'myPageInfo',
        component: () =>
          import(/* webpackChunkName: "myPage" */ '@/components/myPage/MyPageInfo.vue'),
      },
      {
        path: 'board',
        name: 'myPageBoard',
        component: () =>
          import(/* webpackChunkName: "myPage" */ '@/components/myPage/MyPageBoard.vue'),
      },
      {
        path: 'comment',
        name: 'myPageComment',
        component: () =>
          import(/* webpackChunkName: "myPage" */ '@/components/myPage/MyPageComment.vue'),
      },
    ],
  },
  {
    path: '/user',
    name: 'user',
    component: () => import(/* webpackChunkName: "user" */ '@/views/UserView.vue'),
    children: [
      {
        path: 'login',
        name: 'login',
        component: () => import(/* webpackChunkName: "user" */ '@/components/user/LoginView.vue'),
      },
      {
        path: 'logout',
        name: 'logout',
        component: () => import(/* webpackChunkName: "user" */ '@/components/user/SignUp.vue'),
      },
      {
        path: 'signup',
        name: 'signup',
        component: () => import(/* webpackChunkName: "user" */ '@/components/user/SignUp.vue'),
      },
    ],
  },
  {
    path: '/storyboard',
    name: 'storyboard',
    component: () => import(/* webpackChunkName: "storyboard" */ '@/views/board/StoryBoard.vue'),
    redirect: '/storyboard/list',
    children: [
      {
        path: 'list',
        name: 'storyboardlist',
        component: () =>
          import(/* webpackChunkName: "storyboard" */ '@/components/board/StoryBoardList.vue'),
      },
      {
        path: 'info/:storyBoardNo',
        name: 'boardview',
        component: () =>
          import(/* webpackChunkName: "storyboard" */ '@/components/board/StoryBoardView.vue'),
      },
      {
        path: 'write',
        name: 'write',
        component: () =>
          import(
            /* webpackChunkName: "storyboard" */ '@/components/board/StoryBoardWrite.vue'
          ),
      },
      {
        path: 'modify/:storyBoardNo',
        name: 'modify',
        component: () =>
          import(
            /* webpackChunkName: "storyboard" */ '@/components/board/StoryBoardModify.vue'
          ),
      },
    ],
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;

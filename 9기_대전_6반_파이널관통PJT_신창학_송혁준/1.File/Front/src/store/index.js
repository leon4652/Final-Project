// import http from "@/api/http";
import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

import mapStore from "./modules/mapStore";
import myPageStore from "./modules/myPageStore";
import userStore from "./modules/userStore";
import itemStore from "./item/itemStore";
import storyBoardStore from "./modules/storyBoardStore";
import noticeStore from "./modules/noticeStore";

//step01;
export default new Vuex.Store({
  modules: {
    mapStore,
    myPageStore,
    userStore,
    itemStore,
    storyBoardStore,
    noticeStore,
  },
  plugins: [
    createPersistedState({
      // 브라우저 종료시 제거하기 위해 localStorage가 아닌 sessionStorage로 변경. (default: localStorage)
      storage: sessionStorage,
    }),
  ],
});

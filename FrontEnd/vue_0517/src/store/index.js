// import http from "@/api/http";
import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

import mapStore from './modules/mapStore';
import myPage from './modules/myPage';
import login from './modules/login'
import userStore from './modules/userStore'

import itemStore from './item/itemStore';

//step01;
export default new Vuex.Store({
  modules: {
    mapStore,
    myPage,
    login,
    userStore,
    itemStore,
  },
});

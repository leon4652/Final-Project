import http from "@/api/http";
import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

import mapStore from "./modules/mapStore";

//step01;
export default new Vuex.Store({
  modules: {
    mapStore,
  },
  state: {
    sidos: [{ value: null, text: "선택하세요" }],
    guguns: [{ value: null, text: "선택하세요" }],
  },
  mutations: {
    SET_SIDO_LIST(state, sidos) {
      sidos.forEach((sido) => {
        state.sidos.push({ value: sido.sidoCode, text: sido.sidoName });
      });
    },
    SET_GUGUN_LIST(state, guguns) {
      guguns.forEach((gugun) => {
        state.guguns.push({ value: gugun.gugunCode, text: gugun.gugunName });
      });
    },
  },
  getters: {},
  actions: {
    getSido({ commit }) {
      http
        .get(`/api/attraction/sido`)
        .then(({ data }) => {
          console.log(data);
          commit("SET_SIDO_LIST", data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getGugun({ commit }, sidoCode) {
      // const params = { sido: sidoCode };
      http
        .get(`/api/attraction/gugun/` + sidoCode)
        .then(({ data }) => {
          commit("SET_GUGUN_LIST", data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
});

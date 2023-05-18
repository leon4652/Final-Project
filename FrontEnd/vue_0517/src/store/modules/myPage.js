import { apiInstance } from '@/api/http';

const myPage = {
  state: {
    sidos: [{ value: null, text: '선택하세요' }],
    guguns: [{ value: null, text: '선택하세요' }],
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
      apiInstance
        .get(`/api/attraction/sido`)
        .then(({ data }) => {
          console.log(data);
          commit('SET_SIDO_LIST', data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getGugun({ commit }, sidoCode) {
      // const params = { sido: sidoCode };
      apiInstance
        .get(`/api/attraction/gugun/` + sidoCode)
        .then(({ data }) => {
          commit('SET_GUGUN_LIST', data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};

export default myPage;

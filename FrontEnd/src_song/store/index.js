import http from "@/api/http";
import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

//step01;
export default new Vuex.Store({
  state: {
    count: 0,
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
  actions: {
    getSido({ commit }) {
      http
        .get(`/api/attraction/sido`)
        .then(({ data }) => {
          console.log(data)
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

//step02
// export default new Vuex.Store({
//   state: {
//     count: 0,
//   },
//   getters: {
//     // 복잡한 계산식을 처리 : computed
//     countMsg(state) {
//       // return state.count + '번 호출됨';
//       let msg = "10번보다 ";
//       if (state.count > 10) {
//         msg += "많이 ";
//       } else {
//         msg += "적게 ";
//       }
//       return msg + " 호출됨(" + state.count + ")";
//     },
//   },
// });

//step03
// export default new Vuex.Store({
//   state: {
//     count: 0,
//   },
//   getters: {
//     // 복잡한 계산식을 처리 : computed
//     countMsg(state) {
//       // return state.count + '번 호출됨';
//       let msg = "10번보다 ";
//       if (state.count > 10) {
//         msg += "많이 ";
//       } else {
//         msg += "적게 ";
//       }
//       return msg + " 호출됨(" + state.count + ")";
//     },
//     msg1(state) {
//       return "msg1 : " + state.count;
//     },
//     msg2(state) {
//       return "msg2 : " + state.count;
//     },
//     msg3(state) {
//       return "msg3 : " + state.count;
//     },
//   },
// });

//step04
// export default new Vuex.Store({
//   state: {
//     count: 0,
//   },
//   mutations: {
//     //mutation을 통해 state 상태 변경
//     ADD_ONE(state) {
//       state.count += 1;
//     },
//     ADD_COUNT(state, payload) {
//       state.count += payload;
//     },
//     ADD_OBJ_COUNT(state, payload) {
//       state.count += payload.num;
//     },
//   },
//   getters: {
//     // 복잡한 계산식을 처리 : computed
//     countMsg(state) {
//       // return state.count + '번 호출됨';
//       let msg = "10번보다 ";
//       if (state.count > 10) {
//         msg += "많이 ";
//       } else {
//         msg += "적게 ";
//       }
//       return msg + " 호출됨(" + state.count + ")";
//     },
//   },
// });

//step05
// export default new Vuex.Store({
//   state: {
//     count: 0,
//   },
//   mutations: {
//     ADD_ONE(state) {
//       state.count += 1;
//     },
//     ADD_TEN_COUNT(state, payload) {
//       state.count += payload;
//     },
//     ADD_OBJ_COUNT(state, payload) {
//       state.count += payload.num;
//     },
//   },
//   getters: {
//     // 복잡한 계산식을 처리 : computed
//     countMsg(state) {
//       // return state.count + '번 호출됨';
//       let msg = "10번보다 ";
//       if (state.count > 10) {
//         msg += "많이 ";
//       } else {
//         msg += "적게 ";
//       }
//       return msg + " 호출됨(" + state.count + ")";
//     },
//   },
// });

//step06
// export default new Vuex.Store({
//   state: {
//     count: 0,
//   },
//   actions: {
//     asyncAddOne(context) {
//       setTimeout(() => {
//         context.commit("ADD_ONE");
//       }, 2000);
//     },
//   },
//   mutations: {
//     ADD_ONE(state) {
//       state.count += 1;
//     },
//     ADD_TEN_COUNT(state, payload) {
//       state.count += payload;
//     },
//     ADD_OBJ_COUNT(state, payload) {
//       state.count += payload.num;
//     },
//   },
//   getters: {
//     // 복잡한 계산식을 처리 : computed
//     countMsg(state) {
//       // return state.count + '번 호출됨';
//       let msg = "10번보다 ";
//       if (state.count > 10) {
//         msg += "많이 ";
//       } else {
//         msg += "적게 ";
//       }
//       return msg + " 호출됨(" + state.count + ")";
//     },
//   },
// });

//step07
// export default new Vuex.Store({
//   state: {
//     count: 0,
//   },
//   actions: {
//     asyncAddOne(context) {
//       setTimeout(() => {
//         context.commit("addOne");
//       }, 2000);
//     },
//   },
//   mutations: {
//     ADD_ONE(state) {
//       state.count += 1;
//     },
//     ADD_TEN_COUNT(state, payload) {
//       state.count += payload;
//     },
//     ADD_OBJ_COUNT(state, payload) {
//       state.count += payload.num;
//     },
//   },
//   getters: {
//     // 복잡한 계산식을 처리 : computed
//     countMsg(state) {
//       // return state.count + '번 호출됨';
//       let msg = "10번보다 ";
//       if (state.count > 10) {
//         msg += "많이 ";
//       } else {
//         msg += "적게 ";
//       }
//       return msg + " 호출됨(" + state.count + ")";
//     },
//   },
// });

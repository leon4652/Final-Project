import { getUserInfo, updateUserInfo } from '@/api/myPage';

const myPageStore = {
  namespaced: true,
  state: {
    user: null,
    isUpdate: 0,
  },
  mutations: {
    SET_USER(state, user) {
      console.dir(user);
      state.user = user;
    },
    SET_IS_UPDATE(state, isUpdate) {
      state.isUpdate = isUpdate;
    },
  },
  actions: {
    async getUser({ commit }) {
      await getUserInfo(
        ({ data }) => {
          console.dir(data);
          commit('SET_USER', data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    async updateUser({ commit }, user) {
      await updateUserInfo(
        user,
        ({ data }) => {
          commit('SET_IS_UPDATE', data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};

export default myPageStore;

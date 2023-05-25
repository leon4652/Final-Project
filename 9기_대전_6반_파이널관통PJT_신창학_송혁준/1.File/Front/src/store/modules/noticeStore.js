import { select, getNotice, write, deleteNotice, modify, subSelect } from '@/api/notice';

const noticeStore = {
  namespaced: true,
  state: {
    notice: null,
    notices: [],
    isWrite: false,
    isDelete: false,
    isUpdate: false,
    subNotices: [],
  },
  mutations: {
    SET_NOTICE_LIST(state, notices) {
      // 초기화
      state.notices = [];
      notices.forEach((notice) => {
        state.notices.push({
          noticeNo: notice.noticeNo,
          noticeTitle: notice.noticeTitle,
          userId: notice.userId,
          registDate: notice.registDate,
        });
      });
    },
    SET_NOTICE(state, notice) {
      state.notice = notice;
    },
    SET_IS_WRITE(state, isWrite) {
      state.isWrite = isWrite;
    },
    SET_IS_DELETE(state, isDelete) {
      state.isDelete = isDelete;
    },
    SET_IS_UPDATE(state, isUpdate) {
      state.isUpdate = isUpdate;
    },
    SET_SUBLIST(state, subNotices) {
      state.subNotices = [];
      subNotices.forEach((notice) => {
        state.subNotices.push({
          noticeNo: notice.noticeNo,
          noticeTitle: notice.noticeTitle,
          userId: notice.userId,
          registDate: notice.registDate,
        });
      });
    },
  },
  actions: {
    // notice list 불러오기
    async getNoticeList({ commit }) {
      await select(
        ({ data }) => {
          commit('SET_NOTICE_LIST', data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    // notice 정보 불러오기 -> view page로 넘길 것
    async getNotice({ commit }, noticeNo) {
      await getNotice(
        noticeNo,
        ({ data }) => {
          commit('SET_NOTICE', data);
        },
        (error) => {
          console.log(error);
        }
      );
    },

    // notice 작성
    async writeNotice({ commit }, notice) {
      await write(
        notice,
        ({ data }) => {
          if (data.message === 'success') {
            commit('SET_IS_WRITE', true);
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },

    // notice 삭제
    async deleteNoti({ commit }, noticeNo) {
      await deleteNotice(
        noticeNo,
        ({ data }) => {
          if (data.message === 'success') {
            commit('SET_IS_DELETE', true);
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },

    // notice 수정
    async modifyNotice({ commit }, notice) {
      await modify(
        notice,
        ({ data }) => {
          if (data.message === 'success') {
            commit('SET_IS_UPDATE', true);
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },

    // subSelect 5개만 가져오기
    async subList({ commit }) {
      await subSelect(
        ({ data }) => {
          commit('SET_SUBLIST', data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};

export default noticeStore;

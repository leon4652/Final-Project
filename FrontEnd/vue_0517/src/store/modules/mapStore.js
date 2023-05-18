const mapStore = {
  namespaced: true,
  state: {
    count: 0,
    lan: 37.52251412,
    lat: 128.2919115,
    searchWord: "검색어",
    gugunCode: 0,
    gugunName: "",
    sidoCode: 0,
    sidoName: "",
  },
  mutations: {
    //위도 경도 변경
    MOD_LAN_LAT(state, payload) {
      (state.lan = payload.lan), (state.lat = payload.lat);
    },

    MOD_SEARCH_WORD(state, payload) {
      state.searchWord = payload;
    },

    SET_GUGUN(state, payload) {
      (state.gugunCode = payload.gugunCode),
        (state.sidoCode = payload.sidoCode),
        (state.gugunName = payload.gugunName);
    },
    SET_SIDO(state, payload) {
      state.sidoCode = payload.sidoCode;
      state.sidoName = payload.sidoName;
    },
  },
  getters: {
    posMsg(state) {
      let msg = "[현재 좌표] lan :" + state.lan + " lat :" + state.lat;
      return msg;
    },
  },
  actions: {},
};

export default mapStore;

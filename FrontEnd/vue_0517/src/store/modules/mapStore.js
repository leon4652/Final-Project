const mapStore = {
  namespaced: true,
  state: {
    searchWord: "검색어",
    gugunCode: 0,
    gugunName: "",
    sidoCode: 0,
    sidoName: "",
    sidoImg: "",

    gugunList: [], // 구군 리스트를 저장할 배열 추가
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
    SET_NOW_SIDO(state, payload) { //SELECT에서 선택한 현재 지역별로 정렬
      state.sidoCode = payload.sidoCode;
      state.sidoName = payload.sidoName;
      state.sidoImg = payload.sidoImg;
    },

    SET_GUGUN_LIST(state, payload) {
      state.gugunList = payload; // 구군 리스트를 받아 state에 저장
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

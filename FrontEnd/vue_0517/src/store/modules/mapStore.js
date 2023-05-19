const mapStore = {
  namespaced: true,
  state: {
    lat: 36.354935,
    lan: 127.298259,
    gugunCode: 0,
    gugunName: "",
    sidoCode: 0,
    sidoName: "",
    sidoImg:
      "https://www.urbanbrush.net/web/wp-content/uploads/edd/2022/12/urbanbrush-20221223093720209565.jpg",

    gugunList: [], // 구군 리스트를 저장할 배열 추가
    attInfoList: [], //어트랙션 정보들을 저장할 배열
  },
  mutations: {
    //위도 경도 변경
    SET_LAN_LAT(state, payload) {
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
    SET_NOW_SIDO(state, payload) {
      //SELECT에서 선택한 현재 지역별로 정렬
      state.sidoCode = payload.sidoCode;
      state.sidoName = payload.sidoName;
      state.sidoImg = payload.sidoImg;
    },

    SET_GUGUN_LIST(state, payload) {
      state.gugunList = payload; // 구군 리스트를 받아 state에 저장
    },

    SET_ATTINFO_LIST(state, payload) {
      state.attInfoList = payload;
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

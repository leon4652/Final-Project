import axios from 'axios';
const mapStore = {
  namespaced: true,
  state: {
    cnt: 0,
    lat: 36.354935,
    lan: 127.298259,
    gugunCode: 0,
    gugunName: '',
    sidoCode: 0,
    sidoName: '',
    sidoImg:
      'https://www.urbanbrush.net/web/wp-content/uploads/edd/2022/12/urbanbrush-20221223093720209565.jpg',
    gugunList: [], // 구군 리스트를 저장할 배열 추가
    attInfoList: [], //어트랙션 정보들을 저장할 배열 {}
    nowContentType: 0, //콘텐츠 타입(ex:관광지:12, 숙박:25 ..)
    contentTypeList: [12, 14, 15, 25, 28, 32, 38, 39],
    mobility: 1, //이동수단
    isTripPlan: false, //여행 계획인지 구분
    myRoute: [], //여행 계획 루트
  },
  mutations: {
    SET_CNT(state, payload) {
      state.cnt = payload;
    },
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

    SET_NOW_CONTENT_TYPE(state, payload) {
      state.nowContentType = payload;
    },

    SET_MOBILITY(state, payload) {
      state.mobility = payload;
    },

    SET_IS_TRIP_PLAN(state, payload) {
      state.isTripPlan = payload;
    },

    ADD_MY_ROUTE(state, payload) {
      state.myRoute.push(payload);
    },

    DEL_MY_ROUTE(state) {
      state.myRoute = [];
    },
  },
  getters: {},
  actions: {
    fetchAttInfoList({ commit, state }, contentType) {
      axios
        .get(
          process.env.VUE_APP_API_BASE_URL +
            `/attraction/view/${contentType}/${state.sidoCode}/${state.gugunCode}`
        )
        .then((response) => {
          commit('SET_ATTINFO_LIST', response.data);
        })
        .catch((error) => {
          console.error(error);
        });
    },

    getDetailsFromLatLng({ commit, state }, { lat, lan }) {
      axios
        .get(process.env.VUE_APP_API_BASE_URL + `/attraction/search/${lat}/${lan}`)
        .then((response) => {
          commit('ADD_MY_ROUTE', response.data);
          console.log(response.data);
          for (var i = 0; i < state.myRoute.length; i++) {
            console.log('루트 : ' + state.myRoute[i].addr1);
          }
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
};

export default mapStore;

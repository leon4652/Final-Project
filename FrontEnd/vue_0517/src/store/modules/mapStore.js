import axios from "axios";
import jwt_decode from "jwt-decode";
const mapStore = {
  namespaced: true,
  state: {
    cnt: 0,
    lat: 36.354935,
    lan: 127.298259,
    gugunCode: 0,
    gugunName: "",
    sidoCode: 0,
    sidoName: "",
    sidoImg:
      "https://www.urbanbrush.net/web/wp-content/uploads/edd/2022/12/urbanbrush-20221223093720209565.jpg",
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
          commit("SET_ATTINFO_LIST", response.data);
        })
        .catch((error) => {
          console.error(error);
        });
    },

    getDetailsFromLatLng({ commit, state }, { lat, lan }) {
      axios
        .get(
          process.env.VUE_APP_API_BASE_URL + `/attraction/search/${lat}/${lan}`
        )
        .then((response) => {
          commit("ADD_MY_ROUTE", response.data);
          console.log(state.myRoute);
        })
        .catch((error) => {
          console.error(error);
        });
    },

    sendMyRoute({ state, commit }, tripTitle) {
      var done = true; //ERR메서드 출력
      const currentTime = new Date(); // 현재 시간을 가져옴
      try {
        var idInfo = jwt_decode(sessionStorage.getItem("access-token"));
        if (!idInfo) {
          alert("재로그인이 필요합니다.");
          return; // 토큰이 없으므로 함수 실행 중단
        }
      } catch (error) {
        alert("로그인이 필요합니다.");
        return; // 토큰이 올바르지 않으므로 함수 실행 중단
      }

      if (state.myRoute.length == 0) {
        alert("여정을 추가해주세요.");
        return; // 여정이 없으므로 함수 실행 중단
      }

      //myRoute의 특정 프로퍼티 값과, 제목, id, no를 합친 배열 생성
      const myRouteId = state.myRoute.map((route, index) => {
        const { title, addr1, firstImage } = route; // 특정 프로퍼티 A, B, C를 추출
        return {
          idx: index,
          tripTitle,
          title,
          addr1,
          firstImage,
          expectTime: 0,
          userId: idInfo.userId, // id 값을 추가
          userNo: idInfo.userNo, // no 값을 추가
          currentTime, //현재 시간
        };
      });

      console.dir(myRouteId);

      axios
        .post(process.env.VUE_APP_API_BASE_URL + "/myplan/save", myRouteId)
        .then((response) => {
          console.log(response);
        })
        .catch((error) => {
          alert("등록 과정에 문제가 발생했습니다.");
          done = false;
          console.error(error);
        });

      if (done) {
        alert("등록 완료!");
        commit("DEL_MY_ROUTE");
      } else {
        alert("에러가 발생했습니다.");
      }
    },
  },
};

export default mapStore;

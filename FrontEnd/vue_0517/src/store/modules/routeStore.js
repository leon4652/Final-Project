import axios from "axios";
import jwt_decode from "jwt-decode";
const routeStore = {
  namespaced: true,
  state: {
    myRoute: [], //여행 계획 루트
    mobility: 0, //이동수단
    expectTime: [0], //예상 시간
  },
  mutations: {
    ADD_MY_ROUTE(state, payload) {
      state.myRoute.push(payload);
    },

    DEL_MY_ROUTE(state) {
      state.myRoute = [];
    },

    DEL_EXPECT_TIME(state) {
      state.expectTime = [0];
    },

    ADD_EXPECT_TIME(state, payload) {
      state.expectTime.push(payload);
    },
  },
  getters: {},
  actions: {
    sendMyRoute({ state, commit }, { tripTitle, tripContent }) {
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
          tripContent,
          title,
          addr1,
          firstImage,
          expectTime: state.expectTime[index],
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
          done = false;
          alert("등록 과정에 문제가 발생했습니다.");
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

export default routeStore;

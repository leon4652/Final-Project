<template>
  <div>
    <div class="full-container">
      <div class="amf-container">
        <h2
          style="
            margin-top: 15px;
            text-decoration: underline;
            margin-bottom: 20px;
          "
        >
          나만의 여행 계획표를 등록하세요
        </h2>
        <div class="write-container">
          <div class="write">
            <div>
              제목 :
              <input class="title-input" v-model="tripTitle" />
            </div>
            <div style="margin-top: 15px">
              <textarea v-model="tripContent"></textarea>
            </div>
          </div>
          <div class="btn">
            <button class="my-btn" @click="uploadMyRoute">등록</button>
            <button class="my-btn" @click="deleteMyRoute">삭제</button>
          </div>
        </div>

        <div class="table-container">
          <table class="table table-bordered table-hover">
            <caption class="text-center">
              SSAFY Final Project
            </caption>
            <thead>
              <tr>
                <th>지명</th>
                <th>관광지 주소</th>
                <th>이미지</th>
                <th>예상 이동 시간</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="(mr, index) in myRoute" :key="mr.title">
                <td>{{ mr.title }}</td>
                <td>{{ mr.addr1 }}</td>
                <td>
                  <img
                    v-if="mr.firstImage"
                    :src="mr.firstImage"
                    alt="Image"
                    class="image"
                  />
                  <span v-else>No Image</span>
                </td>
                <td>{{ convertTime(expectTime[index]) }}</td>
              </tr>
            </tbody>
            <tfoot>
              <tr>
                <td colspan="4" class="text-center">
                  <a href="http://www.ssafy.com" target="_blank">FAQ</a> and
                  <a href="http://www.ssafy.com" target="_blank">Contact</a>.
                </td>
              </tr>
            </tfoot>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions } from "vuex";
export default {
  name: "addMyFavorite",
  components: {},
  data() {
    return {
      tripTitle: "나만의 여행 계획!",
      tripContent: "내용을 입력하세요.",
    };
  },
  created() {},
  methods: {
    ...mapMutations("mapStore", ["DEL_MY_ROUTE"]),
    ...mapActions("mapStore", ["sendMyRoute"]),
    deleteMyRoute() {
      this.DEL_MY_ROUTE();
    },
    uploadMyRoute() {
      this.sendMyRoute({
        tripTitle: this.tripTitle,
        tripContent: this.tripContent,
      });
      this.tripTitle = "나만의 여행 계획!"; // tripTitle을 원하는 값으로 변경
      this.tripContent = "내용을 입력하세요."; // tripContent를 원하는 값으로 변경
    },
    convertTime(minutes) {
      //60분 넘어갈 시 시간 변환 실행
      if (minutes >= 60) {
        const hours = Math.floor(minutes / 60);
        const remainingMinutes = Math.round(minutes % 60);
        return `${hours}시간 ${remainingMinutes}분`;
      } else {
        return `${minutes}분`;
      }
    },
  },
  computed: {
    ...mapState("mapStore", ["myRoute", "expectTime"]),
  },
};
</script>

<style scoped>
.full-container {
  overflow: auto;
  display: flex;
  flex-direction: column;
  border: 2px solid #ccc; /* 테두리 스타일 추가 */
  border-radius: 5px; /* 테두리 둥글게 설정 */
  overflow: auto; /* 내용이 넘칠 경우 숨김 처리 */
  box-shadow: 0 2px 20px rgba(0, 0, 0, 0.2); /* 그림자 효과 추가 */
  margin-top: 30px;
}
.title-input {
  margin-top: 10px;
  width: 400px; /* 제목 입력란의 너비 설정 */
  height: 30px; /* 제목 입력란의 높이 설정 */
  padding: 5px; /* 제목 입력란의 내부 여백 설정 */
}

.my-btn {
  display: inline-block;
  padding: 10px 20px;
  background-color: #f9fafa;
  color: rgb(0, 0, 0);
  font-size: 16px;
  border: 1px solid rgb(97, 96, 96);
  border-radius: 4px;
  cursor: pointer;
  text-align: center;
  transition-duration: 0.4s;
  text-decoration: none;
  width: 200px;
  padding: 5%;
  margin-bottom: 10%;
}

.my-btn:hover {
  background-color: #cacaca;
}
.btn {
  margin: 50px;
}
.write textarea {
  width: 100%; /* 원하는 너비로 설정 */
  height: 150px; /* 원하는 높이로 설정 */
  padding: 10px; /* 내부 여백 조정 */
  resize: vertical; /* 세로 크기 조절 허용 */
}

.write {
  display: grid;
  width: 70%;
}
.write-container {
  display: flex; /* 요소들을 가로로 배치 */
  justify-content: space-between;
}
.amf-container {
  max-height: 650px;
  overflow: auto;
  padding: 10px;
}
.image {
  width: 120px; /* 이미지의 원하는 크기로 설정 */
  height: 100px; /* 가로 크기에 맞춰 세로 크기 조절 */
}
.table-container {
  max-height: 600px;
}
</style>

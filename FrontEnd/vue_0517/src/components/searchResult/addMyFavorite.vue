<template>
  <div>
    <div>
      <div class="container">
        <div class="write-container">
          <div class="write">
            <div>제목 : <input class="title-input" v-model="tripTitle" /></div>
            <div>내용 : <textarea v-model="tripContent"></textarea></div>
          </div>
          <div class="btn">
            <button @click="deleteMyRoute">삭제</button>
            <button @click="uploadMyRoute">등록</button>
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
                <th>예상 시간</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="mr in myRoute" :key="mr.title">
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
                <td>예상 시간</td>
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
      tripContent: "너무 재밌었어요",
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
      this.sendMyRoute(this.tripTitle);
    },
  },
  computed: {
    ...mapState("mapStore", ["myRoute"]),
  },
};
</script>

<style scoped>
.title-input {
  margin-top: 10px;
  width: 400px; /* 제목 입력란의 너비 설정 */
  height: 30px; /* 제목 입력란의 높이 설정 */
  padding: 5px; /* 제목 입력란의 내부 여백 설정 */
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
.container {
  max-height: 650px;
  overflow: auto;
}
.image {
  width: 120px; /* 이미지의 원하는 크기로 설정 */
  height: 100px; /* 가로 크기에 맞춰 세로 크기 조절 */
}
.table-container {
  max-height: 600px;
}
</style>

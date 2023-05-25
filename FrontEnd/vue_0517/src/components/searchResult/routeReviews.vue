<template>
  <div>
    <div class="rr-container">
      <div class="rr-table-container">
        <table class="table table-bordered table-hover">
          <caption class="text-center">
            SSAFY Final Project
          </caption>
          <thead>
            <tr>
              <th>글쓴이</th>
              <th>제목</th>
              <th>조회수</th>
              <th>추천수</th>
              <th>시간</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="review in routeReviews" :key="review.myPlanNo">
              <td>{{ review.userId }}</td>
              <td>
                <a href="#" @click="openModal(review)">{{
                  review.tripTitle
                }}</a>
              </td>
              <td>{{ review.myPlanHit }}</td>
              <td>{{ review.myPlanLike }}</td>
              <td>{{ review.myPlanRegistDate }}</td>
            </tr>
          </tbody>
          <tfoot>
            <tr>
              <td colspan="5" class="text-center">
                <a href="http://www.ssafy.com" target="_blank">FAQ</a> and
                <a href="http://www.ssafy.com" target="_blank">Contact</a>.
              </td>
            </tr>
          </tfoot>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import axios from "axios";
export default {
  name: "routeReviews",
  components: {},
  data() {
    return {
      routeReviews: [], // 데이터를 저장할 배열
    };
  },
  computed: {
    ...mapState("mapStore", ["sidoCode", "gugunCode"]),
  },
  async mounted() {
    //마운트 비동기 처리 -> 호출 이후 동작 선언
    try {
      const response = await axios.get(
        process.env.VUE_APP_API_BASE_URL +
          `/myplan/review/${this.sidoCode}/${this.gugunCode}`
      );
      this.routeReviews = response.data;
      this.routeReviews = response.data.reverse(); // 배열을 역순으로 변경(최신글 처리)
    } catch (error) {
      console.error(error);
    }
  },

  methods: {},
};
</script>

<style scoped>
.rr-container {
  max-height: 650px;
  overflow: auto;
  display: flex;
  flex-direction: column;
  border: 2px solid #ccc; /* 테두리 스타일 추가 */
  border-radius: 5px; /* 테두리 둥글게 설정 */
  overflow: auto; /* 내용이 넘칠 경우 숨김 처리 */
  box-shadow: 0 2px 20px rgba(0, 0, 0, 0.2); /* 그림자 효과 추가 */
  margin-top: 30px;
}
.rr-table-container {
  max-height: 600px;
}

.overview {
  max-width: 300px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  width: 60%;
}

.overview.expanded {
  white-space: normal;
}

.image-cell {
  max-width: 350px;
}

.image-cell.expanded {
  width: 60%;
}

.image {
  max-width: 100%;
  height: auto;
}
</style>

<template>
  <div class="modal" v-if="show">
    <div class="modal-content">
      <div v-if="review">
        <h2 class="underline">{{ review.tripTitle }}</h2>
        <div class="info">
          <p>ID : {{ review.userId }}</p>
          <p>조회수 : {{ review.myPlanHit }}</p>
          <p>좋아요 : {{ review.myPlanLike }}</p>
          <p>등록일자 : {{ review.myPlanRegistDate }}</p>
        </div>
      </div>
      <div class="my-content">
        {{ review.tripContent }}
      </div>
      <div class="table-container">
        <table class="table table-bordered table-hover">
          <caption class="text-center">
            SSAFY Final Project
          </caption>
          <thead>
            <tr>
              <th>관광지 이름</th>
              <th>관광지 주소</th>
              <th>이미지</th>
              <th>예상 시간</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="order in tripOrders" :key="order.idx">
              <td>{{ order.title }}</td>
              <td>{{ order.addr1 }}</td>
              <td>
                <img
                  v-if="order.firstImage"
                  :src="order.firstImage"
                  alt="Image"
                  class="image"
                />
                <span v-else>No Image</span>
              </td>
              <td>{{ convertTime(order.expectTime) }}</td>
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
      <div btn-set>
        <button @click="closeModal" class="my-button">Close</button>
        <button @click="likeEvent" class="my-button">Like</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    show: {
      type: Boolean,
      required: true,
    },
    review: {
      type: Object,
      default: null,
    },
    tripOrders: {
      type: Array,
      default: function () {
        // 함수로 기본값 지정
        return [];
      },
    },
  },
  methods: {
    closeModal() {
      this.$emit("close");
    },
    likeEvent() {
      this.$emit("like");
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
};
</script>

<style scoped>
.image {
  width: 120px; /* 이미지의 원하는 크기로 설정 */
  height: 100px; /* 가로 크기에 맞춰 세로 크기 조절 */
}

.my-button {
  display: inline-block;
  padding: 10px 20px;
  background-color: #01e8f8;
  color: white;
  font-size: 16px;
  border: 1px solid rgb(97, 96, 96);
  border-radius: 4px;
  cursor: pointer;
  text-align: center;
  transition-duration: 0.4s;
  text-decoration: none;
  width: 200px;
  margin: 20px;
}

.my-button:hover {
  background-color: #5eb7ff;
}
.my-content {
  border: 1px solid rgb(199, 198, 198);
  min-height: 100px;
  width: 550px;
  margin-bottom: 20px;
}
.info {
  display: flex;
  justify-content: space-around; /* 일정한 좌우 간격 */
  border: 1px solid rgb(199, 198, 198);
  padding: 1px;
  margin-bottom: 10px;
  width: 550px;
}
.modal {
  position: absolute;
  top: 0;
  left: 0;
  width: 70%;
  height: 70%;
  display: flex;
  justify-content: right;
  align-items: right;
  z-index: 999;
  margin-left: 20%;
  margin-top: 8%;
}

.modal-content {
  background-color: white;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2);
  width: 80%; /* 모달의 가로 크기를 조절 */
  max-width: 600px; /* 모달의 최대 가로 크기를 설정 */
  border: 2px solid rgb(199, 198, 198);
  overflow: auto;
}

.underline {
  text-decoration: underline;
  margin-bottom: 20px;
}
</style>

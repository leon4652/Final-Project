<template>
  <div class="sido-info-container">
    <img :src="sidoImg" alt="지역" class="fixed-size-image" />
    <b></b>
    <div class="gugun-list-wrapper">
      <ul class="gugun-list">
        <li
          v-for="gugun in gugunList"
          :key="gugun.gugunCode"
          @click="gugunClick(gugun)"
        >
          {{ gugun.gugunName }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import { mapMutations, mapState } from "vuex";

export default {
  name: "sidoInfo",
  components: {},
  data() {
    return {
      message: "",
    };
  },
  computed: {
    ...mapState("mapStore", ["sidoImg", "gugunList", "sidoCode"]),
  },
  created() {},
  methods: {
    ...mapMutations("mapStore", ["SET_GUGUN", "SET_NOW_CONTENT_TYPE"]),
    async gugunClick(gugun) {
      await this.SET_GUGUN({
        gugunCode: gugun.gugunCode,
        sidoCode: this.sidoCode,
        gugunName: gugun.gugunName,
      });
      this.SET_NOW_CONTENT_TYPE(11); //컨텐츠 타입 변경
      this.$router.push("/rsMain"); // 다른 뷰로 이동
    },
  },
};
</script>

<style scoped>
.sido-info-container {
  height: 100%; /* 요소의 높이를 100%로 설정하여 부모 컨테이너의 크기에 맞춥니다 */
}

.fixed-size-image {
  width: 400px; /* 원하는 가로 크기 */
  height: auto; /* 세로 크기는 가로 크기에 비례하여 자동으로 조정됩니다 */
  object-fit: cover;
  filter: brightness(80%);
  border: 1px solid #faeded;
  border-radius: 5px;
  box-shadow: 0 2px 20px rgba(0, 0, 0, 0.2); /* 그림자 효과 추가 */
}

.gugun-list {
  margin-top: 10px; /* 상단 여백을 추가합니다 */
  padding: 0; /* 리스트의 기본 패딩을 제거합니다 */
  list-style: none; /* 리스트 기호를 제거합니다 */
}

.gugun-list li {
  padding: 5px 0; /* 리스트 아이템의 상하 여백을 추가합니다 */
  cursor: pointer; /* 클릭 가능한 커서로 변경합니다 */
  border-bottom: 1px solid #ccc; /* 리스트 아이템 사이에 구분선을 추가합니다 */
}

.gugun-list li:last-child {
  border-bottom: none; /* 마지막 아이템의 구분선을 제거합니다 */
}

.gugun-list-wrapper {
  max-height: 200px; /* 최대 높이를 설정하여 스크롤이 표시되도록 합니다 */
  overflow-y: auto;
}
</style>

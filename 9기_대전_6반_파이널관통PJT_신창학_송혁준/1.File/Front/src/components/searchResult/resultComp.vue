<template>
  <div>
    <div class="rs-container">
      <div class="rs-table-container">
        <table class="table table-bordered table-hover">
          <caption class="text-center">
            SSAFY Final Project
          </caption>
          <thead>
            <tr>
              <th>관광지 이름</th>
              <th>관광지 주소</th>
              <th>관광지 개요</th>
              <th>이미지</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="att in attInfoList" :key="att.title">
              <td>{{ att.title }}</td>
              <td>{{ att.addr1 }}</td>
              <td
                class="overview"
                :class="{ expanded: att.expanded }"
                @click="toggleOverview(att)"
              >
                {{ att.overview }}
              </td>
              <td class="image-cell" :class="{ expanded: att.expanded }">
                <img
                  v-if="att.firstImage"
                  :src="att.firstImage"
                  alt="Image"
                  class="image"
                />
                <span v-else>No Image</span>
              </td>
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
</template>

<script>
import { mapState, mapActions } from "vuex";

export default {
  name: "resultComp",
  components: {},
  data() {
    return {};
  },
  computed: {
    ...mapState("mapStore", [
      "sidoCode",
      "gugunCode",
      "attInfoList",
      "nowContentType",
    ]),
  },
  created() {
    this.fetchAttInfoList(this.nowContentType);
  },
  methods: {
    ...mapActions("mapStore", ["fetchAttInfoList"]),
    toggleOverview(att) {
      //클릭시마다 css 설정 변경
      this.$set(att, "expanded", !att.expanded);
    },
  },
};
</script>

<style scoped>
.rs-container {
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
.rs-table-container {
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

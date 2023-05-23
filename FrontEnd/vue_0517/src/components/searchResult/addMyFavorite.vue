<template>
  <div class="down">
    <button @click="deleteMyRoute">삭제</button>
    <button @click="uploadMyRoute">등록</button>
    <div>
      <div class="container">
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
import { mapState, mapMutations } from "vuex";
export default {
  name: "addMyFavorite",
  components: {},
  data() {
    return {
      message: "",
    };
  },
  created() {},
  methods: {
    ...mapMutations("mapStore", ["DEL_MY_ROUTE"]),
    deleteMyRoute() {
      this.DEL_MY_ROUTE();
    },
    uploadMyRoute() {
      alert("여행지 등록 예정");
    },
  },
  computed: {
    ...mapState("mapStore", ["myRoute"]),
  },
};
</script>

<style scoped>
@import url("@/assets/table/table.css");

.image {
  width: 120px; /* 이미지의 원하는 크기로 설정 */
  height: 100px; /* 가로 크기에 맞춰 세로 크기 조절 */
}

.down {
  margin-top: 100px;
}
</style>

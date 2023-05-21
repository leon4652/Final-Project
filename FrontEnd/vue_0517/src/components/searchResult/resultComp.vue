<template>
  <div>
    <h2>관광지 컴포넌트, 종류 코드 : {{  }}</h2>

    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <div class="table-container">
            <table class="table table-bordered table-hover">
              <caption class="text-center">SSAFY Final Project</caption>
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
                  <td class="overview" :class="{ 'expanded': att.expanded }" @click="toggleOverview(att)">{{ att.overview }}</td>
                  <td class="image-cell" :class="{ 'expanded': att.expanded }">
                    <img v-if="att.firstImage" :src="att.firstImage" alt="Image" class="image" />
                    <span v-else>No Image</span>
                  </td>
                </tr>
              </tbody>
              <tfoot>
                <tr>
                  <td colspan="4" class="text-center">
                    <a href="http://www.ssafy.com" target="_blank">FAQ</a> and <a href="http://www.ssafy.com" target="_blank">Contact</a>.</td>
                </tr>
              </tfoot>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { mapMutations, mapState } from "vuex";

export default {
  name: "resultComp",
  components: {},
  data() {
    return {
    };
  },
  computed: {
    ...mapState("mapStore", ["sidoCode", "gugunCode", "attInfoList"]),
  },
  created() {
    axios
      .get(
        `http://localhost/api/attraction/view/12/${this.sidoCode}/${this.gugunCode}`
      )
      .then((response) => {
        this.SET_ATTINFO_LIST(response.data); // 받아온 데이터를 attList에 저장
      })
      .catch((error) => {
        console.error(error);
      });
  },
  methods: {
    ...mapMutations("mapStore", ["SET_ATTINFO_LIST"]),
    toggleOverview(att) { //클릭시마다 css 설정 변경
      this.$set(att, 'expanded', !att.expanded);
    },
  },
};
</script>

<style scoped>
@import url("@/assets/table/table.css");
</style>


<template>
  <div>
    <div class="container">
      <div class="table-container">
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
@import url("@/assets/table/table.css");
</style>

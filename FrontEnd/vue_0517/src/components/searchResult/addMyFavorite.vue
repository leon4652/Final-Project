<template>
  <div>
    <h3>우클릭으로 내가 원하는 루트를 추가해보세요.</h3>
    <div>
      <div class="container">
        <div class="table-container">
          <table class="table table-bordered table-hover">
            <caption class="text-center">
              SSAFY Final Project
            </caption>
            <thead>
              <tr>
                <th>번호</th>
                <th>관광지 주소</th>
                <th>이미지</th>
                <th>예상 시간</th>
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
  </div>
</template>

<script>
export default {
  name: "addMyFavorite",
  components: {},
  data() {
    return {
      message: "",
    };
  },
  created() {},
  methods: {},
};
</script>

<style scoped>
@import url("@/assets/table/table.css");
</style>

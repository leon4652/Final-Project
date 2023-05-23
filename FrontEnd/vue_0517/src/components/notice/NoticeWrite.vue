<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>공지사항 작성</h3></b-alert>
      </b-col>
    </b-row>
    <notice-input type="write"></notice-input>
  </b-container>
</template>

<script>
import NoticeInput from "./item/NoticeInput.vue";

export default {
  name: "NoticeWrite",
  components: { NoticeInput },
  data() {
    return {
      message: "",
    };
  },
  created() {},
  methods: {},
};
</script>

<style scoped></style>

<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>공지사항 수정</h3></b-alert>
      </b-col>
    </b-row>
    <notice-input type="modify"></notice-input>
  </b-container>
</template>

<script>
import NoticeInput from "./item/NoticeInput.vue";

export default {
  name: "NoticeModify",
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

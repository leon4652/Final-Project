<template>
  <b-tr>
    <b-td>{{ storyBoardNo }}</b-td>
    <b-th class="text-left">
      <router-link :to="{ name: 'boardview', params: { storyBoardNo: storyBoardNo } }">{{ storyBoardTitle }}</router-link>
    </b-th>
    <b-td>{{ storyBoardHit }}</b-td>
    <b-td>{{ userNo }}</b-td>
    <b-td>{{ registDate | dateFormat }}</b-td>
  </b-tr>
</template>

<script>
import moment from "moment";

export default {
  name: "StoryBoardListItem",
  props: {
    storyBoardNo: Number,
    userNo: String,
    storyBoardTitle: String,
    storyBoardHit: Number,
    registDate: String,
  },
  filters: {
    dateFormat(registDate) {
      return moment(new Date(registDate)).format("YY.MM.DD");
    },
  },
};
</script>

<style></style>
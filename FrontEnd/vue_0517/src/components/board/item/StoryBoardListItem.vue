<template>
  <tr>
    <td>{{ storyBoardNo }}</td>
    <th class="text-left">
      <router-link :to="{ name: 'boardview', params: { storyBoardNo: storyBoardNo } }">{{ storyBoardTitle }}</router-link>
    </th>
    <td>{{ storyBoardHit }}</td>
    <td>{{ userNo }}</td>
    <td>{{ registDate | dateFormat }}</td>
  </tr>
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
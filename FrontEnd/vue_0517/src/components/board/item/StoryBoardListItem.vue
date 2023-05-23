<template>
  <tr>
    <td>{{ storyBoardNo }}</td>
    <th class="text-left" @click="boardView">{{ storyBoardTitle }}</th>
    <td>{{ storyBoardHit }}</td>
    <td>{{ userId }}</td>
    <td>{{ registDate | dateFormat }}</td>
  </tr>
</template>

<script>
import moment from 'moment';

export default {
  name: 'StoryBoardListItem',
  props: {
    storyBoardNo: Number,
    userNo: Number,
    userName: String,
    userId: String,
    storyBoardTitle: String,
    storyBoardHit: Number,
    registDate: String,
  },
  filters: {
    dateFormat(registDate) {
      return moment(new Date(registDate)).format('YY.MM.DD');
    },
  },
  methods: {
    boardView() {
      this.$router.push('/storyboard/info/' + this.storyBoardNo);
    },
  },
};
</script>

<style></style>

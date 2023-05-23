<template>
  <tr>
    <td>{{ noticeNo }}</td>
    <th class="text-left" @click="noticeView">{{ noticeTitle }}</th>
    <td>{{ noticeHit }}</td>
    <td>{{ userId }}</td>
    <td>{{ registDate | dateFormat }}</td>
  </tr>
</template>

<script>
import moment from 'moment';

export default {
  name: 'NoticeListItem',
  props: {
    noticeNo: Number,
    userNo: Number,
    userName: String,
    userId: String,
    noticeTitle: String,
    noticeHit: Number,
    registDate: String,
  },
  filters: {
    dateFormat(registDate) {
      return moment(new Date(registDate)).format('YY.MM.DD');
    },
  },
  methods: {
    noticeView() {
      this.$router.push('/notice/info/' + this.noticeNo);
    },
  },
};
</script>

<style></style>

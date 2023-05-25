<template>
  <div class="noticeList">
    <router-link to="/notice" class="routerLink">공지사항</router-link>
    <div>
      <b-table striped hover :items="subNotices" :fields="fields">
        <template v-slot:cell(noticeTitle)="row">
          <router-link :to="`/notice/info/${row.item.noticeNo}`">{{ row.value }}</router-link>
        </template>
        <template v-slot:cell(registDate)="row">
          {{ row.value | dateFormat }}
        </template>
      </b-table>
    </div>
  </div>
</template>

<script>
import moment from 'moment';
import { mapActions, mapState } from 'vuex';

const noticeStore = 'noticeStore';

export default {
  name: 'NoticeSubList',
  data() {
    return {
      fields: [
        { key: 'noticeNo', label: '글 번호' },
        { key: 'noticeTitle', label: '제목' },
        { key: 'userId', label: '작성자' },
        { key: 'registDate', label: '작성일' },
      ],
      noticeList: [],
    };
  },
  computed: {
    ...mapState(noticeStore, ['subNotices']),
  },
  created() {
    this.subList();
    this.noticeList = this.subNotices;
  },
  filters: {
    dateFormat(registDate) {
      return moment(new Date(registDate)).format('YY.MM.DD');
    },
  },
  methods: {
    ...mapActions(noticeStore, ['subList']),
    moveWrite() {
      this.$router.push({ name: 'noticeWrite' });
    },
  },
};
</script>

<style scoped>
.routerLink {
  margin-top: 10px;
  margin-bottom: 10px;
}
.noticeList {
  margin-top: 10px;
}
.writeBtn {
  margin-bottom: 5px;
}
a {
  color: black;
}
a:hover {
  /* text-decoration: none; */
  color: black;
}
</style>

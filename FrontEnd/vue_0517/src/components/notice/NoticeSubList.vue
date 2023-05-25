<template>
  <div class="noticeList">
    <!-- <h1 class="con">공지사항</h1> -->
    <router-link to="/notice" class="routerLink">공지사항</router-link>
    <!-- <b-col class="text-right" v-if="this.isAdmin === 1">
      <b-button variant="info" @click="moveWrite" class="writeBtn">글 작성</b-button>
    </b-col> -->
    <!-- <b-table striped hover :items="notices" :fields="fields">
      <template v-slot:cell(noticeTitle)="row">
        <router-link :to="`/notice/info/${row.item.noticeNo}`">{{ row.value }}</router-link>
      </template>
      <template v-slot:cell(registDate)="row">
        {{ row.value | dateFormat }}
      </template>
    </b-table> -->
    <div>
      <b-table striped hover :items="notices" :fields="fields">
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
import jwt_decode from 'jwt-decode';

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
      isAdmin: '',
    };
  },
  computed: {
    ...mapState(noticeStore, ['notices']),
  },
  created() {
    this.getNoticeList();
    this.noticeList = this.notices;

    let user = jwt_decode(sessionStorage.getItem('access-token'));
    this.isAdmin = user.isAdmin;
  },
  filters: {
    dateFormat(registDate) {
      return moment(new Date(registDate)).format('YY.MM.DD');
    },
  },
  methods: {
    ...mapActions(noticeStore, ['getNoticeList']),
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

<template>
  <div class="noticeList">
    <h1 class="con">공지사항</h1>
    <b-col class="text-right" v-if="this.isAdmin === 1">
      <b-button variant="info" @click="moveWrite" class="writeBtn">글 작성</b-button>
    </b-col>
    <b-table hover :items="notices" :fields="fields">
      <template v-slot:cell(noticeTitle)="row">
        <router-link :to="`/notice/info/${row.item.noticeNo}`">{{ row.value }}</router-link>
      </template>
      <template v-slot:cell(registDate)="row">
        {{ row.value | dateFormat }}
      </template>
    </b-table>
  </div>
</template>

<script>
import moment from 'moment';
import { mapActions, mapState } from 'vuex';
import jwt_decode from 'jwt-decode';

const noticeStore = 'noticeStore';

export default {
  data() {
    return {
      fields: [
        { key: 'noticeNo', label: '글 번호', sortable: true },
        { key: 'noticeTitle', label: '제목', sortable: false },
        { key: 'userId', label: '작성자', sortable: true },
        { key: 'registDate', label: '작성일', sortable: true },
      ],
      noticeList: [],
      isAdmin: 0,
    };
  },
  computed: {
    ...mapState(noticeStore, ['notices']),
  },
  // watch: {
  //   notices() {
  //     this.noticeList = this.notices;
  //   },
  // },
  created() {
    this.getNoticeList();
    this.noticeList = this.notices;
    if (sessionStorage.getItem('access-token')) {
      let user = jwt_decode(sessionStorage.getItem('access-token'));
      this.isAdmin = user.isAdmin;
    }
  },
  filters: {
    dateFormat(registDate) {
      return moment(new Date(registDate)).format('YY.MM.DD HH:mm');
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
.noticeList {
  margin-top: 10px;
}
.writeBtn {
  margin-bottom: 10px;
  background-color: #ff8a00;
  border: none;
}
.writeBtn:hover {
  background-color: orange;
}
a {
  color: black;
}
a:hover {
  /* text-decoration: none; */
  color: black;
}
</style>

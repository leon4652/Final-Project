<template>
  <div>
    <b-table striped hover :items="notices" :fields="fields">
      <template v-slot:head()="data">
        <tr>
          <th v-for="field in data.fields" :key="field.key" :class="{'text-left': field.key === 'noticeTitle'}">
            {{ field.label }}
          </th>
        </tr>
      </template>
      <template v-slot:default="data">
        <tr v-for="item in data.items" :key="item.noticeNo">
          <td>{{ item.noticeNo }}</td>
          <td class="text-left" @click="noticeView(item)">{{ item.noticeTitle }}</td>
          <td>{{ item.noticeHit }}</td>
          <td>{{ item.userId }}</td>
          <td>{{ item.registDate | dateFormat }}</td>
        </tr>
      </template>

    </b-table>
      <b-col class="text-right" v-if="this.isAdmin === 1">
        <b-button variant="info" @click="moveWrite">글 작성</b-button>
      </b-col>
  </div>
</template>

<script>
import moment from 'moment';
import { mapActions, mapState } from "vuex";
import jwt_decode from 'jwt-decode';

const noticeStore = "noticeStore";

export default {
  data() {
    return {
      fields: [
        { key: 'noticeNo', label: '글 번호', sortable: true },
        { key: 'noticeTitle', label: '제목', sortable: false },
        // { key: 'noticeHit', label: '조회수', sortable: true },
        { key: 'userId', label: '작성자', sortable: true },
        { key: 'registDate', label: '작성일', sortable: true }
      ],
      noticeList: [
        // { noticeNo: 1, noticeTitle: '첫 번째 공지', noticeHit: 10, userId: 'user1', registDate: '2023-01-01' },
        // { noticeNo: 2, noticeTitle: '두 번째 공지', noticeHit: 5, userId: 'user2', registDate: '2023-01-02' },
        // { noticeNo: 3, noticeTitle: '세 번째 공지', noticeHit: 8, userId: 'user3', registDate: '2023-01-03' },
        // { noticeNo: 4, noticeTitle: '네 번째 공지', noticeHit: 3, userId: 'user4', registDate: '2023-01-04' }
      ],
      isAdmin: '',
    }
  },
  computed: {
    ...mapState(noticeStore, ["notices"]),
  },
  watch: {
    notices(){
      this.noticeList = this.notices;
    }
  },
  created() {
    this.getNoticeList();
    this.noticeList = this.notices;

    let user = jwt_decode(sessionStorage.getItem('access-token'));
    this.isAdmin = user.isAdmin;
    console.log(this.isAdmin)
  },
  methods: {
    ...mapActions(noticeStore, ["getNoticeList"]),
    noticeView(notice) {
      this.$router.push('/notice/info/' + notice.noticeNo);
    },
    dateFormat(registDate) {
      return moment(new Date(registDate)).format('YY.MM.DD');
    },
    moveWrite() {
      this.$router.push({ name: "noticeWrite" });
    },
  }
}
</script>

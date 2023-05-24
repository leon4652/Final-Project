<template>
  <div>
    <h1 class="con">공지사항</h1>
      <b-col class="text-right" v-if="this.isAdmin === 1">
        <b-button variant="info" @click="moveWrite">글 작성</b-button>
      </b-col>
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
          <td class="text-left" @click="noticeView(item.noticeNo)">{{ item.noticeTitle }}</td>
          <td>{{ item.noticeHit }}</td>
          <td>{{ item.userId }}</td>
          <td>{{ item.registDate | dateFormat }}</td>
        </tr>
      </template>

    </b-table>
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
        { key: 'userId', label: '작성자', sortable: true },
        { key: 'registDate', label: '작성일', sortable: true }
      ],
      noticeList: [],
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
    noticeView(noticeNo) {
      console.log(123)
      this.$router.push('/notice/info/' + noticeNo);
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

<template>
  <div class="storyBoardList">
    <h1 class="con">게시판</h1>
    <b-col class="text-right">
      <b-button class="writeBtn" variant="info" @click="moveWrite">글 작성</b-button>
    </b-col>
    <b-table hover :items="storyBoards" :fields="fields">
      <template v-slot:cell(storyBoardTitle)="row">
        <router-link :to="`/storyboard/info/${row.item.storyBoardNo}`">{{ row.value }}</router-link>
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

const storyBoardStore = 'storyBoardStore';

export default {
  data() {
    return {
      fields: [
        { key: 'storyBoardNo', label: '글 번호', sortable: true },
        { key: 'storyBoardTitle', label: '제목', sortable: false },
        { key: 'storyBoardHit', label: '조회수', sortable: true },
        { key: 'userId', label: '작성자', sortable: false },
        { key: 'registDate', label: '작성일', sortable: true },
      ],
      boards: [],
    };
  },
  computed: {
    ...mapState(storyBoardStore, ['storyBoards']),
  },
  created() {
    this.getStoryBoardList();
    this.boards = this.storyBoards;
  },
  filters: {
    dateFormat(registDate) {
      return moment(new Date(registDate)).format('YY.MM.DD HH:mm');
    },
  },
  methods: {
    ...mapActions(storyBoardStore, ['getStoryBoardList']),
    moveWrite() {
      this.$router.push({ name: 'storyboardWrite' });
    },
  },
};
</script>

<style scoped>
.storyBoardList { 
  margin-top: 10px;
}
.writeBtn {
  margin-bottom: 10px;
  /* background: linear-gradient(to right, #00c9ff, #92fe9d); */
  background-color: #ff8a00;
  border: none;
}
.writeBtn:hover{
  background-color: orange;
  /* color: black; */
}
a {
  color: black;
}
/* a:hover {
  text-decoration: none;
  color: black;
} */
</style>

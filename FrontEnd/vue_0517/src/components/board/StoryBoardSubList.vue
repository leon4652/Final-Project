<template>
  <div class="storyBoardList">
    <router-link to="/storyboard" class="routerLink">게시판</router-link>
    <b-table striped hover :items="subStory" :fields="fields">
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
  name: 'StoryBoardSubList',
  data() {
    return {
      fields: [
        { key: 'storyBoardNo', label: '글 번호' },
        { key: 'storyBoardTitle', label: '제목' },
        { key: 'userId', label: '작성자' },
        { key: 'registDate', label: '작성일' },
      ],
      boards: [],
    };
  },
  computed: {
    ...mapState(storyBoardStore, ['subStory']),
  },
  created() {
    this.getSubList();
    this.boards = this.subStory;
  },
  filters: {
    dateFormat(registDate) {
      return moment(new Date(registDate)).format('YY.MM.DD');
    },
  },
  methods: {
    ...mapActions(storyBoardStore, ['getSubList']),
    moveWrite() {
      this.$router.push({ name: 'storyboardWrite' });
    },
  },
};
</script>

<style scoped>
.routerLink {
  margin-top: 10px;
  margin-bottom: 10px;
}
.storyBoardList {
  margin-top: 10px;
}
.writeBtn {
  margin-bottom: 5px;
}
a {
  color: black;
}
/* a:hover {
  text-decoration: none;
  color: black;
} */
</style>

<template>
  <div>
    <my-page-info></my-page-info>
    <my-page-board></my-page-board>
  </div>
</template>

<script>
import MyPageInfo from '@/components/myPage/MyPageInfo.vue';
import MyPageBoard from '@/components/myPage/MyPageBoard.vue';

export default {
  name: 'MypageView',
  components: { MyPageInfo, MyPageBoard },
  data() {
    return {
      message: '',
    };
  },
  created() {},
  methods: {},
};
</script>

<style scoped></style>

<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>글 작성</h3></b-alert>
      </b-col>
    </b-row>
    <story-board-input type="write" />
  </b-container>
</template>

<script>
import StoryBoardInput from './item/StoryBoardInput.vue';

export default {
  name: 'StoryBoardWrite',
  components: { StoryBoardInput },
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

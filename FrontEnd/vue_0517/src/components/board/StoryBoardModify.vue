<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>글 수정</h3></b-alert>
      </b-col>
    </b-row>
    <story-board-input type="modify" />
  </b-container>
</template>

<script>
import StoryBoardInput from './item/StoryBoardInput.vue';

export default {
    name: 'StoryBoardModify',
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
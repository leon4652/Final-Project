<template>
  <div class="modal" v-if="show">
    <div class="modal-content">
      <h1>모달 창이 열려도 여기 글자는 나와요</h1>
      <div v-if="review">
        <h2>{{ review.tripTitle }}</h2>
        <p>{{ review.userId }}</p>
        <p>{{ review.myPlanHit }}</p>
        <p>{{ review.myPlanLike }}</p>
        <p>{{ review.myPlanRegistDate }}</p>
      </div>
      <button @click="closeModal">Close</button>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    show: {
      type: Boolean,
      required: true,
    },
    review: {
      type: Object,
      default: null,
    },
  },
  methods: {
    closeModal() {
      this.$emit("close");
    },
  },
};
</script>

<style scoped>
.modal {
  position: absolute;
  top: 0;
  left: 0;
  width: 80%;
  height: 80%;
  display: flex;
  justify-content: right;
  align-items: right;
  z-index: 999;
  border: 1px solid coral;
}

.modal-content {
  background-color: white;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2);
  width: 80%; /* 모달의 가로 크기를 조절 */
  max-width: 600px; /* 모달의 최대 가로 크기를 설정 */
}
</style>

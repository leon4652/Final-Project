<template>
  <div>
    <h2>{{ total }}</h2>
    <h2>{{ countMsg }}</h2>
    <!-- mapGetter() 
    <h2>{{ $store.getters.msg1 }}</h2> //기존 불러왔던 구문
    <h2>{{ $store.getters.msg2 }}</h2>
    <h2>{{ $store.getters.msg3 }}</h2>
    -->
    <h2>{{ msg1 }}</h2>
    <!-- getters 구문 -->
    <h2>{{ msg2 }}</h2>
    <h2>{{ msg3 }}</h2>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  computed: {
    ...mapGetters({
      //계산되는 것이 많기 때문에 mapGetters를 사용하여 복잡한 구문을 삭제하였다.
      countMsg: "countMsg",
      msg1: "msg1",
      msg2: "msg2",
      msg3: "msg3",
    }),
    // ...mapGetters(["countMsg", "msg1", "msg2", "msg3"]),
    total() {
      return this.$store.state.count;
    },
    // countMsg() {
    //   return this.$store.getters.countMsg;
    // },
  },
};
</script>

<style></style>

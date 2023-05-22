<template>
  <div>
    <img
      class="set-image"
      src="https://www.urbanbrush.net/web/wp-content/uploads/edd/2022/12/urbanbrush-20221223093720209565.jpg"
      alt="Image"
    />
  </div>
</template>

<script>
import { mapMutations, mapState } from "vuex";

export default {
  name: "rsMain",
  components: {},
  computed: {
    ...mapState("mapStore", ["nowContentType"]),
  },
  data() {
    return {
      message: "",
    };
  },
  created() {},
  methods: {
    ...mapMutations("mapStore", ["SET_NOW_CONTENT_TYPE"]),
  },
};
</script>

<style scoped>
.set-image {
  max-width: 700px;
  height: 700px;
}
</style>

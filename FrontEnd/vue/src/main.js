import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

Vue.config.productionTip = false;

//전역 변수로 kakao map 객체 선언
window.map = null;

new Vue({
  router,
  store, // <-- vuex 요소 저장
  render: (h) => h(App),
}).$mount("#app");

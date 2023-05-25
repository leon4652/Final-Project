<template>
  <div>
    <h2>User Profile</h2>
    <b-container class="bv-example-row mt-3" v-if="!editMode" @submit.prevent="save">
      <b-row>
        <b-col>
          <b-alert variant="secondary" show><h3>회원 정보</h3></b-alert>
        </b-col>
      </b-row>
      <b-row>
        <b-col></b-col>
        <b-col cols="8">
          <b-card class="text-center mt-3" style="max-width: 40rem" align="left">
            <b-form class="text-left">
              <b-form-group label="아이디:" label-for="userId">
                <b-form-input id="userId" :value="user.userId" readonly></b-form-input>
              </b-form-group>
              <b-form-group label="이름:" label-for="userName">
                <b-form-input id="userName" :value="users.userName" readonly></b-form-input>
              </b-form-group>
              <b-form-group label="이메일:" label-for="email">
                <b-form-input id="email" type="email" :value="users.email0" readonly></b-form-input>
              </b-form-group>
              <b-form-group label="시/도:" label-for="sido">
                <b-form-input id="sido" :value="users.sidoName" readonly></b-form-input>
              </b-form-group>

              <b-form-group label="구/군:">
                <b-form-input id="gugun" :value="users.gugunName" readonly></b-form-input>
              </b-form-group>

              <b-form-group label="생년월일:" label-for="birth">
                <b-form-input id="birth" :value="selectedDate" readonly></b-form-input>
              </b-form-group>
              <b-button type="button" variant="success" class="m-1" @click="editMode = true"
                >수정하기</b-button
              >
            </b-form>
          </b-card>
        </b-col>
        <b-col></b-col>
      </b-row>
    </b-container>

    <b-container class="bv-example-row mt-3" v-else @submit.prevent="save">
      <b-row>
        <b-col>
          <b-alert variant="secondary" show><h3>정보 수정</h3></b-alert>
        </b-col>
      </b-row>
      <b-row>
        <b-col></b-col>
        <b-col cols="8">
          <b-card class="text-center mt-3" style="max-width: 40rem" align="left">
            <b-form class="text-left">
              <b-form-group label="아이디:" label-for="userId">
                <b-form-input
                  id="userId"
                  v-model="user.userId"
                  :required="true"
                  @input="resetValidation()"
                  placeholder="아이디 입력...."
                  readonly
                ></b-form-input>
              </b-form-group>
              <div v-if="showErrorMessage" class="invalid-feedback">입력값이 필요합니다.</div>
              <b-form-group label="비밀번호:" label-for="userPw">
                <b-form-input
                  type="password"
                  id="userPw"
                  v-model="users.userPw"
                  required
                  placeholder="비밀번호 입력...."
                ></b-form-input>
              </b-form-group>
              <b-form-group label="이름:" label-for="userName">
                <b-form-input
                  id="userName"
                  v-model="users.userName"
                  required
                  placeholder="이름 입력...."
                ></b-form-input>
              </b-form-group>
              <b-form-group label="이메일:" label-for="email">
                <b-form-input
                  id="email"
                  type="email"
                  v-model="users.email0"
                  required
                  placeholder="이메일 입력...."
                ></b-form-input>
              </b-form-group>
              <b-form-group label="시/도:">
                <select-sido @select-sido="selectSido"></select-sido>
              </b-form-group>

              <b-form-group label="구/군:">
                <select-gugun :sidoCode="sidoCode" @select-gugun="selectGugun"></select-gugun>
              </b-form-group>

              <b-form-group label="생년월일:" label-for="birth">
                <b-form-datepicker
                  id="birth"
                  v-model="selectedDate"
                  :formatter="customDateFormatter()"
                ></b-form-datepicker>
              </b-form-group>
              <b-button type="button" variant="success" class="m-1" @click="confirm"
                >수정하기</b-button
              >
              <b-button type="button" variant="warning" class="m-1" @click="editMode = false"
                >취소하기</b-button
              >
            </b-form>
          </b-card>
        </b-col>
        <b-col></b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import SelectGugun from "../item/SelectGugun.vue";
import SelectSido from "../item/SelectSido.vue";

const myPageStore = "myPageStore";

export default {
  components: { SelectGugun, SelectSido },
  data() {
    return {
      users: {
        userId: null,
        userPw: null,
        userName: null,
        email0: "",
        sido: 0,
        gugun: 0,
        birthYear: 0,
        birthMonth: "",
        birthDate: "",
      },
      selectedDate: null,
      editMode: false,
      sidoCode: null,
      gugunCode: null,
      showErrorMessage: false,
      userNo: 0,
    };
  },
  computed: {
    ...mapState(myPageStore, ["user", "isUpdate"]),
  },
  async created() {
    // 마이페이지 접근 시 로그인된 회원의 정보를 가져와야함
    await this.getUser();
    this.users = this.user;

    // selectedDate를 YYYY-MM-DD 형식으로 변경
    const year = String(this.user.birthYear);
    const month = String(this.user.birthMonth).padStart(2, "0");
    const day = String(this.user.birthDate).padStart(2, "0");
    this.selectedDate = `${year}-${month}-${day}`;
  },
  methods: {
    resetValidation() {
      this.showErrorMessage = false;
    },
    // 사용자 정보 변경 모드로 전환
    save() {
      this.editMode = false;
    },

    ...mapActions(myPageStore, ["getUser", "updateUser"]),
    async confirm() {
      if (this.inputValue === "") {
        this.showErrorMessage = true;
      } else {
        this.editMode = false;
      }
      // store에 있는 state에 있는 isSignUp에 따라 동작하도록 변경해야함
      await this.updateUser(this.users)
        .then(() => {
          // isUpdate가 0이 아니면 state에 있는 user를 화면에 보여주고
          // 다시 mypage로 이동
          if (this.isUpdate !== 0) this.$router.push({ name: "Home" });
        })
        .catch(console.log("실패"));
    },
    customDateFormatter(value) {
      value = this.selectedDate;
      const date = new Date(value);

      const year = date.getFullYear(); // 숫자로 된 연도
      const month = date.getMonth() + 1; // 숫자로 된 월
      const day = date.getDate(); // 숫자로 된 일

      this.user.birthYear = year;
      this.user.birthMonth = month;
      this.user.birthDate = day;
    },
    selectSido(sidoCode) {
      this.sidoCode = sidoCode;
      this.user.sido = sidoCode;
    },
    selectGugun(gugunCode) {
      this.user.gugun = gugunCode;
    },
  },
};
</script>

<style scoped></style>

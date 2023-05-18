<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert variant="secondary" show><h3>회원가입</h3></b-alert>
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
                required
                placeholder="아이디 입력...."
              ></b-form-input>
            </b-form-group>
            <b-form-group label="비밀번호:" label-for="userPw">
              <b-form-input
                type="password"
                id="userPw"
                v-model="user.userPw"
                required
                placeholder="비밀번호 입력...."
              ></b-form-input>
            </b-form-group>
            <b-form-group label="이름:" label-for="userName">
              <b-form-input
                id="userName"
                v-model="user.userName"
                required
                placeholder="이름 입력...."
              ></b-form-input>
            </b-form-group>
            <b-form-group label="이메일:" label-for="email">
              <b-form-input
                id="email"
                type="email"
                v-model="user.email"
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
                :value-as-date="true"
                :formatter="customDateFormatter()"
              ></b-form-datepicker>
            </b-form-group>
            <b-button type="button" variant="success" class="m-1" @click="confirm"
              >회원가입</b-button
            >
          </b-form>
        </b-card>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container>
</template>

<script>
import SelectGugun from '../item/SelectGugun.vue';
import SelectSido from '../item/SelectSido.vue';

export default {
  name: 'SignUp',
  components: { SelectGugun, SelectSido },
  data() {
    return {
      user: {
        userId: '',
        userPw: '',
        userName: '',
        email: '',
        sido: 0,
        gugun: 0,
        birthYear: 0,
        birthMonth: '',
        birthDate: '',
      },
      selectedDate: null,
      sidoCode: 0,
    };
  },
  created() {},
  methods: {
    confirm() {
        console.dir(this.user);
      console.log('회원 가입');
    },
    customDateFormatter(value) {
      value = this.selectedDate;
      const date = new Date(value);

      const year = date.getFullYear(); // 숫자로 된 연도
      const month = date.toLocaleString('default', { month: 'long' }); // 문자열로 된 월
      const day = date.toLocaleString('default', { day: 'numeric' }); // 문자열로 된 일

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

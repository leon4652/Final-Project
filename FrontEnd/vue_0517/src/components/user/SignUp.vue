<template>
  <!-- 
    해야 할 일
    아이디 중복 체크
   -->

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
                ref="userId"
              ></b-form-input>
              <b-button type="button" variant="success" class="m-1" @click="checkDuplicate"
                >아이디 중복 확인</b-button
              >
            </b-form-group>
            <b-form-group label="비밀번호:" label-for="userPw">
              <b-form-input
                type="password"
                id="userPw"
                v-model="user.userPw"
                required
                placeholder="비밀번호 입력...."
                ref="password"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="이름:" label-for="userName">
              <b-form-input
                id="userName"
                v-model="user.userName"
                required
                placeholder="이름 입력...."
                ref="name"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="이메일:" label-for="email">
              <b-form-input
                id="email"
                type="email"
                v-model="user.email0"
                required
                placeholder="이메일 입력...."
              ></b-form-input>
            </b-form-group>
            <b-form-group label="시/도:">
              <select-sido @select-sido="selectSido"></select-sido>
            </b-form-group>

            <b-form-group label="구/군:" ref="gugun">
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
import { mapActions } from 'vuex';
import SelectGugun from '../item/SelectGugun.vue';
import SelectSido from '../item/SelectSido.vue';

export default {
  name: 'SignUp',
  components: { SelectGugun, SelectSido },
  data() {
    return {
      user: {
        userId: null,
        userPw: null,
        userName: null,
        email: '',
        sido: 0,
        gugun: 0,
        birthYear: 0,
        birthMonth: 0,
        birthDate: 0,
      },
      selectedDate: null,
      sidoCode: 0,
      isDuplicate: false,
    };
  },
  created() {},
  methods: {
    ...mapActions('userStore', ['userSignup', 'duplicateId']),
    async confirm() {
      let err = true;
      let msg = "";
      // 입력값 중에 필수 입력 -> 아이디, 비밀번호, 이름 입력이 없으면 focus
         !this.user.userId &&
        ((msg = "아이디 입력해주세요"), (err = false), this.$refs.userId.focus());
      err &&
        !this.user.userPw &&
        ((msg = "비밀번호 입력해주세요"), (err = false), this.$refs.password.focus());
      err &&
        !this.user.userName &&
        ((msg = "이름 입력해주세요"), (err = false), this.$refs.name.focus());

      // 시도만 입력하고 구군을 입력안하면 안되도록
      err &&
        this.user.sido && !this.user.gugun &&
        ((msg = "구군 정보 입력해주세요"), (err = false), this.$refs.name.focus());

      if (!err) alert(msg)
      else {
        // store에 있는 state에 있는 isSignUp에 따라 동작하도록 변경해야함
        await this.userSignup(this.user)
          .then(() => {
            this.$router.push({ name: 'login' });
          })
          .catch(console.log('실패'));
      }
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
    async checkDuplicate() {
      console.log(this.user.userId)
      /**
       * 서버에 입력 받은 아이디를 넘겨줌 -> 아이디만
       * DB에서 전달 받은 아이디를 중복 체크 함
       */
      if (this.user.userId) {
        await this.duplicateId(this.user.userId)
        .then(() => {
          this.isDuplicate = true;
        }).catch(
          console.log('실패띠')
        )
      }
    },
  },
};
</script>

<style scoped></style>

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

              <p v-if="isButtonClicked && !user.userId" style="color: red">아이디 입력해주세요</p>
              <p v-if="isButtonClicked && user.userId && !isDuplicate" style="color: red">
                아이디 중복 검사하세요.
              </p>

              <b-button type="button" variant="success" class="m-1 btn" @click="checkDuplicate"
                >아이디 중복 확인</b-button
              >
              <p v-if="isDuplicate" style="color: blue">사용 가능한 아이디입니다</p>
              <!-- <p v-else style="color: red;">사용중인 아이디입니다</p> -->
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

              <p v-if="isButtonClicked && !user.userPw" style="color: red">
                비밀번호 입력해주세요.
              </p>
            </b-form-group>
            <b-form-group label="이름:" label-for="userName">
              <b-form-input
                id="userName"
                v-model="user.userName"
                required
                placeholder="이름 입력...."
                ref="name"
              ></b-form-input>

              <p v-if="isButtonClicked && !user.userName" style="color: red">이름 입력해주세요.</p>
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

            <p v-if="isButtonClicked && user.sido !== 0 && user.gugun === 0" style="color: red">
              구/군 정보 입력해주세요.
            </p>

            <b-form-group label="생년월일:" label-for="birth">
              <b-form-datepicker
                id="birth"
                v-model="selectedDate"
                :formatter="customDateFormatter()"
              ></b-form-datepicker>
            </b-form-group>
            <b-button type="button" variant="success" class="m-1 btn" @click="confirm"
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
import { mapActions, mapState } from 'vuex';
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
      isButtonClicked: false,
    };
  },
  computed: {
    ...mapState('userStore', ['isDuplicated']),
  },
  created() {},
  methods: {
    ...mapActions('userStore', ['userSignup', 'duplicateId']),
    async confirm() {
      this.isButtonClicked = true;
      let err = true;

      // 입력값 중에 필수 입력 -> 아이디, 비밀번호, 이름 입력이 없으면 focus
      !this.user.userId && ((err = false), this.$refs.userId.focus());
      err && !this.isDuplicate && ((err = false), this.$refs.userId.focus());
      err && !this.user.userPw && ((err = false), this.$refs.password.focus());
      err && !this.user.userName && ((err = false), this.$refs.name.focus());

      // 시도만 입력하고 구군을 입력안하면 안되도록
      err && this.user.sido && !this.user.gugun && ((err = false), this.$refs.name.focus());

      if (err) {
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
      /**
       * 서버에 입력 받은 아이디를 넘겨줌 -> 아이디만
       * DB에서 전달 받은 아이디를 중복 체크 함
       */
      if (this.user.userId) {
        await this.duplicateId(this.user.userId);
        this.isDuplicate = this.isDuplicated;
      }
    },
  },
};
</script>

<style scoped>
.btn{
    background-color: #23d335;
  border: none;
}
.btn:hover{
      background-color: #14a323;
  border: none;
}
</style>

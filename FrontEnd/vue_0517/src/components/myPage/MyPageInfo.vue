<template>
  <div>
    <h2>User Profile</h2>
    <!-- <div v-if="!editMode">
      <span>ID: {{ user.userId }}</span>
      <br />
      <span>Name: {{ user.userName }}</span>
      <br />
      <span>Email: {{ user.email0 }}</span>
      <br />
      <span>Sido: {{ user.sido }} | </span>
      <span>Gugun: {{ user.gugun }}</span>
      <br />
      <span>Birth Year: {{ user.birthYear }} | </span>
      <span>Birth Month: {{ user.birthMonth }} | </span>
      <span>Birth Date: {{ user.birthDate }}</span>
      <br />
      <button @click="editMode = true">Edit</button>
    </div> -->

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
                <b-form-input
                  id="userId"
                  :value="user.userId"
                  :required="true"
                  readonly
                ></b-form-input>
              </b-form-group>
              <b-form-group label="이름:" label-for="userName">
                <b-form-input
                  id="userName"
                  :value="users.userName"
                  required
                ></b-form-input>
              </b-form-group>
              <b-form-group label="이메일:" label-for="email">
                <b-form-input
                  id="email"
                  type="email"
                  :value="users.email0"
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
                  :value="selectedDate"
                  :value-as-date="true"
                  :formatter="customDateFormatter()"
                ></b-form-datepicker>
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
    <!-- <form v-else @submit.prevent="save">
      <label for="name">Name:</label>
      <input type="text" id="name" v-model="user.name" readonly />
      <br />
      <label for="email">Password:</label>
      <input type="password" id="password" v-model="user.password" />
      <br />
      <label for="email">Email:</label>
      <input type="email" id="email" v-model="user.email" />
      <br />

      <label for="sido">Sido:</label>
      <input type="text" id="sido" v-model="user.sido" />
      <br />
      <div>sido</div>
      <select v-model="sidoCode" :options="sidos" @change="gugunList"></select>
      <div>gugun</div>
      <select v-model="gugunCode" :options="guguns"></select>
      <br />

      <label for="gugun">Gugun:</label>
      <input type="text" id="gugun" v-model="user.gugun" />
      <br />
      <label for="birthYear">Birth Year:</label>
      <input type="number" id="birthYear" v-model="user.birthYear" />
      <br />
      <label for="birthMonth">Birth Month:</label>
      <input type="number" id="birthMonth" v-model="user.birthMonth" />
      <br />
      <label for="birthDate">Birth Date:</label>
      <input type="number" id="birthDate" v-model="user.birthDate" />
      <br />
      <button type="submit">Save</button>
      <button type="button" @click="editMode = false">Cancel</button>
    </form> -->

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
                  :value-as-date="true"
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
import { mapActions, mapState } from 'vuex';
import SelectGugun from '../item/SelectGugun.vue';
import SelectSido from '../item/SelectSido.vue';

const myPageStore = 'myPageStore';

export default {
  components: { SelectGugun, SelectSido },
  data() {
    return {
      users: {
        userId: null,
        userPw: null,
        userName: null,
        email0: '',
        sido: 0,
        gugun: 0,
        birthYear: 0,
        birthMonth: '',
        birthDate: '',
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
    // ...mapState(['sidos', 'guguns']),
    ...mapState(myPageStore, ['user', 'isUpdate']),
  },
  async created() {
    // 마이페이지 접근 시 로그인된 회원의 정보를 가져와야함
    await this.getUser();
    this.users = this.user;
  },
  methods: {
    resetValidation() {
      this.showErrorMessage = false;
    },
    save() {
      // TODO: 사용자 정보 저장 로직 구현
      this.editMode = false;
    },

    ...mapActions(myPageStore, ['getUser', 'updateUser']),
    async confirm() {
      console.dir(this.users);
      if (this.inputValue === '') {
        this.showErrorMessage = true;
      } else {
        this.editMode = false;
      }
      // store에 있는 state에 있는 isSignUp에 따라 동작하도록 변경해야함
      await this.updateUser(this.users)
        .then(() => {
          // isUpdate가 0이 아니면 state에 있는 user를 화면에 보여주고
          // 다시 mypage로 이동
          if (this.isUpdate !== 0) this.$router.push({ name: 'myPage' });
        })
        .catch(console.log('실패'));
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

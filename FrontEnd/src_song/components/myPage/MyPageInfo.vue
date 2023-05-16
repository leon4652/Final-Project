<template>
  <div>
    <h2>User Profile</h2>
    <div v-if="!editMode">
      <span>Name: {{ user.name }}</span>
      <br />
      <span>Email: {{ user.email }}</span>
      <br />
      <span>Sido: {{ user.sido }} | </span>
      <span>Gugun: {{ user.gugun }}</span>
      <br />
      <span>Birth Year: {{ user.birthYear }} | </span>
      <span>Birth Month: {{ user.birthMonth }} | </span>
      <span>Birth Date: {{ user.birthDate }}</span>
      <br />
      <button @click="editMode = true">Edit</button>
    </div>
    <form v-else @submit.prevent="save">
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

      <!-- <select v-model="selectedSido">
      <option value="">시/도 선택</option>
      <option v-for="sido in sidos" :value="sido.id" :key="sido.id">{{ sido.name }}</option>
      </select> -->
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
    </form>
  </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';

export default {
  data() {
    return {
      user: {
        name: 'John Doe',
        email: 'johndoe@example.com',
        sido: '대전',
        gugun: '서구',
        birthYear: '1997',
        birthMonth: '8',
        birthDate: '1',
      },
      editMode: false,
      sidoCode: null,
      gugunCode: null,
    };
  },
  computed: {
    ...mapState(['sidos', 'guguns']),
  },
  created() {
    this.getSido();
    // 마이페이지 접근 시 로그인된 회원의 정보를 가져와야함
  },
  methods: {
    save() {
      // TODO: 사용자 정보 저장 로직 구현
      this.editMode = false;
    },

    ...mapActions(['getSido', 'getGugun']),
    gugunList() {
      this.gugunCode = null;
      if (this.sidoCode) this.getGugun(this.sidoCode);
    },
  },
};
</script>

<style scoped></style>

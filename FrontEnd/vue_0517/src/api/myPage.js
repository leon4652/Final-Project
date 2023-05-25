import { apiInstance } from './http.js';
import tokenHttp from '@/api/tokenHttp.js';

const api = apiInstance();

async function getUserInfo(success, fail) {
  await tokenHttp.get(`/mypage/`).then(success).catch(fail);
}

async function updateUserInfo(user, success, fail) {
  await api.put(`/mypage/${user.userNo}`, user).then(success).catch(fail);
}

export { getUserInfo, updateUserInfo };

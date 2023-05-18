import { apiInstance } from './http.js';

const api = apiInstance();

async function login(user, success, fail) {
  console.dir(user);
  await api.post(`/user/login`, JSON.stringify(user)).then(success).catch(fail);
  // await api.post(`/user/login`, user).then(success).catch(fail);
}

async function findById(userId, success, fail) {
  api.defaults.headers['access-token'] = sessionStorage.getItem('access-token');
  await api.get(`/user/info/${userId}`).then(success).catch(fail);
}

async function tokenRegeneration(user, success, fail) {
  //axios header에 refresh-token 셋팅
  api.defaults.headers['refresh-token'] = sessionStorage.getItem('refresh-token');
  await api.post(`/user/refresh`, user).then(success).catch(fail);
}

async function logout(userId, success, fail) {
  await api.get(`/user/logout/${userId}`).then(success).catch(fail);
}

async function getIfo(userId, success, fail) {
  await api.get(`/user/info/${userId}`).then(success).catch(fail);
}

export { login, findById, tokenRegeneration, logout, getIfo };

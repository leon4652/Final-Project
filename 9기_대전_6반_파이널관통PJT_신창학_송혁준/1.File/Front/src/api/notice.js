import { apiInstance } from "./http";

const api = apiInstance();

async function select(success, fail) {
  await api.get(`/notice/list`).then(success).catch(fail);
}

async function getNotice(noticeNo, success, fail) {
  await api
    .get(`/notice/info/` + noticeNo)
    .then(success)
    .catch(fail);
}

async function write(notice, success, fail) {
  await api.post(`/notice/write`, notice).then(success).catch(fail);
}

async function deleteNotice(noticeNo, success, fail) {
  await api
    .delete(`/notice/delete/` + noticeNo)
    .then(success)
    .catch(fail);
}

async function modify(notice, success, fail) {
  await api
    .put(`/notice/update/` + notice.noticeNo, notice)
    .then(success)
    .catch(fail);
}

async function subSelect(success, fail) {
  await api.get(`/notice/sublist`).then(success).catch(fail);
}

export { select, getNotice, write, deleteNotice, modify, subSelect };

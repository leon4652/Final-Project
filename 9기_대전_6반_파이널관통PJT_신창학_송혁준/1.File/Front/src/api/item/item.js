import { apiInstance } from "../http";

const api = apiInstance();

async function sidoList(success, fail) {
  await api.get(`/attraction/sido`).then(success).catch(fail);
}

function gugunList(params, success, fail) {
  api.get(`/attraction/gugun/`+ params.sido).then(success).catch(fail);
}

export { sidoList, gugunList };

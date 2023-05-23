import { apiInstance } from "./http";

const api = apiInstance();

async function select(success, fail) {
  await api.get(`/storyboard/list`).then(success).catch(fail);
}

async function getBoard(storyBoardNo, success, fail) {
  await api
    .get(`/storyboard/info/` + storyBoardNo)
    .then(success)
    .catch(fail);
}

async function write(storyBoard, success, fail) {
  await api.post(`/storyboard/write`, storyBoard).then(success).catch(fail);
}

async function deleteBoard(storyBoardNo, success, fail) {
  await api
    .delete(`/storyboard/delete/` + storyBoardNo)
    .then(success)
    .catch(fail);
}

async function modify(storyBoard, success, fail) {
  await api
    .put(`/storyboard/update/` + storyBoard.storyBoardNo, storyBoard)
    .then(success)
    .catch(fail);
}

export { select, getBoard, write, deleteBoard, modify };

import { select, getBoard, write, deleteBoard, modify } from '@/api/storyBoard';

const storyBoardStore = {
    namespaced: true,
    state: {
        storyBoard: null,
        storyBoards: [],
        isWrite: false,
        isDelete: false,
        isUpdate: false,
    },
    mutations: {
        SET_STORYBOARD_LIST(state, storyBoards) {
            storyBoards.forEach((story) => {
                state.storyBoards.push(story);
            });
        },
        SET_STORYBOARD(state, storyBoard) {
            state.storyBoard = storyBoard;
        },
        SET_IS_WRITE(state, isWrite) {
            state.isWrite = isWrite;
        },
        SET_IS_DELETE(state, isDelete) {
            state.isDelete = isDelete;
        },
        SET_IS_UPDATE(state, isUpdate) {
            state.isUpdate = isUpdate;
        },
    },
    actions: {
        // story board list 불러오기
        async getStoryBoardList({commit}) {
            await select (
                ({data}) => {
                    commit('SET_STORYBOARD_LIST' ,data)
                },
                (error) => {
                    console.log(error)
                }
            )
        },
        // story board 정보 불러오기 -> view page로 넘길 것
        async getStoryBoard({commit}, storyBoardNo) {
            await getBoard(
                storyBoardNo,
                ({data}) => {
                    commit('SET_STORYBOARD', data);
                },
                (error) => {
                    console.log(error);
                }
            )
        },

        // story board 작성
        async writeStoryBoard({commit}, storyBoard) {
            await write(
                storyBoard,
                ({data}) => {
                    if (data.message === 'success') {
                        commit('SET_IS_WRITE', true)
                    }
                },
                (error) => {
                    console.log(error)
                }
            )
        },

        // story board 삭제
        async deleteStoryBoard({commit}, storyBoardNo) {
            await deleteBoard(
                storyBoardNo,
                ({data}) => {
                    if (data.message === 'success') {
                        commit('SET_IS_DELETE', true)
                    }
                },
                (error) => {
                    console.log(error)
                }
            )
        },

        // story board 수정
        async modifyStoryBoard({commit}, storyBoard) {
            await modify(
                storyBoard,
                ({data}) => {
                    if (data.message === 'success') {
                        commit('SET_IS_UPDATE', true)
                    }
                },
                (error) => {
                    console.log(error)
                }
            )
        }

    }

}

export default storyBoardStore;
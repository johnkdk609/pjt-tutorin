import {ref, computed} from "vue";
import {defineStore} from "pinia";
import axios from "axios";

const REST_API = `http://localhost:8080/mentor`;

export const useMentorStore = defineStore("mentor", () => {
  const mentorList = ref([]);
  const mentor = ref({});
  const userStatus = ref(["멘티", "멘토(활둥 중)", "멘토(비 활동 중)"]);

  const getMentor = function (id) {
    axios
      .get(`${REST_API}/${id}`)
      .then((res) => {
        mentor.value = res.data;
      })
      .catch((e) => {});
  };

  // javascript object
  // { id: "andrew"}
  // => JSON
  // { "id": "andrew"}

  const postMentor = function () {
    axios
      .post(REST_API, mentor.value)
      .then(() => {})
      .catch((e) => {
        alert("전환실패");
      });
  };

  const updateMentor = function (id) {
    axios
      .put(REST_API + "/" + id, mentor.value)
      .then(() => {})
      .catch((e) => {
        alert("변경에 실패하였습니다." + e);
      });
  };

  const deleteMentor = function (id) {
    axios
      .delete(REST_API + "/" + id)
      .then(() => {
        // alert("멘토 탈퇴 완료");
      })
      .catch((e) => {
        // alert("삭제에 실패하였습니다." + e);
      });
  };

  return {
    mentor,
    mentorList,
    postMentor,
    updateMentor,
    getMentor,
    deleteMentor,
  };
});

import {ref, computed} from "vue";
import {defineStore} from "pinia";
import axios from "axios";
import router from "../router";

const REST_API = `http://localhost:8080/user`;

export const useUserStore = defineStore("user", () => {
  const userList = ref([]);
  const user = ref({});
  const userStatus = ref(["멘티", "멘토(활둥 중)", "멘토(비 활동 중)"]);

  const getUser = function (id) {
    axios
      .get(`${REST_API}/${id}`)
      .then((res) => {
        user.value = res.data;
      })
      .catch((e) => {});
  };

  const postUser = async (router) => {
    try {
      await axios.post(REST_API + "/regist", user.value);
      alert("회원가입이 완료되었습니다. (로그인 창으로 이동)");
      router.push({name: "login"}); // 성공 시 리디렉션
    } catch (e) {
      alert("가입에 실패하였습니다." + e);
    }
  };

  const updateUser = function (id) {
    alert(user.value.menteeIntro);
    axios
      .put(REST_API + "/" + id, user.value)
      .then(() => {})
      .catch((e) => {
        alert("변경에 실패하였습니다." + e);
      });
  };

  const deleteUser = function (id) {
    axios
      .delete(REST_API + "/" + id)
      .then(() => {
        alert("회원 탈퇴가 완료되었습니다");
      })
      .catch((e) => {
        alert("회원 탈퇴에 실패하였습니다." + e);
      });
  };
  return {user, userList, postUser, updateUser, getUser, deleteUser};
});

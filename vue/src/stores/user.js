import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "../router"

const REST_API = `http://localhost:8080/user`;

export const useUserStore = defineStore("user", () => {
  const userList = ref([]);
  const user = ref({});
  const userStatus = ref(['대기중', '답변중', '질문가능', '답변필요', '완료', '거절됨']);


  const postUser = async (router) => {
    try {
      await axios.post(REST_API, user.value);
      alert("회원가입이 완료되었습니다. (로그인 창으로 이동)");
      router.push({ name: "login" }); // 성공 시 리디렉션
    } catch (e) {
      alert('가입에 실패하였습니다.' + e);
    }
  };


  return { user, userList, postUser};
});

import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';
import router from '../router';


export const useLoginStore = defineStore('login', {
  state: () => {
    const accessToken = ref('');
  const loginUser = ref({});

  // const login2 = (userInfo) => {
  //   axios.post('http://localhost:8080/user/login', userInfo)
  //   .then((res)=>{
  //     console.log('로그인 성공')
  //     console.log(res)
  //   })
  //   .catch(e=>{
  //     console.log('로그인 실패')
  //     console.log(e);
  //   });
  // }


  const login = async (userInfo) => {
    try {
      console.log("로그인 시도")
      console.log(userInfo)
      const res = await axios.post('http://localhost:8080/user/login', userInfo);
      // console.log(res)
      accessToken.value = res.data.accessToken;
      loginUser.value = { ...userInfo, id: res.data.id, password: res.data.password, email: res.data.email, name: res.data.name, nickname: res.data.nickname, phoneNum: res.data.phoneNum, image: res.data.image, menteeIntro: res.data.menteeIntro, status: res.data.status, createTime: res.data.createTime};
      router.push({ name: 'home' });
    } catch (e) {
      alert('로그인 실패. 아이디 패스워드를 확인해주세요.')
      console.log('로그인 실패');
      console.log(e);
    }
  };

  const logout = () => {
    accessToken.value = '';
    loginUser.value = {};
  };

  return { accessToken, loginUser, login, logout };
  },
  persist: true,
})
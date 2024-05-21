<template>
  <h1>로그인창입니다.</h1>
  <div class="container">
    <div class="formbox">

      <h2>Tutorin</h2>
      <input type="text" placeholder="id" v-model="id">
      <br>
      <input type="text" placeholder="password" v-model="password">
      <br>
      <input type="checkbox" value="save"><label>아이디 저장</label> <!-- 여기서 h를 label로 수정 -->
      <br>
      <button @click="handleLogin">로그인</button>
      <br>
      <RouterLink to="/regist">회원가입</RouterLink>

    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useLoginStore } from '@/stores/login';

const loginStore = useLoginStore();
const id = ref('')
const password = ref('')

const handleLogin = () => {
    const userInfo = {
        id: id.value,
        password: password.value
    }

    loginStore.login(userInfo);

}

</script>

<style scoped>
.container {
  
  display: flex;
  justify-content: center; /* 수평 가운데 정렬 */
  align-items: center; /* 수직 가운데 정렬 */
}

.formbox {
  height: 600px;
  width:  400px;
  background-color: aliceblue;
  text-align: center;
}
</style>

<template>
  <div class="container">
    <div class="box">
      <span class="title">Tutorin</span>
      <div>
        <span
          >ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span
        >
        <input type="text" v-model="id" />
      </div>
      <div>
        <span>Password&nbsp;</span>
        <input type="text" v-model="password" />
        <p></p>
        <div class="save-id">
          <input type="checkbox" value="save" /><label>아이디 저장</label>
        </div>
      </div>
      <div class="buttons">
        <button @click="handleLogin">로그인</button>
        <button>비밀번호 찾기</button>
        <button><RouterLink to="/regist">회원가입</RouterLink></button>
      </div>
    </div>
  </div>
</template>

<script setup>
import {ref} from "vue";
import {useLoginStore} from "@/stores/login";

const loginStore = useLoginStore();
const id = ref("");
const password = ref("");

const handleLogin = () => {
  const userInfo = {
    id: id.value,
    password: password.value,
  };
  loginStore.login(userInfo);
};
</script>

<style scoped>
.title {
  font-size: 70px;
}

.container {
  padding: 20px;
  display: flex;
  justify-content: center; /* 수평 가운데 정렬 */
  align-items: center; /* 수직 가운데 정렬 */
}

input {
  margin: 5px;
}

button {
  margin: 5px;
}

button a {
  text-decoration: none;
  color: black;
}

.box {
  height: 600px;
  width: 80%;
  background-color: aliceblue;
  text-align: center;
}

.save-id {
  text-align: left;
  margin-left: 36%;
}
</style>

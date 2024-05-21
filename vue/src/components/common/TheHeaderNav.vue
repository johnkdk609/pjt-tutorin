<template>
  <div>
    <header>
      <nav class="nav-container">
        <RouterLink to="/" class="left"><h1>Tutorin</h1></RouterLink>
          <div class="right-links">
            <div v-if="!isLoggedIn">
              <RouterLink to="/login" class="right">로그인</RouterLink> |
              <RouterLink :to="{ name: 'regist' }" class="right">회원가입</RouterLink>
            </div>
            <div v-if="isLoggedIn">
              <RouterLink to="/my" class="right">마이페이지</RouterLink> |
              <RouterLink :to="{ name: 'mentee_profile' }" class="right">마이프로필</RouterLink> |
              <RouterLink :to="{ name: 'mentor_profile' }" class="right">마이프로필멘토</RouterLink> |
            </div>
          <button @click="tokentest">tokencheck</button>
        </div>
      </nav>
    </header>
  </div>
</template>

<script setup>
import {ref, onMounted} from 'vue'
import { useRouter } from 'vue-router';
import { useLoginStore } from '@/stores/login';
const tokentest = function(){
  console.log(loginStore.accessToken)
  console.log(isLoggedIn)
}
const isLoggedIn = ref(false);

onMounted(() => {
  if (loginStore.accessToken === '') {
    isLoggedIn.value = false;
  } else {
    isLoggedIn.value = true;
  }
});


const router = useRouter();
const loginStore = useLoginStore();

const logout = () => {
  loginStore.logout();
  router.push('/login'); // Redirect to login after logout
}
</script>


<style scoped>
header {
  background-color: aliceblue;
  height: 100px;
}

.nav-container {
  display: flex;
  justify-content: space-between;
  align-items: end;
}

.left {
  text-align: left;
}

.right {
  text-align: right;
}

nav a {
  font-weight: bold;
  text-decoration: none;
  color: black;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>

<template>
  <div>
    <header>
      <nav class="nav-container">
        <RouterLink to="/" class="left"><span class="header-text">Tutorin</span></RouterLink>
        <div class="right-links">
          <button @click="tokentest">tokencheck</button>
            <div v-if="!loginStore.accessToken">
              <RouterLink to="/login" class="right">로그인</RouterLink> |
              <RouterLink :to="{ name: 'regist' }" class="right">회원가입</RouterLink>
            </div>
            <div v-if="loginStore.accessToken">
              <RouterLink to="/my" class="right">마이페이지</RouterLink> |
              <RouterLink :to="{ name: 'mentee_profile' }" class="right">마이프로필</RouterLink> |
              <RouterLink :to="{ name: 'mentor_profile' }" class="right">마이프로필멘토</RouterLink> |
              <span class="logoutBtn" @click="logout">로그아웃</span>    
            </div> 
        </div>
      </nav>
    </header>
    <hr>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router';
import { useLoginStore } from '@/stores/login';
const tokentest = function(){
  console.log('토큰:'+loginStore.accessToken)
}

const router = useRouter();
const loginStore = useLoginStore();

const logout = () => {
  loginStore.logout();
  router.push('/'); // Redirect to login after logout
}
</script>


<style scoped>
.logoutBtn{
  font-size: 20px;
  font-weight: bold;
  text-decoration: none;
  color: black;
  cursor: pointer;
}

nav a {
  font-size: 20px;
  font-weight: bold;
  text-decoration: none;
  color: black;
}

hr {
  width: 90%;
}

header {
  /* background-color: aliceblue; */
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



.header-text {
  font-size: 70px; /* 텍스트 크기를 크게 설정 */
  font-weight: bold; /* 텍스트를 굵게 설정 */
}
</style>

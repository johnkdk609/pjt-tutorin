<template>
  <div>
    <header>
      <nav class="nav-container">
        <RouterLink to="/" class="left"><span class="header-text">Tutorin</span></RouterLink>
        <div class="right-links">
          <!-- Image that toggles the dropdown menu -->
          <img 
            v-if="loginStore.loginUser.nickname !== undefined" 
            @click="toggleDropdown" 
            src="@/assets/main.jpg" 
            alt="User Image" 
            class="profile-image"
          >
          <span 
            v-if="loginStore.loginUser.nickname !== undefined" 
            style="font-size: 20px"
          >
            &nbsp;&nbsp;{{ loginStore.loginUser.nickname }}님 환영합니다.&nbsp;&nbsp;
          </span>

          <!-- <button @click="tokentest">tokencheck</button> -->
          
          <div v-if="!loginStore.accessToken">
            <RouterLink to="/login" class="right">로그인</RouterLink> |
            <RouterLink :to="{ name: 'regist' }" class="right">회원가입</RouterLink>
          </div>
          
          <!-- Dropdown menu for logged-in users -->
          <div v-if="loginStore.accessToken && showDropdown" class="dropdown-menu">
            <RouterLink 
              :to="{ name: 'myhome', params: { id: loginStore.loginUser.id } }" 
              class="dropdown-item"
            >
              마이페이지
            </RouterLink>
            <RouterLink 
              :to="{ name: 'mentee_profile', params: { id: loginStore.loginUser.id }  }" 
              class="dropdown-item"
            >
              마이프로필
            </RouterLink>
            <RouterLink 
              :to="{ name: 'mentor_profile', params: { id: loginStore.loginUser.id }  }" 
              class="dropdown-item"
            >
              마이프로필(멘토)
            </RouterLink>
            <span 
              class="dropdown-item logoutBtn" 
              @click="logout"
            >
              로그아웃
            </span>
          </div>
        </div>
      </nav>
    </header>
  </div>
  <hr>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { useLoginStore } from '@/stores/login';

const router = useRouter();
const loginStore = useLoginStore();
const showDropdown = ref(false);

const toggleDropdown = () => {
  showDropdown.value = !showDropdown.value;
};

const tokentest = () => {
  console.log('토큰:' + loginStore.accessToken);
  console.log('아이디:' + loginStore.loginUser.id);
  console.log('닉네임:' + loginStore.loginUser.nickname);
  console.log('폰번:' + loginStore.loginUser.phoneNum);
  console.log('가입일:' + loginStore.loginUser.createTime);
  console.log('비번:' + loginStore.loginUser.password);
  console.log('상태:' + loginStore.loginUser.status);
  console.log(loginStore.loginUser);
};

const logout = () => {
  loginStore.logout();
  router.push('/'); // Redirect to login after logout
  showDropdown.value = false; // Close the dropdown menu
};
</script>

<style scoped>
.profile-image {
  border-radius: 50%;
  width: 40px;
  cursor: pointer; /* Ensure the cursor changes to indicate the image is clickable */
}

.logoutBtn {
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
  font-size: 70px;
  font-weight: bold;
}

.dropdown-menu {
  display: block;
  position: absolute;
  background-color: white;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1001;
  right: 10px;
  top: 70px;
}

.dropdown-item {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-item:hover {
  background-color: #ddd;
}
</style>

<template>
  <div>
    <header>
      <nav class="nav-container">
        <RouterLink to="/" class="left">
          <img  
            @click="home" 
            src="@/assets/TutorInLogo.png" 
            alt="home button" 
            class="home"
          >
        </RouterLink>
        <div class="right-links" ref="rightLinks">
          <!-- Image that toggles the dropdown menu -->
          <div
            v-if="loginStore.loginUser.nickname !== undefined"
            @click="toggleDropdown"
          >
            <span
              v-if="loginStore.loginUser.nickname !== undefined"
              style="font-size: 20px"
            >
              &nbsp;&nbsp;{{ loginStore.loginUser.nickname }}님 환영합니다.&nbsp;&nbsp;
            </span>
            <img
              src="@/assets/main.jpg"
              alt="User Image"
              class="profile-image"
            >
          </div>

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
              :to="{ name: 'mentee_profile', params: { id: loginStore.loginUser.id } }"
              class="dropdown-item"
            >
              마이프로필
            </RouterLink>
            <RouterLink
              :to="{ name: 'mentor_profile', params: { id: loginStore.loginUser.id } }"
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
import { ref, onMounted, onBeforeUnmount } from 'vue';
import { useRouter } from 'vue-router';
import { useLoginStore } from '@/stores/login';

const router = useRouter();
const loginStore = useLoginStore();
const showDropdown = ref(false);
const rightLinks = ref(null);

const toggleDropdown = () => {
  showDropdown.value = !showDropdown.value;
};

const handleClickOutside = (event) => {
  if (rightLinks.value && !rightLinks.value.contains(event.target)) {
    showDropdown.value = false;
  }
};

onMounted(() => {
  document.addEventListener('click', handleClickOutside);
});

onBeforeUnmount(() => {
  document.removeEventListener('click', handleClickOutside);
});

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
}

.right-links {
  cursor: pointer;
  margin-right: 20px;
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

.home {
  width: 200px;
  margin: 12px;
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

<template>
  <div>
    <header>
      <nav class="nav-container">
        <RouterLink to="/" class="left"><h1>Tutorin</h1></RouterLink>
        <div class="right-links">
          <RouterLink to="/login" class="right">로그인</RouterLink> |
          <RouterLink :to="{ name: 'regist' }" class="right">회원가입</RouterLink> | <RouterLink to="/my" class="right">마이페이지</RouterLink> |
          <RouterLink :to="{ name: 'mentee_profile' }" class="right">마이프로필</RouterLink> |
          <RouterLink :to="{ name: 'mentor_profile' }" class="right">마이프로필멘토</RouterLink> |
          로그아웃
        </div>
      </nav>
    </header>
  </div>
</template>

<script setup></script>

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

<template>
  <div>
    <nav>
      <RouterLink to="/my">홈</RouterLink>
      <hr>
      <RouterLink to="/my/modify">개인 정보 수정</RouterLink>
      <hr>
      <RouterLink to="/my/modifyprofile">프로필 수정</RouterLink>
      <hr>
      <RouterLink to="/my/request/wait">상담 신청 내역</RouterLink>
      <hr>
      <RouterLink to="/my/response/wait">상담 수령 내역</RouterLink>
      <hr>
      <RouterLink to="/my/etc">기타</RouterLink>
    </nav>
  </div>
</template>

<script setup></script>

<style scoped>



nav a {
  font-weight: bold;
  text-decoration: none;
  color: black;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>

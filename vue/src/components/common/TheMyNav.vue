<template>
  <div class="container">
    <nav class="nav">
      <RouterLink to="/my">홈</RouterLink>
      <RouterLink to="/my/modify">개인 정보 수정</RouterLink>
      <RouterLink to="/my/modifyprofile">프로필 수정</RouterLink>
      <RouterLink to="/my/request/wait">상담 신청 내역</RouterLink>
      <RouterLink to="/my/response/wait">상담 수령 내역</RouterLink>
      <RouterLink to="/my/etc">기타</RouterLink>
    </nav>
  </div>
</template>

<script setup></script>

<style scoped>
.container {
  width: 150px; /* 네비게이션 너비 고정 */
}

.nav {
  /* background-color: aliceblue; */
  text-align: left;
  padding: 5px;
  margin-top: 40px;
  border-radius: 8px;
  display: flex;
  flex-direction: column; /* 세로 정렬 */
  gap: 15px; /* 각 링크 사이의 간격 */
}

nav a {
  text-decoration-line: underline;
  text-underline-offset : 7px;
  font-weight: lighter;
  color: black;
  font-size: 18px;
}
</style>

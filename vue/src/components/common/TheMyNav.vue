<template>
  <div class="container">
    <nav class="nav">
      <RouterLink :to="{ name: 'myhome', params: { id: loginStore.loginUser.id } }">홈</RouterLink>
      <RouterLink :to="{ name: 'modify', params: { id: loginStore.loginUser.id } }">개인 정보 수정</RouterLink>
      <RouterLink :to="{ name: 'modifyprofile', params: { id: loginStore.loginUser.id } }">프로필 수정</RouterLink>
      <RouterLink :to="{ name: 'reqwait', params: { id: loginStore.loginUser.id } }">상담 신청 내역</RouterLink>
      <RouterLink :to="{ name: 'reswait', params: { id: loginStore.loginUser.id } }">상담 수령 내역</RouterLink>
      <RouterLink :to="{ name: 'etc', params: { id: loginStore.loginUser.id } }">기타</RouterLink>
    </nav>
  </div>
</template>

<script setup>
import { useLoginStore } from '@/stores/login';
const loginStore = useLoginStore();
</script>

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

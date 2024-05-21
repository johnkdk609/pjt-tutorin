<template>
  <div>
    <h1>상담 신청 내역</h1>
    <div class="content">
      <RouterLink :to="{ name: 'reqwait' }">대기</RouterLink> |
      <RouterLink :to="{ name: 'reqproceed' }">진행</RouterLink> |
      <RouterLink :to="{ name: 'reqdone' }">지난</RouterLink>
      <RouterView />
    </div>
  </div>
</template>

<script setup>

</script>

<style scoped>
.content {
  background-color: rgb(255, 254, 214);
  margin: 20px;
}

</style>

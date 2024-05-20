<template>
  <div>
    <h1>마이페이지입니다</h1>
    <div class="my">
      <TheMyNav class="nav" />
      <div class="router-view">
        <RouterView />
      </div>
    </div>
  </div>
</template>

<script setup>
import TheMyNav from "@/components/common/TheMyNav.vue";
</script>

<style scoped>
.nav {
  width: 150px;
  height: 500px;
  background-color: aliceblue;
}
.my {
  display: flex;
}

.router-view {
  width: 90%;
  text-align: center;
  margin-left: 20px;
  margin-right: 20px;
  margin-top: 0; /* 위쪽 여백 제거 */
  margin-bottom: 0; /* 아래쪽 여백 제거 */
  background-color: rgb(212, 235, 255);
}
</style>

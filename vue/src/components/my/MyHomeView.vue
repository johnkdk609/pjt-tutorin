<template>
  <div>
    <h1>마이페이지 홈</h1>
    <div class="content">
      <h3>환영합니다, {{ loginStore.loginUser.nickname }}님</h3>

      <h3>☆활동 요약</h3>
      <h4>상담 횟수 : </h4>
      <h4 v-if="loginStore.loginUser.status===2">답변 횟수 : </h4>
      <h4>가입일 : {{ loginStore.loginUser.createTime }}</h4>
      
    </div>
    <div>
      <button type="button" class="btn btn-primary">Primary</button>
      <button type="button" class="btn btn-secondary">Secondary</button>
      <button type="button" class="btn btn-success">Success</button>
      <button type="button" class="btn btn-danger">Danger</button>
      <button type="button" class="btn btn-warning">Warning</button>
      <button type="button" class="btn btn-info">Info</button>
      <button type="button" class="btn btn-light">Light</button>
      <button type="button" class="btn btn-dark">Dark</button>
    </div>
    
  </div>
</template>

<script setup>
import { useRoute, useRouter } from "vue-router";
import { ref, onMounted, onUnmounted } from "vue";
import { useLoginStore } from "@/stores/login";
import { useUserStore } from "@/stores/user";
import { useMentorStore } from "@/stores/mentor";
import { useCounselStore } from "@/stores/counsel";

const userStore = useUserStore();
const loginStore = useLoginStore();
const mentorStore = useMentorStore();
const counselStore = useCounselStore();
</script>

<style scoped>
.content {
  background-color: rgb(255, 254, 214);
  margin: 20px;
  height: 500px;
}
</style>

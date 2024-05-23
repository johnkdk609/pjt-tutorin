<template>
  <div>
    <h1>마이페이지 홈</h1>
    <div class="content">
      <h3>환영합니다, {{ loginStore.loginUser.nickname }}님</h3>

      <h3>☆활동 요약</h3>
      <h4>질문 횟수 : {{ requestNum }}</h4>
      <h4 v-if="loginStore.loginUser.status===2">답변 횟수 : {{ responseNum }} </h4>
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
import {computed, onMounted } from "vue";
import { useLoginStore } from "@/stores/login";
import { useCounselStore } from "@/stores/counsel";

const loginStore = useLoginStore();
const counselStore = useCounselStore();

onMounted(() => {
  counselStore.getCounselList();
});

const requestNum = computed(() => {
  return counselStore.counselList.filter(counsel => counsel.menteeId === loginStore.loginUser.id).length;
});

const responseNum = computed(() => {
  return counselStore.counselList.filter(counsel => counsel.mentorId === loginStore.loginUser.id).length;
});



</script>

<style scoped>
.content {
  background-color: rgb(255, 254, 214);
  margin: 20px;
  height: 500px;
}
</style>

<template>
  <div>
    <h1>마이페이지 홈</h1>
    <div class="content">
      <br>
      <div class="box">
        <h3>환영합니다, {{ loginStore.loginUser.nickname }}님</h3>
        <br>
        <h4>활동 요약</h4>
        <h5>질문 횟수 : {{ requestNum }}</h5>
        <h5 v-if="loginStore.loginUser.status===2">답변 횟수 : {{ responseNum }} </h5>
        <h5>가입일 : {{ loginStore.loginUser.createTime }}</h5>
        
      </div>
      <br>
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
.box {
  margin: 2%;
  padding: 3%;
  background-color: white;
  text-align: left;
}
.content {
  background-color: rgb(255, 254, 214);
  margin: 2%;
}
</style>

<template>
  <div>
    <h2>제목 : {{ store.counsel.title }}</h2>
    <span>멘티 : {{ store.counsel.menteeId }}&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
    <span>멘토 : {{ store.counsel.mentorId }}</span>
    <p>질문 내용 : {{ store.counsel.content }}</p>
    
    <h4>현재 수락 대기 중 입니다...</h4>
    <button @click="cancel" class="cancel">질문 취소</button>
    <h5 style="text-align: right; vertical-align: top;">id : {{ store.counsel.id }}</h5>
  </div>
</template>

<script setup>
import { useRoute } from "vue-router";
import { useCounselStore } from "@/stores/counsel";
import { onMounted, ref } from "vue";

const store = useCounselStore();
const route = useRoute();

const cancel = () => {
  store.counsel.status = 7;
  store.updateStatusCounsel();
  alert('상담이 취소되었습니다.');
  window.close();
  window.opener.location.reload();
}

onMounted(() => {
  store.getCounsel(route.params.id);
});
</script>

<style scoped>
button {
  color: rgb(236, 236, 236);
  cursor: pointer;
  margin: 10px;
}

button:hover {
  background-color: rgb(173, 173, 173); /* 마우스를 올렸을 때의 배경색 */
  color: rgb(146, 146, 146);
}

.cancel {
  width: 20%;
  background-color: rgb(163, 163, 163);
}
</style>

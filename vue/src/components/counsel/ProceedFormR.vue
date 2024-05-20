<template>
  <h1>{{ store.counsel.id }}번 답변 작성해주세요</h1>
  <div class="context">
    <p>멘티: {{ store.counsel.menteeId }}</p>
    <p>멘토: {{ store.counsel.mentorId }}</p>
    <p>제목: {{ store.counsel.title }}</p>
    <p>질문 내용: {{ store.counsel.content }}</p>
    <input type="text" placeholder="답변 작성해주세요" v-model="store.counsel.answerContent"/>
    <button class="send" @click="answer">제출</button>
  </div>
</template>

<script setup>
import { useRoute } from "vue-router";
import { useCounselStore } from "@/stores/counsel";
import { onMounted, ref } from "vue";

const store = useCounselStore();
const route = useRoute();

onMounted(() => {
  store.getCounsel(route.params.id);
});

const answer = () => {
  store.answerCounsel();
  alert('수락이 완료되었습니다');
  window.close();
  window.opener.location.reload();
}
</script>

<style scoped>
.send {
  width: 20%;
  background-color: orange;
}

button {
  cursor: pointer;
  margin: 10px;
}

button:hover {
  background-color: rgb(173, 173, 173); /* 마우스를 올렸을 때의 배경색 */
  color: rgb(146, 146, 146);
}
</style>

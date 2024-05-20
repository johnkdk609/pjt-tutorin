<template>
  <div>
    <h2>{{ store.counsel.id }}번 대기중인질문(mentor)</h2>

    <p>멘티: {{ store.counsel.menteeId }}</p>
    <p>멘토: {{ store.counsel.mentorId }}</p>
    <p>제목: {{ store.counsel.title }}</p>
    <p>질문 내용: {{ store.counsel.content }}</p>
    <button class="accept" @click="accept">승낙</button>
    <button class="reject" @click="reject">거절</button>
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

const accept = () => {
  store.acceptCounsel();
  alert('수락이 완료되었습니다');
  window.close();
  window.opener.location.reload();
}

const reject = () => {
  store.rejectCounsel();
  alert('거절이 완료되었습니다');
  window.close();
  window.opener.location.reload();
}
</script>

<style scoped>
.accept {
  width: 20%;
  background-color: yellowgreen;
}

.reject {
  width: 20%;
  background-color: red;
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

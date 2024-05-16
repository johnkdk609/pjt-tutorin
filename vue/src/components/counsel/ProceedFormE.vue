<template>
  <h1>{{ store.counsel.id }}번 답변 작성 중입니다..</h1>
  <div class="context">
    <p>멘티: {{ store.counsel.menteeId }}</p>
    <p>멘토: {{ store.counsel.mentorId }}</p>
    <p>제목: {{ store.counsel.title }}</p>
    <p>질문 내용: {{ store.counsel.content }}</p>
  </div>
</template>

<script setup>
import { useRoute } from 'vue-router'
import { useCounselStore } from "@/stores/counsel";
import { onMounted, ref } from "vue";

const store = useCounselStore();
const route = useRoute();

onMounted(() => {
    store.getCounsel(route.params.id)
})
</script>

<style scoped>
</style>

<template>
  <div>
    <h2>{{ store.counsel.id }}번 대기중인질문(mentor)</h2>

    <p>멘티: {{ store.counsel.menteeId }}</p>
    <p>멘토: {{ store.counsel.mentorId }}</p>
    <p>제목: {{ store.counsel.title }}</p>
    <p>질문 내용: {{ store.counsel.content }}</p>
    <div class="accept">승낙</div>
    <div class="reject">거절</div>
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
</style>

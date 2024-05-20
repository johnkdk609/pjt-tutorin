<template>
    <div>
        <h2>추가질문(mentee)</h2>
        <h4>상담 제목: {{ store.counsel.title }}</h4>
        <p v-if="store.counsel.question1">질문1: {{ store.counsel.question1 }}</p>
        <p v-if="store.counsel.answer1">답변1: {{ store.counsel.answer1 }}</p>
        <p v-if="store.counsel.question2">질문2: {{ store.counsel.question2 }}</p>
        <p v-if="store.counsel.answer2">답변2: {{ store.counsel.answer2 }}</p>
        <p v-if="store.counsel.question3">질문3: {{ store.counsel.question3 }}</p>
        <p v-if="store.counsel.answer3">답변3: {{ store.counsel.answer3 }}</p>
        <input v-if="store.counsel.status === 4" type="text" placeholder="답변을 등록해주세요" v-model="input" />
        <button v-if="store.counsel.status === 4" @click="submitAnswer">답변 등록</button>
    </div>
</template>

<script setup>
import { useRoute } from 'vue-router';
import { useCounselStore } from '@/stores/counsel';
import { onMounted, ref } from 'vue';

const store = useCounselStore();
const route = useRoute();
const input = ref('');

onMounted(() => {
    store.getCounsel(route.params.id);
});

const submitAnswer = async () => {
    if (!store.counsel.answer1) {
        store.counsel.answer1 = input.value;
    } else if (!store.counsel.answer2) {
        store.counsel.answer2 = input.value;
    } else if (!store.counsel.answer3) {
        store.counsel.answer3 = input.value;
    } else {
        alert('모든 답변을 작성하셨습니다');
        return;
    }

    // 답변 등록 후 상태 업데이트
    await store.feedbackACounsel({
        answer1: store.counsel.answer1,
        answer2: store.counsel.answer2,
        answer3: store.counsel.answer3,
        id: store.counsel.id
    });

    if (store.counsel.answer3) {
        store.counsel.status = 5;
    } else {
        store.counsel.status = 3;
    }

    alert('답변이 등록되었습니다');
    input.value = ''; // 입력 필드 초기화
    location.reload(); // 페이지 새로고침
    window.opener.opener.location.reload();
};
</script>

<style scoped></style>

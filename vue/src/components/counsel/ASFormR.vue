<template>
    <div>
        <h4>추가질문</h4>
        <h5>상담 제목: {{ store.counsel.title }}</h5>

        <div class="center">
            <div class="chatbox">
                <div v-if="store.counsel.question1 || store.counsel.answer1" class="chat">
                    <p v-if="store.counsel.question1" class="question">{{ store.counsel.question1 }}</p>
                    <p v-if="store.counsel.answer1" class="answer">{{ store.counsel.answer1 }}</p>
                </div>
                <div v-if="store.counsel.question2 || store.counsel.answer2" class="chat">
                    <p v-if="store.counsel.question2" class="question">{{ store.counsel.question2 }}</p>
                    <p v-if="store.counsel.answer2" class="answer">{{ store.counsel.answer2 }}</p>
                </div>
                <div v-if="store.counsel.question3 || store.counsel.answer3" class="chat">
                    <p v-if="store.counsel.question3" class="question">{{ store.counsel.question3 }}</p>
                    <p v-if="store.counsel.answer3" class="answer">{{ store.counsel.answer3 }}</p>
                </div>
                <div v-if="store.counsel.status === 4" class="input-group mt-3">
                    <input type="text" placeholder="질문을 등록해주세요" v-model="input" class="form-control" />
                    <div class="input-group-append">
                        <button class="btn btn-primary" @click="submitAnswer">질문 등록</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="text-right mt-2" style="color: rgb(212, 212, 212);">
            counsel id : {{ store.counsel.id }}
        </div>
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

<style scoped>
.center {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
}

.chatbox {
    width: 80%;
    max-width: 600px;
    margin: 0 auto;
}

.answer {
    text-align: right;
    background-color: #ffe600;
    padding: 10px;
    border-radius: 10px;
    margin: 5px 0;
}

.question {
    text-align: left;
    background-color: #f0f0f0;
    padding: 10px;
    border-radius: 10px;
    margin: 5px 0;
}

.input-group {
    display: flex;
}

.input-group-append {
    margin-left: 5px;
}
</style>

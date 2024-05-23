<template>
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
            <div v-if="store.counsel.status === 3" class="input-group mt-3">
                <input type="text" placeholder="질문을 등록해주세요" v-model="input" class="form-control" />
                <div class="input-group-append">
                    <button class="btn btn-primary" @click="submitQuestion">질문 등록</button>
                </div>
            </div>
        </div>
    </div>
    <div class="text-right mt-2" style="color: rgb(212, 212, 212);">
        counsel id : {{ store.counsel.id }}
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

const submitQuestion = () => {
    if (!store.counsel.question1) {
        store.counsel.question1 = input.value;
    } else if (!store.counsel.question2) {
        store.counsel.question2 = input.value;
    } else if (!store.counsel.question3) {
        store.counsel.question3 = input.value;
    } else {
        alert('모든 질문이 이미 등록되었습니다');
        return;
    }
    store.feedbackQCounsel(); // 질문을 저장하는 메서드 호출
    alert('질문이 등록되었습니다');
    input.value = ''; // 입력 필드 초기화
    location.reload(true);
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

.question {
    text-align: right;
    background-color: #ffe600;
    padding: 10px;
    border-radius: 10px;
    margin: 5px 0;
}

.answer {
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

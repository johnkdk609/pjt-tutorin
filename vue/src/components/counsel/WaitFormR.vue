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
  store.counsel.status = 6;
  store.updateStatusCounsel();
  alert('거절이 완료되었습니다');
  window.close();
  window.opener.location.reload();
}
</script>

<style scoped>
.bg-gray {
  background-color: rgb(206, 206, 206);
  color: rgb(80, 80, 80);
  text-align: center;
}

button {
  cursor: pointer;
  margin: 10px;
  width: 20%;
}

td {
  padding: 5px;
  width: 10%;
}
</style>

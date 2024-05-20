<template>
  <h1>{{store.counsel.id}}번 상담완료 내용</h1>
  <div class="context">
    <p>멘티: {{ store.counsel.menteeId }}</p>
    <p>멘토: {{ store.counsel.mentorId }}</p>
    <p>제목: {{ store.counsel.title }}</p>
    <p>질문 내용: {{ store.counsel.content }}</p>
    <p>답변 내용: {{ store.counsel.answerContent }}</p>

    <div class="modal" ref="modal" @click="closeModalOutside">
      <div class="modal_body" @click.stop>
        <p>별점: {{ store.counsel.reviewStar }}</p>
        <p>내용: {{ store.counsel.reviewcontent }}</p>
        <button @click="closeModal()">닫기</button>
      </div>
    </div>
    <button class="btn-open-modal" @click="openModal">리뷰 보기</button>
    <br />
    <button class="btn-open-modal" @click="open(store.counsel.id)">추가 답변 하기</button>
  </div>
</template>

<script setup>import { useRoute } from 'vue-router'
import { useCounselStore } from "@/stores/counsel";
import { onMounted, ref } from "vue";

const store = useCounselStore();
const route = useRoute();

onMounted(() => {
    store.getCounsel(route.params.id)
})

// 새 창 열기
const open = function (id) {
  const URL = "http://localhost:5173/out/counsel/as/r/" + id;
  window.open(URL, "_blank", "width=1000, height=700");
};


// 모달 부분
const modal = ref(null);

const openModal = () => {
  modal.value.style.display = "flex";
};

const closeModal = () => {
  modal.value.style.display = "none";
};

const closeModalOutside = (event) => {
  if (event.target === modal.value) {
    closeModal();
  }
};
</script>

<style scoped>
.btn-open-modal {
  width: 20%;
  background-color: rgb(255, 199, 96);
}

.context {
  background-color: white;
  height: 300px;
  display: flex;
  flex-direction: column;
  text-align: center;
}

.modal {
  display: none;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5); /* 반투명한 배경 */
  justify-content: center;
  align-items: center;
}

.modal_body {
  background-color: white;
  padding: 20px;
}
</style>

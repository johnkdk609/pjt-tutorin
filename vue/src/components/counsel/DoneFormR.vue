<template>
  <h1>1번상담완료 내용</h1>
  <div class="context">
    <p>질문답변어쩌고 들어갈 곳</p>

    <div class="modal" ref="modal" @click="closeModalOutside">
      <div class="modal_body" @click.stop>
        <h2>어떠셨나요?</h2>
        <p>글내용</p>
        <button @click="closeModal()">닫기</button>
      </div>
    </div>
    <button class="btn-open-modal" @click="openModal">리뷰 보기</button>
    <br />
    <button class="btn-open-modal" @click="open">추가 답변 하기</button>
  </div>
</template>

<script setup>
import { ref } from "vue";

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

const open = function () {
  window.open(
    "http://localhost:5173/counsel/as/r",
    "_blank",
    "width=1000, height=700"
  );
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

<template>

  <div class="container mt-4">
    <div class="card">
      <div class="card-header">
        상담 상태 : {{ store.counselStatus[store.counsel.status - 1] }}
      </div>
      <div class="card-body">
        <table class="table table-bordered table-custom">
          <tr>
            <td class="bg-gray">제목</td>
            <td colspan="3">{{ store.counsel.title }}</td>
          </tr>
          <tr>
            <td class="bg-gray">멘티(작성자)</td>
            <td>{{ store.counsel.menteeId }}</td>
            <td class="bg-gray">멘토</td>
            <td>{{ store.counsel.mentorId }}</td>
          </tr>
          <tr style="height: 200px;">
            <td class="bg-gray">질문 내용</td>
            <td colspan="3">{{ store.counsel.content }}</td>
          </tr>
          <tr style="height: 200px;">
            <td class="bg-gray">답변 내용</td>
            <td colspan="3">{{ store.counsel.answerContent }}</td>
          </tr>
        </table>
        <div class="text-right">
          <div class="modal" ref="modal" @click="closeModalOutside">
            <div class="modal_body" @click.stop>
              <table class="table table-bordered">
                <tr>
                  <td class="bg-gray">별점</td>
                  <td v-if="store.counsel.reviewStar > 0"><span>{{ store.counsel.reviewStar }}</span></td>
                </tr>
                <tr>
                  <td class="bg-gray">내용</td>
                  <td>{{ store.counsel.reviewContent }}</td>
                </tr>
              </table>
              <button class="btn btn-secondary" @click="closeModal()" style="width: 200px;">닫기</button>
            </div>
          </div>
          <p></p>
          <button class="btn-open-modal btn btn-warning" @click="openModal">리뷰 보기</button>
          <p></p>
          <button class="btn-open-modal btn btn-warning" @click="open(store.counsel.id)">추가 답변 하기</button>
        </div>
      </div>
    </div>
    <div class="text-right mt-2" style="color: rgb(212, 212, 212);">
      counsel id : {{ store.counsel.id }}
    </div>
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
  window.open(URL, "_blank", "width=700, height=700");
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
.modal {
  display: none;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  /* 반투명한 배경 */
  justify-content: center;
  align-items: center;
}

.modal_body {
  background-color: white;
  padding: 20px;
}

.bg-gray {
  background-color: rgb(206, 206, 206);
  color: rgb(80, 80, 80);
  text-align: center;
}

button {
  cursor: pointer;
  margin: 10px;
  width: 30%;
}

td {
  padding: 5px;
  width: 10%;
}
</style>

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
          <!-- modal -->
          <div class="modal" ref="modal" @click="closeModalOutside">
            <div class="modal_body p-3" @click.stop>
              <table class="table table-bordered">
                <tr>
                  <td class="bg-gray">별점</td>
                  <td v-if="store.counsel.reviewStar>0">{{ store.counsel.reviewStar }}</td>
                </tr>
                <tr>
                  <td class="bg-gray">내용</td>
                  <td>{{ store.counsel.reviewContent }}</td>
                </tr>
                <tr>
                  <td class="bg-gray">별점 수정</td>
                  <td>
                    <select v-model="reviewInputStar" class="form-control">
                      <option value="1">1점</option>
                      <option value="2">2점</option>
                      <option value="3">3점</option>
                      <option value="4">4점</option>
                      <option value="5">5점</option>
                    </select>
                  </td>
                </tr>
                <tr>
                  <td class="bg-gray">내용 수정</td>
                  <td><input type="text" placeholder="내용" v-model="reviewInputContent" class="form-control" /></td>
                </tr>
              </table>
              <div class="text-right">
                <button class="btn btn-primary" @click="review">수정</button>
                <button class="btn btn-secondary" @click="closeModal()">닫기</button>
              </div>
            </div>
          </div>
          <button class="btn-open-modal btn btn-warning" @click="openModal"
            v-if="store.counsel.status !== 6 && store.counsel.status !== 7">리뷰 등록</button>
          <br />
          <button class="btn-open-modal btn btn-warning" @click="open(store.counsel.id)"
            v-if="store.counsel.status !== 6 && store.counsel.status !== 7">추가 질문 하기</button>
        </div>
      </div>
    </div>
    <div class="text-right mt-2" style="color: rgb(212, 212, 212);">
      counsel id : {{ store.counsel.id }}
    </div>
  </div>

</template>

<script setup>
import { useRoute } from 'vue-router'
import { useCounselStore } from "@/stores/counsel";
import { onMounted, ref } from "vue";

const store = useCounselStore();
const route = useRoute();
const reviewInputStar = ref();
const reviewInputContent = ref();

onMounted(() => {
  store.getCounsel(route.params.id)
})

const review = () => {
  store.counsel.reviewStar = reviewInputStar;
  store.counsel.reviewContent = reviewInputContent;
  store.reviewCounsel();
  alert('수정이 완료되었습니다');
  window.location.reload();
}

// 새 창 열기
const open = function (id) {
  const URL = "http://localhost:5173/out/counsel/as/e/" + id;
  window.open(URL, "_blank", "width=700, height=700");
};

//모달 부분
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

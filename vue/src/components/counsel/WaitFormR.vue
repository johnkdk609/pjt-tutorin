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
      </table>
      <div class="text-right">
        <button class="btn btn-success" @click="accept">수락</button>
        <button class="btn btn-danger" @click="reject">거절</button>
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

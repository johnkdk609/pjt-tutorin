<template>
  <div>
    <h1>상담 신청하기</h1>
    <div class="content">
      <h3>내용</h3>
      <p></p>
      <input type="text" placeholder="제목" v-model="store.counsel.title" />
      <p></p>
      <input type="text" placeholder="내용" v-model="store.counsel.content" />
      <p></p>
      <input type="text" placeholder="비디오(수정예정)" v-model="store.counsel.video" />
    </div>
    <p></p>
    <button  @click="send">
      <h3>결제 및 전송</h3>
    </button>
    <p></p>
    <button  onclick="history.back()">
      <h3>뒤로가기</h3>
    </button>
  </div>
</template>

<script setup>
import { useCounselStore } from "@/stores/counsel";
import { useLoginStore } from "@/stores/login";
import { useRouter, useRoute } from "vue-router";
const store = useCounselStore();
const loginStore = useLoginStore();
const router = useRouter();
const route = useRoute();

const send = () => {
  store.counsel.menteeId = loginStore.loginUser.id;
  store.counsel.mentorId = route.params.id;
  store.postCounsel(router); // 라우터 인스턴스를 전달하여 메서드 내에서 사용
};
</script>

<style scoped>
.content {
  background-color: aliceblue;
  text-align: center; /* 가운데 정렬 */
  padding: 20px;
}

button {
  border-radius: 20px; /* 둥근 버튼을 만들기 위해 픽셀 단위를 사용 */
  background-color: yellowgreen;
  color: white;
  text-align: center;
  cursor: pointer;
  padding: 10px 20px;
  width: 300px; /* 버튼의 너비를 내용에 맞추기 */
  margin-left: auto;
  margin-right: auto;
  display: block; /* 중앙 정렬을 위해 block 요소로 변경 */
}

button:hover {
  background-color: darkgreen; /* 마우스를 올렸을 때의 배경색 */
}
</style>

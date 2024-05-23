<template>
  <div>
    <h1>회원 가입</h1>
    <div class="content">
      <h3>내용</h3>
      <input type="text" placeholder="아이디" v-model="store.user.id" />
      <p></p>
      <input type="password" placeholder="비밀번호" v-model="store.user.password" />
      <p></p>
      <input type="mail" placeholder="이메일" v-model="store.user.email" />
      <p></p>
      <input type="text" placeholder="이름" v-model="store.user.name" />
      <p></p>
      <input type="text" placeholder="닉네임" v-model="store.user.nickname" />
      <p></p>
      <input type="text" placeholder="전화번호(-제외)" v-model="store.user.phoneNum" />
      <p></p>
    </div>
    <p></p>
    <div class="button" @click="send">
      <h3>회원 가입</h3>
    </div>
    <p></p>
    <div class="button" onclick="history.back()">
      <h3>뒤로가기</h3>
    </div>
    <br>
  </div>
</template>

<script setup>
import { useUserStore } from "@/stores/user";
import { useRouter } from "vue-router";
const store = useUserStore();
const router = useRouter();

const send = () => {
  store.postUser(router); // 라우터 인스턴스를 전달하여 메서드 내에서 사용
};
</script>

<style scoped>
.content {
  background-color: aliceblue;
  text-align: center; /* 가운데 정렬 */
  padding: 20px;
}

.button {
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

.button:hover {
  background-color: darkgreen; /* 마우스를 올렸을 때의 배경색 */
}
</style>

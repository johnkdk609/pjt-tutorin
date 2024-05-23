<template>
  <div>
    <div class="content">
      <img src="@/assets/main.jpg" alt="" style="width: 200px; margin: 30px; border-radius: 50%;" />
      <h1>Mentor {{ mentorStore.mentor.id }}</h1>
      <h5>자기소개 : {{ mentorStore.mentor.mentorIntro }}</h5>
    </div>
    <button @click="toWrite">
      <h3>상담 신청하기</h3>
    </button>
    <br>
  </div>
</template>

<script setup>
import {useRoute, useRouter} from "vue-router";
import {useUserStore} from "@/stores/user";
import {useMentorStore} from "@/stores/mentor";
import { useLoginStore } from "@/stores/login";

const userStore = useUserStore();
const mentorStore = useMentorStore();
const loginStore = useLoginStore();
const route = useRoute();
const router = useRouter();

userStore.getUser(route.params.id);
mentorStore.getMentor(route.params.id);


const toWrite = () => {
  if(loginStore.loginUser.id){
    router.push({ name: 'writeform', params: route.params.id })

  } else{
    alert('로그인을 먼저 해 주세요.')
    router.push({ name: 'login'})
  }
}
</script>

<style scoped>
.content {
  background-color: aliceblue;
  text-align: center; /* 가운데 정렬 */
  height: 600px;
  margin: 30px;
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

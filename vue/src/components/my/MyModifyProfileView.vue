<template>
  <div>
    <h1>프로필 수정</h1>
    <div class="content">
      <div>
        <h3>멘티 프로필</h3>
        <textarea name="" id="" placeholder="멘티 자기소개를 입력해보세요." v-model="userStore.user.menteeIntro"></textarea>
      </div>
      <div v-if="loginStore.loginUser.status===2">
        <h3>멘토 프로필</h3>
        <textarea name="" id=""  placeholder="멘토 자기소개를 입력해보세요." v-model="mentorStore.mentor.mentorIntro"></textarea>
      </div>
      <button @click="modify">저장하기</button>
    </div>
  </div>

</template>

<script setup>
import {useRoute} from "vue-router";
import {onMounted, onUnmounted, ref} from "vue";
import {useLoginStore} from "@/stores/login";
import {useUserStore} from "@/stores/user";
import {useMentorStore} from "@/stores/mentor";

const userStore = useUserStore();
const loginStore = useLoginStore();
const mentorStore = useMentorStore();
const route = useRoute();

onMounted(() => {
  userStore.getUser(route.params.id);
  if (loginStore.loginUser.status === 2) {
    mentorStore.getMentor(route.params.id);
  }
});
onUnmounted(() => {
  userStore.user = {};
  if (loginStore.loginUser.status === 2) {
    mentorStore.mentor = {};
  }
});

const modify = () => {
  userStore.updateUser(loginStore.loginUser.id);
  mentorStore.updateMentor(loginStore.loginUser.id);
  alert('변경되었습니다.')
};
</script>

<style scoped>
.content {
  background-color: rgb(255, 254, 214);
  margin: 20px;
  padding: 30px;
}
textarea {
  width: 70%;
  height: 300px;
}

button {
  border-radius: 10px;
  background-color: rgb(83, 97, 219);
  color: white;
  text-align: center;
  cursor: pointer;
  padding: 10px 20px;
  width: 200px;
  /* 버튼의 너비를 부모 요소에 맞춤 */
  margin: 10px 0;
}

button:hover {
  background-color: rgb(55, 64, 146);
}
</style>

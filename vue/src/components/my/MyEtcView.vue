<template>
  <div>
    <h1>회원 탈퇴</h1>
    <div class="content">
        <h3>탈퇴약관</h3>
        <button @click="secession">정말로 탈퇴하시겠습니까?</button>
        <button @click="secession2">탈퇴하기</button>
    </div>
  </div>
</template>

<script setup>
import { useRoute, useRouter } from "vue-router";
import { ref, onMounted, onUnmounted } from "vue";
import { useLoginStore } from "@/stores/login";
import { useUserStore } from "@/stores/user";
import { useMentorStore } from "@/stores/mentor";
import { useCounselStore } from "@/stores/counsel";

const userStore = useUserStore();
const loginStore = useLoginStore();
const mentorStore = useMentorStore();
const counselStore = useCounselStore();
const route = useRoute();
const router = useRouter();

const secession = () => {
  const id = route.params.id;
  mentorStore.deleteMentor(id);
  counselStore.secessionCounsel(id);
};
const secession2 = () => {
  const id = route.params.id;
  userStore.deleteUser(id);
  loginStore.logout();
  router.push('/'); // Redirect to login after logout
  
};


</script>

<style scoped>
.content{
    background-color: rgb(255, 254, 214);
    margin: 20px;
    height:500px;
}</style>

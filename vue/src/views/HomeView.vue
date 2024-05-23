<template>
  <div class="videos">
    <div class="button" @click="mentor('johnKDK')" >
      <iframe
        width="420"
        height="250"
        src="https://www.youtube.com/embed/H-AcDBLqxi4?si=ZcXWHGL2U1kR02ot"
        title="YouTube video player"
        frameborder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
        referrerpolicy="strict-origin-when-cross-origin"
        allowfullscreen></iframe>
      <h5>Mentor johnKDK</h5>
    </div>
    <div class="button" @click="mentor('jane')">
      <iframe
        width="420"
        height="250"
        src="https://www.youtube.com/embed/0iqP6WP2ET4?si=-x6_wUSWf7kEkO1f"
        title="YouTube video player"
        frameborder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
        referrerpolicy="strict-origin-when-cross-origin"
        allowfullscreen></iframe>
      <h5>Mentor jane</h5>
    </div>
    <div class="button" @click="mentor('john')">
      <iframe
        width="420"
        height="250"
        src="https://www.youtube.com/embed/hQiuOOuu46o?si=wWhrCfuGY1d8TJWR"
        title="YouTube video player"
        frameborder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
        referrerpolicy="strict-origin-when-cross-origin"
        allowfullscreen></iframe>
      <h5>Mentor john</h5>
    </div>
    <div class="button" @click="mentor('mckim')">
      <iframe
        width="420"
        height="250"
        src="https://www.youtube.com/embed/h_9ZZvH4s6c?si=0PgosJAOf6B50BCv"
        title="YouTube video player"
        frameborder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
        referrerpolicy="strict-origin-when-cross-origin"
        allowfullscreen></iframe>
      <h5>Mentor mckim</h5>
    </div>
  </div>

  <div class="container">
    <div class="gpt fixed-top">
      <ChatgptView />
    </div>
  </div>
</template>

<script setup>
import ChatgptView from "@/views/ChatgptView.vue";
import { useRouter } from "vue-router";
import {ref} from 'vue';
const selectedMentor = ref('');

const router = useRouter();
const mentor = (mentorId) => {
  selectedMentor.value = mentorId;
  alert(selectedMentor.value);
  router.push({ name: 'mentor_profile', params: { id: selectedMentor.value } });
};
</script>

<style scoped>
.button {
  padding: 20px;
  text-align: center;
  cursor: pointer;
}

.button:hover {
  background-color: darkgreen; /* 마우스를 올렸을 때의 배경색 */
  color: white;
  background-color: gray;
}

.container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 70%; /* Full viewport height to center vertically */
}

.fixed-top {
  position: fixed;
  top: 450px;
  width: 100%;
  z-index: 999;
}

.gpt {
  text-align: center;
  color: white;
  background-color: black;
  height: 388px;
  overflow-y: auto;
}

.videos {
  display: flex;
  iframe {
    margin-left: 10px;
    margin-right: 10px;
  }
}
</style>

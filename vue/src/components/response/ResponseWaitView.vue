<template>
  <div>
    <h3>승낙 해주세요.</h3>
    <div
      class="button"
      @click="open(counsel.id)"
      v-for="counsel in completedCounselList"
      :key="counsel.id"
    >
      <h4>{{ counsel.id }}번 상담</h4>
      <h5>{{ counsel.title }}</h5>
      <h5>상태: {{ counsel.status }}</h5>
    </div>
  </div>
</template>

<script setup>
import { useCounselStore } from "@/stores/counsel";
import { onMounted, computed } from "vue";

const open = function (id) {
  window.open(
    "http://localhost:5173/out/counsel/wait/r/" + id,
    "_blank",
    "width=1000, height=700"
  );
};

const store = useCounselStore();

onMounted(() => {
  store.getCounselList();
});

const completedCounselList = computed(() => {
  return store.counselList.filter((counsel) => counsel.status === 1);
});
</script>

<style scoped>
.button {
  background-color: white;
  color: black;
  border: 1px solid rgb(228, 228, 228); /* 검은색 테두리 추가 */
  text-align: center;
  cursor: pointer;
  margin: 10px;
}

.button:hover {
  background-color: rgb(173, 173, 173); /* 마우스를 올렸을 때의 배경색 */
  color: rgb(146, 146, 146);
}
</style>

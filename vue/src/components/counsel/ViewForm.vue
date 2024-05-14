<template>
  <div class="context">
    <h1>1번상담완료 내용</h1>
    <div
      class="button"
      onclick="location.href='http://localhost:5173/my/request/counsel/view';"
    >
      <h5>별점</h5>
    </div>
    <div
      class="button"
      onclick="location.href='http://localhost:5173/my/request/counsel/view';"
    >
      <h5>AS</h5>
    </div>
  </div>
</template>

<script setup></script>

<style scoped>
.context {
  background-color: white;
  height: 300px;
  display: flex;
  flex-direction: column; /* 버튼을 세로로 배치 */
}


.button {
  background-color: white;
  color: black;
  border: 1px solid rgb(228, 228, 228);
  cursor: pointer;
  padding: 10px 20px;
  width: 5%;
  height: 100px;
  margin-top: 10px; /* 버튼 간의 간격을 조정 */
}

.button:hover {
  background-color: rgb(173, 173, 173);
  color: rgb(146, 146, 146);
}
</style>

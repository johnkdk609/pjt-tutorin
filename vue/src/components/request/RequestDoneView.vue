<template>
  <div>
    <h3>상담 완료 내역입니다</h3>
    <div
      class="button"
      onclick="location.href='http://localhost:5173/my/request/counsel/view';"
    >
      <h3>1번 상담</h3>
    </div>
  </div>
  <RouterView/>
</template>

<script setup></script>

<style scoped>
.button {
  background-color: white;
  color: black;
  border: 1px solid rgb(228, 228, 228); /* 검은색 테두리 추가 */
  text-align: center;
  cursor: pointer;
  padding: 10px 20px;
  width: 80%;
  margin-left: auto;
  margin-right: auto;
}

.button:hover {
  background-color: rgb(173, 173, 173); /* 마우스를 올렸을 때의 배경색 */
  color: rgb(146, 146, 146);
}
</style>

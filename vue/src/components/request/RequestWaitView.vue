<template>
  <div>
    <h3>승낙 대기 중..</h3>
    <div class="button">
      <h3>1번 상담</h3>
    </div>
  </div>
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

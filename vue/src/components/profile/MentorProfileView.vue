<template>
  <div>
    <h1>mentor프로필</h1>
    <div class="content">내용</div>
    <div class="button" onclick="location.href='http://localhost:5173/counsel/write';">
      <h3>상담 신청하기</h3>
    </div>
  </div>
</template>

<script setup></script>

<style scoped>
.content {
  background-color: aliceblue;
  text-align: center; /* 가운데 정렬 */
  height: 500px;
}

.button {
  background-color: yellowgreen;
  color: white;
  text-align: center;
  cursor: pointer;
  padding: 10px 20px;
  width: 30%;
  margin-left: auto;
  margin-right: auto;
}

.button:hover {
  background-color: darkgreen; /* 마우스를 올렸을 때의 배경색 */
}
</style>

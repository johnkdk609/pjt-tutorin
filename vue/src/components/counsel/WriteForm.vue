<template>
  <div>
    <h1>폼 작성하기</h1>
    <div class="content">내용</div>
    <div
      class="button"
      onclick="location.href='http://localhost:5173/my/request';"
      @click="send"
    >
      <h3>결제 및 전송</h3>
    </div>

    <div class="button" onclick="history.back()">
      <h3>뒤로가기</h3>
    </div>
  </div>
</template>

<script setup>
const send = function () {
  alert("결제가 완료되었습니다 (상담 신청 내역으로 이동)");
};
</script>

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

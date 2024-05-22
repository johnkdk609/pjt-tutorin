<template>
  <div>
    <h1>mentor프로필</h1>
    <div class="content">내용</div>
    <button onclick="location.href='http://localhost:5173/counsel/write';">
      <h3>상담 신청하기</h3>
    </button>
  </div>
</template>

<script setup></script>

<style scoped>
.content {
  background-color: aliceblue;
  text-align: center; /* 가운데 정렬 */
  height: 500px;
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

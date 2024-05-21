<template>
  <div>
    <header>
      <span class="header-text">Tutorin</span>
    </header>
  </div>
</template>

<script setup></script>

<style scoped>
header {
  /* background-color: aliceblue; */
  height: 100px;
  position: relative; /* 부모 요소를 기준으로 내부 요소를 위치시키기 위해 */
}

.header-text {
  position: absolute;
  bottom: 0;
  margin-bottom: 0;
  font-size: 50px; /* 텍스트 크기를 크게 설정 */
  font-weight: bold; /* 텍스트를 굵게 설정 */
  text-align: left;
}
</style>

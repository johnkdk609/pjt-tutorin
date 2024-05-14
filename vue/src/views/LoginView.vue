<template>
  <h1>로그인창입니다.</h1>
  <div class="container">
    <div class="formbox">
      <form>
        <h2>Tutorin</h2>
        <input type="text" placeholder="id">
        <br>
        <input type="text" placeholder="password">
        <br>
        <input type="checkbox" value="save"><label>아이디 저장</label> <!-- 여기서 h를 label로 수정 -->
        <br>
        <button>로그인</button>
        <br>
        <RouterLink to="/regist">회원가입</RouterLink>
      </form>
    </div>
  </div>
</template>

<style scoped>
.container {
  
  display: flex;
  justify-content: center; /* 수평 가운데 정렬 */
  align-items: center; /* 수직 가운데 정렬 */
}

.formbox {
  height: 600px;
  width:  400px;
  background-color: aliceblue;
  text-align: center;
}
</style>

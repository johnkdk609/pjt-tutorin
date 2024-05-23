<template>
    <p></p>
  <footer>
    <div class="footer">
      <div class="footer-item">
        <h5>이용약관 | 개인정보처리방침</h5>
      </div>
      <div class="footer-item">
        <div class="items">
          <h5>CONTACT | </h5>  
          <span>
            &nbsp;&nbsp;dkkim@ssafy.com<br>
            &nbsp;&nbsp;mckim@ssafy.com
          </span>
        </div>
      </div>
    </div>
  </footer>
</template>

<script setup></script>

<style scoped>
footer {
  position: fixed;
  bottom: 0;
  left: 0;
  width: 100%;
}

.footer {
  bottom: 0;
  left: 0;
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: rgba(57, 64, 75, 0.5);
  height: 70px;
}

.footer-item {
  flex: 1;
  text-align: center;
  padding: 0 20px;
}

.items {
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>

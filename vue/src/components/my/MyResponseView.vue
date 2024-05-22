<template>
  <div>
    <h1>상담 수령 내역</h1>

    <div class="btn-group custom-btn-group">
      <RouterLink
        :to="{ name: 'reswait' }"
        class="btn"
        active-class="active"
        exact-active-class="active"
        >대기</RouterLink
      >
      <RouterLink
        :to="{ name: 'resproceed' }"
        class="btn"
        active-class="active"
        exact-active-class="active"
        >진행</RouterLink
      >
      <RouterLink
        :to="{ name: 'resdone' }"
        class="btn"
        active-class="active"
        exact-active-class="active"
        >지난</RouterLink
      >
    </div>

    <div class="content">
      <RouterView />
    </div>
  </div>
</template>

<script setup></script>

<style scoped>
.content {
  background-color: rgb(255, 254, 214);
  margin-left: 20px;
  margin-right: 20px;
  margin-bottom: 20px;
  padding: 20px;
}

.custom-btn-group {
  margin-left: 20px;
  margin-right: 20px;
  display: flex;
  justify-content: flex-start; /* Align buttons to the left */
}

.custom-btn-group .btn {
  background-color: #d6be6d;
  border-color: #d6be6d;
  border-bottom-left-radius: 0;
  border-bottom-right-radius: 0;
  margin: 0;
  transition: background-color 0.3s;
  text-decoration: none;
  color: black; /* Ensure text color is black */
  padding: 10px 20px; /* Add padding to make buttons larger */
}

.custom-btn-group .btn.active {
  background-color: rgb(255, 254, 214);
  border-color: rgb(255, 254, 214);
}

.custom-btn-group .btn + .btn {
  margin-left: -1px; /* Remove the gap between buttons */
}

a {
  color: black;
  text-decoration: none;
  font-size: 20px;
  font-weight: bold;
}
</style>

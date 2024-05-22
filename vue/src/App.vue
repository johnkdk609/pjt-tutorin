<script setup>
import { useLoginStore } from './stores/login';
const loginStore = useLoginStore();
const logout = ()=>{
  loginStore.logout();
}
</script>

<template>
  <RouterView />
</template>



<style scoped></style>

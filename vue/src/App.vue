<script setup>
import { useLoginStore } from './stores/login';
const loginStore = useLoginStore();
const logout = ()=>{
  loginStore.logout();
}
</script>

<template>
    <RouterLink to="/">Home</RouterLink> | 
    <RouterLink v-if="loginStore.accessToken === ''" to="/login">Login</RouterLink>
    <button v-else @click="logout">Logout</button>
    | 
    
    <RouterLink to="/private">Private</RouterLink>


  <RouterView />
</template>



<style scoped></style>

<template>
    <div v-if="store.messages.length > 0">
      <ul>
        <li v-for="message in store.messages" :key="message.id">
          {{ message.text }}
        </li>
      </ul>
    </div>
    <div v-else>
      <p>No response yet.</p>
    </div>
  </template>
  
  <script setup>
  import { useChatgptStore } from '@/stores/chatgpt';
  
  const store = useChatgptStore();
  </script>
  
  <style scoped>

  </style>
  
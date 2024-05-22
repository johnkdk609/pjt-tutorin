<template>
    <div>
        <input type="text" class="search-input" v-model="keyword" placeholder=" 한국어, 300자 이내로 답변해드립니다." />
        <button @click="search">검색</button>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import { useChatgptStore } from '@/stores/chatgpt'

const store = useChatgptStore();

const keyword = ref('');

const search = function () {
    store.chatgptSearch(keyword.value);
    keyword.value = '';
}

</script>

<style scoped>
.search-input {
  width: 400px; /* This will make it take the full width of its container */
  max-width: 600px;
}
</style>
<template>
    <div>
        <input type="text" v-model="keyword" placeholder="ChatGPT에 무엇이든 물어보세요." />
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

</style>
<template>
<div class="chatgpt-view" :key="refreshKey">
    <div class="header chatgpt-box">
    <h2>ChatGPT에 무엇이든 물어보세요.</h2>
    </div>
    <div class="content">
    <ChatgptSearch @refresh="refreshComponent" />
    <hr>
    <ChatgptDetail />
    </div>
</div>
</template>

<script setup>
import { ref } from 'vue';
import ChatgptSearch from '@/components/chatgpt/ChatgptSearch.vue';
import ChatgptDetail from '@/components/chatgpt/ChatgptDetail.vue';

const refreshKey = ref(0);

const refreshComponent = () => {
refreshKey.value++;
};
</script>

<style scoped>
.chatgpt-box {
margin-top: 20px;
}

.chatgpt-view {
flex: 1;
display: flex;
flex-direction: column;
}

.content {
flex: 1;
display: flex;
flex-direction: column;
}
</style>

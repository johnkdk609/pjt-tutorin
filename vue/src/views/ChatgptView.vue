<template>
    <div class="chatgpt-view">
        <div class="header">
            <h2>ChatGPT에 무엇이든 물어보세요.</h2>
        </div>
        <div class="content">
            <ChatgptSearch />
            <hr>
            <ChatgptDetail />
        </div>
    </div>
</template>

<script setup>
import ChatgptSearch from '@/components/chatgpt/ChatgptSearch.vue'
import ChatgptDetail from '@/components/chatgpt/ChatgptDetail.vue'
</script>

<style scoped>

</style>
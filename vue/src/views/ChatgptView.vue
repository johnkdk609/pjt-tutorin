<template>
    <div>
        <h2>ChatGPTView</h2>
        <div>
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
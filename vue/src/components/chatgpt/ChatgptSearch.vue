<template>
    <div>
        <input type="text" class="search-input" v-model="keyword" placeholder=" 300자 이내의 한국어로 답변해드립니다." />
        <img  
            @click="search" 
            src="@/assets/ChatGPT-Icon-Logo-PNG.png" 
            alt="ChatGPT Logo" 
            class="search-image"
        >
        <img  
            @click="pagerefresh" 
            src="@/assets/pngegg.png" 
            alt="refresh button" 
            class="refresh-image"
        >


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

const pagerefresh = function () {
    location.reload();
}

</script>

<style scoped>
.search-input {
  width: 400px; /* This will make it take the full width of its container */
  max-width: 600px;
  margin-top: 20px;
}

.search-image {
    width: 30px;
    margin-bottom: 4px;
    margin-left: 5px;
    cursor: pointer; 
}

.refresh-image {
    width: 25px;
    margin-left: 10px;
    cursor: pointer; 
}
</style>
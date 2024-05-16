<template>
    <div>
        <h2>추가질문(mentee)</h2>
        <p>질문1: {{ store.counsel.question1 }}</p>
        <p>제목: {{ store.counsel.title }}</p>
    </div>
</template>

<script setup>
import { useRoute } from 'vue-router'
import { useCounselStore } from "@/stores/counsel";
import { onMounted } from "vue";

const store = useCounselStore();
const route = useRoute();

onMounted(() => {
    store.getCounsel(route.params.id)
})

</script>

<style  scoped>

</style>
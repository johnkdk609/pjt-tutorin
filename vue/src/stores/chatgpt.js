import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

export const useChatgptStore = defineStore('chatgpt', () => {
  const messages = ref([])

  const chatgptSearch = async function(keyword){
    const URL = 'https://api.openai.com/v1/engines/davinci-codex/completions'  // 수정 필요
    const API_KEY = import.meta.env.VITE_CHATGPT_API_KEY

    try {
      const response = await axios({
        url: URL,
        method: 'POST',
        headers: {
          'Authorization': `Bearer ${API_KEY}`,
          'Content-Type': 'application/json'
        },
        data: {
          prompt: prompt,
          max_tokens: 150
        }
      })

      const botResponse = response.data.choices[0].text.trim()
      messages.value.push({ id: Date.now(), text: botResponse, sender: 'bot' })
    } catch (error) {
      console.error('Error communicating with ChatGPT API:', error)
      messages.value.push({ id: Date.now(), text: 'Sorry, something went wrong.', sender: 'bot' })
    }
  }

  const addMessage = function(text, sender) {
    messages.value.push({ id: Date.now(), text: text, sender: sender })
  }

  return { chatgptSearch, messages, addMessage }
})
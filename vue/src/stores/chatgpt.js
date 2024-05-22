import { ref } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

export const useChatgptStore = defineStore('chatgpt', () => {
  const messages = ref([])

  const chatgptSearch = async function(keyword) {
    const URL = 'https://api.openai.com/v1/chat/completions'
    const API_KEY = import.meta.env.VITE_CHATGPT_API_KEY

    // Additional prompt
    const additionalPrompt = 'Explain it in Korean in less than 300 tokens.'

    try {
      const response = await axios({
        url: URL,
        method: 'POST',
        headers: {
          'Authorization': `Bearer ${API_KEY}`,
          'Content-Type': 'application/json'
        },
        data: {
          model: 'gpt-3.5-turbo',
          messages: [
            { role: 'user', content: keyword },
            { role: 'assistant', content: additionalPrompt }
          ],
          max_tokens: 300
        }
      })

      // Log the response data for debugging
      console.log('Response data:', response.data)

      // Check if response data is valid
      if (response.data && response.data.choices && response.data.choices.length > 0) {
        // Inspect the structure of choices[0] object
        console.log('Choices[0]:', response.data.choices[0]);
        
        // Extract the generated text from the choices[0] object
        const botResponse = response.data.choices[0].message.content;
        messages.value.push({ id: Date.now(), text: botResponse, sender: 'bot' });
      } else {
        // Handle the case when the response does not contain the expected data
        console.error('Error: Unexpected response from ChatGPT API:', response.data)
        messages.value.push({ id: Date.now(), text: 'Sorry, something went wrong.', sender: 'bot' })
      }
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

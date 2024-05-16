import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

const REST_API = `http://localhost:8080/counsel`;

export const useCounselStore = defineStore("counsel", () => {


  const counselList = ref([]);
  const counsel = ref({});

  const getCounselList = function () {
    axios
      .get(REST_API)
      .then((res) => {
        counselList.value = res.data;
      })
      .catch((e) => {});
  };

  const getCounsel = function (id) {
    axios
      .get(`${REST_API}/${id}`)
      .then((res) => {
        counsel.value = res.data;
      })
      .catch((e) => {});
  };

  return { counselList, getCounselList, counsel, getCounsel };
});

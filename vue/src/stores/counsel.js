import {ref, computed} from "vue";
import {defineStore} from "pinia";
import axios from "axios";

const REST_API = `http://localhost:8080/counsel`;

export const useCounselStore = defineStore("counsel", () => {
  const counselList = ref([]);
  const counsel = ref({});
  const counselStatus = ref([
    "대기중",
    "답변중",
    "질문가능",
    "답변필요",
    "완료",
    "거절됨",
    "취소됨",
  ]);

  const postCounsel = async (router) => {
    try {
      await axios.post(REST_API, counsel.value);
      alert("결제가 완료되었습니다 (상담 신청 내역으로 이동)");
      router.push({name: "reqwait"}); // 성공 시 리디렉션
    } catch (e) {
      alert("등록에 실패하였습니다" + e);
    }
  };

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

  const acceptCounsel = function () {
    axios.put(REST_API + "/accept", counsel.value).then(() => {});
  };

  const updateStatusCounsel = function () {
    axios.put(REST_API + "/updateStatus", counsel.value).then(() => {});
  };

  const answerCounsel = function () {
    axios.put(REST_API + "/answer", counsel.value).then(() => {});
  };

  const feedbackQCounsel = function () {
    axios.put(REST_API + "/fq", counsel.value).then(() => {});
  };

  const feedbackACounsel = function () {
    axios.put(REST_API + "/fa", counsel.value).then(() => {});
  };

  const reviewCounsel = function () {
    axios.put(REST_API + "/review", counsel.value).then(() => {});
  };

  const secessionCounsel = function (id) {
    console.log(id);
    axios
      .put(REST_API + "/secession/" + id, id)
      .then(() => {
        // console.log("상담탈퇴완료");
      })
      .catch((e) => {
        // alert("상담탈퇴 실패." + e);
      });
    axios
      .put(REST_API + "/secession2/" + id, id)
      .then(() => {
        // console.log("상담탈퇴완료2");
      })
      .catch((e) => {
        // alert("상담탈퇴 실패." + e);
      });
  };

  const getStatusClass = (status) => {
    if (status === 1 || status === 2 || status === 4) {
      return "orange";
    } else if (status === 3) {
      return "yellowGreen";
    } else if (status === 5 || status === 6 || status === 7) {
      return "gray";
    }
  };

  return {
    counselList,
    getCounselList,
    counsel,
    getCounsel,
    acceptCounsel,
    updateStatusCounsel,
    answerCounsel,
    feedbackQCounsel,
    feedbackACounsel,
    reviewCounsel,
    counselStatus,
    getStatusClass,
    postCounsel,
    secessionCounsel,
  };
});

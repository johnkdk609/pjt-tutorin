<template>
  <div>
    <div class="content">
      <div class="terms">
        <h1>회원 탈퇴 약관</h1>
        <div class="section">
          <h2>제1조 (목적)</h2>
          <p>
            본 약관은 회사(이하 "회사"라 한다)의 서비스(이하 "서비스"라 한다)
            이용과 관련하여, 회원의 탈퇴 절차 및 탈퇴 후 조치 사항 등을 규정함을
            목적으로 합니다.
          </p>
        </div>

        <div class="section">
          <h2>제2조 (회원 탈퇴 신청)</h2>
          <p>
            1. 회원은 언제든지 회사의 고객센터를 통해 탈퇴를 신청할 수
            있습니다.<br />
            2. 탈퇴 신청 시, 회원은 본인의 계정 정보를 제공하여 본인 확인 절차를
            거쳐야 합니다.
          </p>
        </div>

        <div class="section">
          <h2>제3조 (회원 탈퇴 처리)</h2>
          <p>
            1. 회사는 회원의 탈퇴 신청을 접수한 후, 7일 이내에 탈퇴 절차를
            완료합니다.<br />
            2. 회원 탈퇴가 완료되면, 회원의 모든 개인 정보는 즉시 삭제됩니다.
            다만, 관계 법령에 따라 보존할 필요가 있는 정보는 해당 법령에서 정한
            기간 동안 보관됩니다.
          </p>
        </div>

        <div class="section">
          <h2>제4조 (회원 탈퇴의 효과)</h2>
          <p>
            1. 회원 탈퇴가 완료되면, 회원은 서비스 이용 권한을 상실하며, 복구가
            불가능합니다.<br />
            2. 탈퇴한 회원은 동일한 이메일 주소로 재가입할 수 없습니다.<br />
            3. 탈퇴 이전에 회원이 작성한 게시물 및 댓글은 삭제되지 않으며,
            회원이 원할 경우 탈퇴 신청 전에 스스로 삭제해야 합니다.
          </p>
        </div>

        <div class="section">
          <h2>제5조 (손해배상)</h2>
          <p>
            1. 회원이 약관을 위반하여 회사에 손해가 발생한 경우, 회원은 회사에
            그 손해를 배상하여야 합니다.<br />
            2. 회사는 천재지변 또는 불가피한 사유로 인해 서비스를 제공할 수 없는
            경우, 이에 대한 책임을 지지 않습니다.
          </p>
        </div>

        <div class="section">
          <h2>제6조 (기타)</h2>
          <p>
            1. 본 약관에 명시되지 않은 사항은 회사의 이용약관 및 관계 법령에
            따릅니다.<br />
            2. 회사는 필요 시 본 약관을 변경할 수 있으며, 변경된 약관은 서비스
            내에 공지함으로써 효력을 발휘합니다.
          </p>
        </div>
      </div>
      <!-- <button @click="secession">정말로 탈퇴하시겠습니까?</button> -->
      <button @click="secession2" class="btn btn-secondary">탈퇴하기</button>
    </div>
  </div>
</template>

<script setup>
import {useRoute, useRouter} from "vue-router";
import {ref, onMounted, onUnmounted} from "vue";
import {useLoginStore} from "@/stores/login";
import {useUserStore} from "@/stores/user";
import {useMentorStore} from "@/stores/mentor";
import {useCounselStore} from "@/stores/counsel";

const userStore = useUserStore();
const loginStore = useLoginStore();
const mentorStore = useMentorStore();
const counselStore = useCounselStore();
const route = useRoute();
const router = useRouter();

// const secession = () => {
//   const id = route.params.id;
//   mentorStore.deleteMentor(id);
//   counselStore.secessionCounsel(id);
//   userStore.deleteUser(id);
//   loginStore.logout();
//   router.push('/'); // Redirect to login after logout
// };
// const secession2 = () => {
//   const id = route.params.id;
//   userStore.deleteUser(id);
//   loginStore.logout();
//   router.push('/'); // Redirect to login after logout
// };
const secession2 = () => {
  if (confirm("정말로 회원 탈퇴 하시겠습니까? 다시는 되돌릴 수 없습니다.")) {
    const id = route.params.id;
    mentorStore.deleteMentor(id);
    counselStore.secessionCounsel(id);
    userStore.deleteUser(id);
    loginStore.logout();
  }
};
</script>

<style scoped>
.content {
  padding: 10px;
  background-color: rgb(255, 254, 214);
  margin: 20px;
  display: center;
}
.terms {
  font-family: Arial, sans-serif;
  line-height: 1.6;
  margin: 1%;
  padding-left: 100px;
  padding-top: 3%;
  padding-bottom: 3%;
  background-color: white;
  text-align: left;
}
h1,
h2 {
  color: #333;
}
p {
  margin: 10px 0;
}
.section {
  margin-bottom: 20px;
}
</style>

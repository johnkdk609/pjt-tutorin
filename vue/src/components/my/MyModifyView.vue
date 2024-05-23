<template>
  <div>
    <h1>개인 정보 수정</h1>
    <div class="content">
      <div class="inputs">
        <div>
          <span>현재 비밀번호&nbsp;&nbsp;&nbsp;&nbsp;</span>
          <input type="password" placeholder="현재 비밀번호" v-model="inputPassword" />
        </div>
        <div>
          <span>새 비밀번호&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
          <input type="password" placeholder="비밀번호" v-model="newPassword" />
        </div>
        <div>
          <span>새 비밀번호 확인</span>
          <input type="password" placeholder="비밀번호 확인" v-model="newPassword2" />
        </div>
        <div>
          <span>이름
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
          <input type="text" placeholder="이름" v-model="userStore.user.name" />
        </div>
        <div>
          <span>이메일&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
          <input type="email" placeholder="이메일 주소" v-model="userStore.user.email" />
        </div>
        <div>
          <span>닉네임&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
          <input type="text" placeholder="닉네임 (다른 사용자에게 보여지는 이름입니다.)" v-model="userStore.user.nickname" />
        </div>
        <div>
          <span>전화번호&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
          <input type="text" placeholder="전화번호 ( - 제외)" v-model="userStore.user.phoneNum" />
        </div>
        <div v-if="loginStore.loginUser.status === 2">
          <span>계좌번호&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
          <input type="text" placeholder="계좌 번호 (멘토로 답변 완료 시 입금될 계좌번호입니다.)" v-model="mentorStore.mentor.accountNum" />
        </div>
        <div v-if="loginStore.loginUser.status === 2">
          <span>상담 금액&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
          <input type="text" placeholder="상담 금액 (멘토의 상담 금액입니다)" v-model="mentorStore.mentor.accountFee" />
        </div>
        <div>
          <span>이미지 변경&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
          <input type="text" placeholder="이미지 변경" v-model="userStore.user.image" />
        </div>
      </div>
      <div class="buttons">
        <button v-if="userStore.user.status == 1" @click="modifyStatus">멘토 등록</button>
        <button>멘토 활성화</button>
        <button @click="modify">저장하기</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useRoute } from "vue-router";
import { ref, onMounted, onUnmounted } from "vue";
import { useLoginStore } from "@/stores/login";
import { useUserStore } from "@/stores/user";
import { useMentorStore } from "@/stores/mentor";

const userStore = useUserStore();
const loginStore = useLoginStore();
const mentorStore = useMentorStore();
const route = useRoute();

const inputPassword = ref("");
const newPassword = ref("");
const newPassword2 = ref("");

onMounted(() => {
  userStore.getUser(route.params.id);
  if(loginStore.loginUser.status===2){
  mentorStore.getMentor(route.params.id);}
});
onUnmounted(() => {
  userStore.user = {};
  mentorStore.mentor = {};
});

const modify = () => {
  if (userStore.user.password === inputPassword.value) {
    if (newPassword.value === newPassword2.value) {
      userStore.user.password = newPassword.value;
      userStore.updateUser(loginStore.loginUser.id);
      mentorStore.updateMentor(loginStore.loginUser.id);
      alert("변경되었습니다.");
      window.location.reload();
    } else {
      alert("새 비밀번호를 확인해주세요.");
    }
  } else {
    alert("현재 비밀번호를 확인해주세요.");
  }
};

const modifyStatus = () => {
  if (confirm('멘토로 전환하시겠습니까? 다시는 되돌릴 수 없습니다.')) {
    userStore.user.status = 2;
    userStore.updateUser(loginStore.loginUser.id);
    loginStore.loginUser.status = 2;

    
    mentorStore.mentor.id = loginStore.loginUser.id;
    mentorStore.postMentor();
  }
}
</script>

<style scoped>
.content {
  display: flex;
  /* flexbox를 사용하여 inputs와 buttons를 같은 줄에 배치 */
  align-items: flex-end;
  /* buttons를 아래쪽에 정렬 */
  background-color: rgb(255, 254, 214);
  margin: 20px;
  padding: 20px;
  height: 730px;
}

.inputs div {
  font-weight: bold;
  text-align: left;
}

.inputs {
  flex: 2;
  /* inputs 영역이 더 넓게 설정됨 */
  display: flex;
  flex-direction: column;
  width: 510px;
}

.inputs input {
  width: 60%;
  /* input 요소의 너비를 조정 */
  margin: 10px 0;
  margin-left: 20px;
  padding: 10px;
}

.buttons {
  flex: 1;
  /* buttons 영역이 좁게 설정됨 */
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  /* 버튼들을 왼쪽에 정렬 */
  align-self: flex-end;
  /* buttons를 아래쪽에 정렬 */
}

.buttons button {
  border-radius: 10px;
  background-color: rgb(83, 97, 219);
  color: white;
  text-align: center;
  cursor: pointer;
  padding: 10px 20px;
  width: 200px;
  /* 버튼의 너비를 부모 요소에 맞춤 */
  margin: 10px 0;
}

.buttons button:hover {
  background-color: rgb(55, 64, 146);
}
</style>

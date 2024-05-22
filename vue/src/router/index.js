import { createRouter, createWebHistory } from "vue-router";

import HomeView from "@/views/HomeView.vue";
import LoginView from "@/views/LoginView.vue";
import RegistView from "@/views/RegistView.vue";
import MyView from "@/views/MyView.vue";

import MyHomeView from "@/components/my/MyHomeView.vue";
import MyModifyView from "@/components/my/MyModifyView.vue";
import MyModifyProfileView from "@/components/my/MyModifyProfileView.vue";
import MyRequestView from "@/components/my/MyRequestView.vue";
import MyResponseView from "@/components/my/MyResponseView.vue";
import MyEtcView from "@/components/my/MyEtcView.vue";

import RequestWaitView from "@/components/request/RequestWaitView.vue";
import RequestProceedView from "@/components/request/RequestProceedView.vue";
import RequestDoneView from "@/components/request/RequestDoneView.vue";
import ResponseWaitView from "@/components/response/ResponseWaitView.vue";
import ResponseProceedView from "@/components/response/ResponseProceedView.vue";
import ResponseDoneView from "@/components/response/ResponseDoneView.vue";

import MenteeProfileView from "@/components/profile/MenteeProfileView.vue";
import MentorProfileView from "@/components/profile/MentorProfileView.vue";

import WriteForm from "@/components/counsel/WriteForm.vue";
import WaitFormE from "@/components/counsel/WaitFormE.vue";
import WaitFormR from "@/components/counsel/WaitFormR.vue";
import ProceedFormE from "@/components/counsel/ProceedFormE.vue";
import ProceedFormR from "@/components/counsel/ProceedFormR.vue";
import ASFormE from "@/components/counsel/ASFormE.vue";
import ASFormR from "@/components/counsel/ASFormR.vue";
import DoneFormE from "@/components/counsel/DoneFormE.vue";
import DoneFormR from "@/components/counsel/DoneFormR.vue";

import ViewWithHeader from "@/views/ViewWithHeader.vue";
import ViewWithoutHeader from "@/views/ViewWithoutHeader.vue";
import { useLoginStore } from '@/stores/login'
import PrivateView from "@/views/PrivateView.vue";
import ChatgptView from "@/views/ChatgptView.vue"

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      component: ViewWithHeader,
      children: [
        {
          path: "",
          name: "home",
          component: HomeView,
        },
        {
          path: "login",
          name: "login",
          component: LoginView,
        },
        {
          path: '/private',
          name: 'private',
          component: PrivateView
        },
        {
          path: "regist",
          name: "regist",
          component: RegistView,
        },
        
        {
          path: "counsel/write",
          name: "writeform",
          component: WriteForm,
        },
        {
          path: '/chatgpt',
          name: 'chatgpt',
          component: ChatgptView
        },

        {
          path: "my/:id",
          name: "mypage",
          component: MyView,
          children: [
            {
              path: "",
              name: "myhome",
              component: MyHomeView,
            },
            {
              path: "modify",
              name: "modify",
              component: MyModifyView,
            },
            {
              path: "modifyprofile",
              name: "modifyprofile",
              component: MyModifyProfileView,
            },
            {
              path: "request",
              name: "request",
              component: MyRequestView,
              children: [
                {
                  path: "wait",
                  name: "reqwait",
                  component: RequestWaitView,
                },
                {
                  path: "proceed",
                  name: "reqproceed",
                  component: RequestProceedView,
                },
                {
                  path: "done",
                  name: "reqdone",
                  component: RequestDoneView,
                },
              ],
            },
            {
              path: "response",
              name: "response",
              component: MyResponseView,
              children: [
                {
                  path: "wait",
                  name: "reswait",
                  component: ResponseWaitView,
                },
                {
                  path: "proceed",
                  name: "resproceed",
                  component: ResponseProceedView,
                },
                {
                  path: "done",
                  name: "resdone",
                  component: ResponseDoneView,
                },
              ],
            },
            {
              path: "etc",
              name: "etc",
              component: MyEtcView,
            },
          ],
        },
        {
          path: "regist",
          name: "regist",
          component: RegistView,
        },
        {
          path: "profile/mentee/:id",
          name: "mentee_profile",
          component: MenteeProfileView,
        },
        {
          path: "profile/mentor/:id",
          name: "mentor_profile",
          component: MentorProfileView,
        },
      ],
    },

    {
      path: "/out",
      component: ViewWithoutHeader,
      children: [
        {
          path: "counsel",
          children: [
            {
              path: "wait",
              children: [
                {
                  path: "e/:id",
                  name: "waitformE",
                  component: WaitFormE,
                },
                {
                  path: "r/:id",
                  name: "waitformR",
                  component: WaitFormR,
                },
              ],
            },

            {
              path: "proceed",
              children: [
                {
                  path: "e/:id",
                  name: "proceedformE",
                  component: ProceedFormE,
                },
                {
                  path: "r/:id",
                  name: "proceedformR",
                  component: ProceedFormR,
                },
              ],
            },
            {
              path: "as",
              children: [
                {
                  path: "e/:id",
                  name: "asformE",
                  component: ASFormE,
                },
                {
                  path: "r/:id",
                  name: "asformR",
                  component: ASFormR,
                },
              ],
            },

            {
              path: "done",
              children: [
                {
                  path: "e/:id",
                  name: "doneformE",
                  component: DoneFormE,
                },
                {
                  path: "r/:id",
                  name: "doneformR",
                  component: DoneFormR,
                },
              ],
            },
          ],
        },
      ],
    },
  ],
});

// navigation guard
router.beforeEach((to, from) => {
  const loginStore = useLoginStore();

  // 토큰이 없는데 login, home, regist 페이지가 아니면 홈으로 보내기
  // if (loginStore.accessToken === '' && (to.name !== 'login' && to.name !== 'home' && to.name !== 'regist')) {
  if (loginStore.accessToken === '' && (to.name === 'myhome')) {  
    alert('로그인을 먼저 해주세요');
    return { name: 'home' };
  }
  // 탐색을 취소하려면 명시적으로 false를 반환해야 함.
  return true;
});


export default router;

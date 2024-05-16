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

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path: "/login",
      name: "login",
      component: LoginView,
    },
    {
      path: "/regist",
      name: "regist",
      component: RegistView,
    },
    {
      path: "/my",
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
              path: "reqproceed",
              name: "reqproceed",
              component: RequestProceedView,
            },
            {
              path: "reqdone",
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
              path: "resproceed",
              name: "resproceed",
              component: ResponseProceedView,
            },
            {
              path: "resdone",
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
      path: "/regist",
      name: "regist",
      component: RegistView,
    },
    {
      path: "/profile/mentee",
      name: "mentee_profile",
      component: MenteeProfileView,
    },
    {
      path: "/profile/mentor",
      name: "mentor_profile",
      component: MentorProfileView,
    },
    {
      path: "/counsel",
      children: [
        {
          path: "write",
          name: "writeform",
          component: WriteForm,
        },

        {
          path: "wait",
          children: [
            {
              path: "e",
              name: "waitformE",
              component: WaitFormE,
            },
            {
              path: "r",
              name: "waitformR",
              component: WaitFormR,
            },
          ],
        },

        {
          path: "proceed",
          children: [
            {
              path: "e",
              name: "proceedformE",
              component: ProceedFormE,
            },
            {
              path: "r",
              name: "proceedformR",
              component: ProceedFormR,
            },
          ],
        },
        {
          path: "as",
          children: [
            {
              path: "e",
              name: "asformE",
              component: ASFormE,
            },
            {
              path: "r",
              name: "asformR",
              component: ASFormR,
            },
          ],
        },

        {
          path: "done",
          children: [
            {
              path: "e",
              name: "doneformE",
              component: DoneFormE,
            },
            {
              path: "r",
              name: "doneformR",
              component: DoneFormR,
            },
          ],
        },
      ],
    },
  ],
});

export default router;

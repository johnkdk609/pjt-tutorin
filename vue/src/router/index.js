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

import WriteForm from "@/components/counsel/WriteForm.vue"
import ViewForm from "@/components/counsel/ViewForm.vue"

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
          children:[
            {
              path: "",
              name: "reqwait",
              component: RequestWaitView,
            },{
              path: "reqproceed",
              name: "reqproceed",
              component: RequestProceedView,
            },{
              path: "reqdone",
              name: "reqdone",
              component: RequestDoneView,
            },
            {
              path: "counsel/view",
              name: "viewform",
              component: ViewForm,
            },
          ]
        },
        {
          path: "response",
          name: "response",
          component: MyResponseView,
          children:[
            {
              path: "",
              name: "reswait",
              component: ResponseWaitView,
            },{
              path: "resproceed",
              name: "resproceed",
              component: ResponseProceedView,
            },{
              path: "resdone",
              name: "resdone",
              component: ResponseDoneView,
            },
          ]
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
      path: "/counsel/write",
      name: "writeform",
      component: WriteForm,
    },
    
  ],
});

export default router;

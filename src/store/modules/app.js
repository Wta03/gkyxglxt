import router, { constantRoutes } from "@/router";
import { login } from "../../api/Login";
import { Message } from "element-ui";
import { getMenu } from "@/utils/routeParse";

const mutations = {
  SET_TOKEN(state, payload) {
    state.token = payload;
  },
  SET_ROUTER_MENULIST(state, payload) {
    // 把固定路由和后端传来的路由合并为完整路由
    const array = constantRoutes.concat(payload);
    state.menuList = array;
    router.options.routes = array;
    router.addRoutes([...array]);

    console.log(router)
  },
};

const actions = {
  // 登录接口
  login({ commit }, loginInfo) {
    const username = loginInfo.username.trim();
    return new Promise((resolve, reject) => {
      login(username, loginInfo.password).then((res) => {
        if (res.data.code == "20000") {
          Message({
            type: "success",
            message: "登录成功",
          });
          localStorage.setItem(
            "userInfo",
            JSON.stringify(res.data.data.userInfo)
          );
          localStorage.setItem("token", res.data.data.token);
          commit("SET_TOKEN", res.data.data.token);
          resolve();
        } else {
          reject();
        }
      });
    });
  },
  // 获取后端传来的路由列表
  setMenuList({ commit }) {
    return new Promise((resolve) => {
      getMenu().then((res) => {
        commit("SET_ROUTER_MENULIST", res);
        resolve(res);
      });
    });
  },
};

const state = {
  token: "",
  menuList: [], //路由列表
};
export default {
  namespaced: true,
  state,
  mutations,
  actions,
};

import { getMenuList } from "../api/Login";
import Layout from "../layout/index.vue";

function tree(data, arr) {
  data.forEach((datas, index) => {
    console.log(datas)
    arr.push({
      path: datas.path,
      name: datas.name,
      component:
        datas.component == "Layout"
          ? Layout
          : () => import(`../views/${datas.component}/index.vue`),
      meta: {
        title: datas.meta.title,
      },
      // 子路由
      children: [],
    });   
    if (datas.children) {
      const childArr = tree(datas.children, []);
      arr[index].children = childArr;
    }
  });
  return arr;
}


export function getMenu() {
  return new Promise((resolve, reject) => {
    getMenuList(JSON.parse(localStorage.getItem('userInfo')).utype).then((res) => {
      if (res.data.code == 20000) {
        // 调用 tree 函数来解析后端返回来的树
        resolve(tree(res.data.data.permissions, []))
      } else {
          alert('获取菜单列表失败！')
          reject()
      }
    });
  })
}
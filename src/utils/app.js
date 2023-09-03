import { Message } from "element-ui";
// 判断删除结果
export function judgeDeleteResult(res) {
  if (res.data.code == 20000) {
    Message({
      type: "success",
      message: "删除成功!",
    });
  } else {
    Message({
      type: "error",
      message: "删除失败!",
    });
  }
  return res;
}
// 判断新增结果
export function judgeAddResult(res) {
  if (res.data.code == 20000) {
    Message({
      type: "success",
      message: "新增成功!",
    });
  }else if (res.data.code == 10001) {
    Message({
      type: "error",
      message: "该手机号已被注册",
    });
  } else {
    Message({
      type: "error",
      message: "新增失败",
    });
  }
  return res;
}
// 判断查询结果
export function judgeQueryResult(res) {
  if (res.data.code == 20000) {
    return res;
  } else {
    Message({
      type: "error",
      message: "加载数据失败!",
    });
    return false;
  }
}
// 判断修改结果
export function judgeModifyResult(res) {
  if (res.data.code == 20000) {
    Message({
      type: "success",
      message: "修改成功!",
    });
  } else if (res.data.code == 10001) {
    Message({
      type: "error",
      message: "该手机号已被注册",
    });
  } else {
    Message({
      type: "error",
      message: "修改失败!",
    });
  }
  return res;
}

// 判断重置密码结果
export function judgeResetResult(res) {
  if (res.data.code == 20000) {
    Message({
      type: "success",
      message: "重置密码成功!",
    });
  } else {
    Message({
      type: "error",
      message: "重置密码失败!",
    });
  }
  return res;
}


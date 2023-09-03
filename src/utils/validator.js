  // 登录规则
  export const loginRules = {
    usernameRules: [
      {
        required: true,
        message: "用户名不能为空",
        trigger: "blur",
      },
      {
        min: 3,
        max: 11,
        message: "用户名长度在 3 到 11 个字符",
        trigger: "blur",
      },
    ],
    passwordRules: [
      { required: true, message: "密码不能为空", trigger: "blur" },
      {
        min: 5,
        max: 18,
        message: "密码长度在 5 到 18 个字符",
        trigger: "blur",
      },
    ],
  };
  // 手机号验证器
function validatorPhone(rule, value, callback) {
  if (value === "") {
    callback(new Error(" 手机号不能为空 "));
  } else if (!/^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/.test(value)) {
    callback(new Error(" 手机号格式错误 "));
  } else {
    callback();
  }
}
// 通用验证规则
export default {
  phoneRules: [
    {
      required: true,
      validator: validatorPhone,
      trigger: "change",
    },
  ],
  nameRules: [
    { required: true, message: "名称不能为空", trigger: "change" },
    {
      min: 4,
      max: 24,
      message: "名称长度应为 4 到 24 个字符",
      trigger: "change",
    },
  ]
}

export const searchRules={

}

export const doctorRules={

}
export function validatePass(value,callback){
  if(value==""){
    callback(new Error("密码不能为空！"));
  }
}

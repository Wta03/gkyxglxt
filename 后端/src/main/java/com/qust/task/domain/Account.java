package com.qust.task.domain;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account extends SuperDomain {
    private Long id;
    private String uname;
    private String pwd;
    private String phoneNumber;
    private String utype;   //取值：ROLE_1：管理员、ROLE_2：医生、ROLE_3：患者
    private Date updatetime;
    private Date createtime;
    private String realname; //真实姓名

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", utype='" + utype + '\'' +
                ", updatetime=" + updatetime +
                ", createtime=" + createtime +
                ", realname='" + realname + '\'' +
                '}';
    }

    public Account(Long id, String uname, String pwd, String utype, String realname) {
        this.id = id;
        this.uname = uname;
        this.pwd = pwd;
        this.utype = utype;
        this.realname = realname;
    }
}

//省略构造方法以及get/set方法

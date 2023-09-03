package com.qust.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugCompany {
    private Long companyId;//公司id
    private String companyName;//公司名
    private String companyPhone;//公司电话
    private Date updatetime;//更新时间
    private Date createtime;//创建时间
    //省略get/set方法
}

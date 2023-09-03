package com.qust.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale extends SuperDomain {
    private Long saleId;//药店id
    private String saleName;//药店名
    private String salePhone;//药店电话
    private Date createtime;//创建时间
    private Date updatetime;//修改时间
    //省略get/set方法

}
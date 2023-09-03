package com.qust.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Material extends SuperDomain {
    private Integer id;//材料id
    private String title;//材料标题
    private String message;//材料内容
    private Date createTime;//创建时间
    private Date updateTime;//更新时间         //省略get/set方法

}
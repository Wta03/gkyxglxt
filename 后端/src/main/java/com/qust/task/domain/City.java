package com.qust.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {

    private Long cityId;//城市id
    private Integer cityNumber;//城市编号
    private Date createtime;//创建时间
    private Date updatetime;//修改时间
    //省略get/set方法
}

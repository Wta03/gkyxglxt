package com.qust.task.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuperDomain implements Serializable {
    private Long total; //总记录数
    @JsonIgnore
    private Integer pn = 1; //当前页
    @JsonIgnore
    private Integer size = Integer.MAX_VALUE; //每页大小
    @JsonIgnore
    private String keyword;//查询关键字
    //省略构造方法以及get/set方法
}

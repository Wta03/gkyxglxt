package com.qust.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorLevel extends SuperDomain {
    private Long id;//级别id
    private String name;//级别名称
    //省略get/set方法
}

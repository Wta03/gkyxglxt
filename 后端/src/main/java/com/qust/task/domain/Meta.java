package com.qust.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meta extends SuperDomain {
    private String title;//菜单title

    //省略get/set方法

}

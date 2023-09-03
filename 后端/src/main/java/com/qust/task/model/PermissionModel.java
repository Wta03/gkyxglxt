package com.qust.task.model;

import com.qust.task.domain.Permission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionModel extends Permission {
    private MetaModel meta;//存放meta封装的各个属性，icon、title等

    //省略get/set方法

}

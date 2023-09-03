package com.qust.task.param;

import com.qust.task.domain.Drug;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugParam extends Drug {

    private Long[] saleIds;//售卖该药品的药店
    //private String publisher;//发布者
    //省略get/set方法
}

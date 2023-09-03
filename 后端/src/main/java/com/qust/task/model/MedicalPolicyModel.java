package com.qust.task.model;

import com.qust.task.domain.MedicalPolicy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalPolicyModel extends MedicalPolicy {

    private CityModel cityModel;//医保政策包含的所属城市
//省略get/set方法


}
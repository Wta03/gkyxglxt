package com.qust.task.model;

import com.qust.task.domain.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityModel extends City {
    private String province;//省份
    private String city;//市

// 省略get/set方法
}
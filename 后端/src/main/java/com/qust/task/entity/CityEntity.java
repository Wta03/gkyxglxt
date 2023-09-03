package com.qust.task.entity;

import com.qust.task.domain.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityEntity extends City {

    private Long total;

//省略get/set方法
}

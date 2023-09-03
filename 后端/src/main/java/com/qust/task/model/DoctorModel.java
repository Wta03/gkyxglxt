package com.qust.task.model;

import com.qust.task.domain.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorModel extends Doctor {
    private String treatType;//诊治类型
    private String doctorLevel;//医师级别
    //省略get/set方法

}
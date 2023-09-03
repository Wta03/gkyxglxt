package com.qust.task.param;

import com.qust.task.domain.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorParam extends Doctor {
    private String pwd;
}

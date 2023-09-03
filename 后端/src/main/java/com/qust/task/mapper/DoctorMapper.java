package com.qust.task.mapper;

import com.qust.task.entity.AccountEntity;
import com.qust.task.entity.DoctorEntity;
import com.qust.task.model.DoctorLevelModel;
import com.qust.task.model.DoctorModel;
import com.qust.task.model.TreatTypeModel;
import com.qust.task.param.DoctorParam;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorMapper {
    /*获取所有的医师信息*/
    List<DoctorModel> getAllDoctor(DoctorParam param);

    /*获取所有的医师级别*/
    List<DoctorLevelModel> getAllLevel();

    /*获取所有的诊治类型*/
    List<TreatTypeModel> getAllTreatType();

    int saveDoctor(DoctorEntity param);

    int updateDoctor(DoctorEntity param);

    int deleteDoctorById(Long id);
}
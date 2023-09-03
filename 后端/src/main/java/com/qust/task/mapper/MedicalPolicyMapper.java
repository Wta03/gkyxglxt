package com.qust.task.mapper;

import com.qust.task.entity.MedicalPolicyEntity;
import com.qust.task.model.MedicalPolicyModel;
import com.qust.task.param.MedicalPolicyParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MedicalPolicyMapper {

    /*医保政策条件查询*/
    List<MedicalPolicyModel> getAllPolicy(MedicalPolicyParam param);

    /*新增医保政策*/
    int saveMedicalPolicy(MedicalPolicyEntity param);

    /*更新医保政策*/
    int updateMedicalPolicy(MedicalPolicyEntity param);

    /*根据id删除医保政策*/
    int deleteMedicalPolicy(Long id);

    /*
        根据城市删除医保政策

    */
    int deleteByCity(Integer city);

}
package com.qust.task.mapper;

import com.qust.task.entity.CompanyPolicyEntity;
import com.qust.task.model.CompanyPolicyModel;
import com.qust.task.param.CompanyPolicyParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CompanyPolicyMapper {

    /*查询所有的医药公司政策*/
    List<CompanyPolicyModel> getAllPolicy(CompanyPolicyParam param);

    /*新增医药公司政策*/
    int savePolicy(CompanyPolicyEntity entity);

    /*更新医药公司政策*/
    int updatePolicy(CompanyPolicyEntity entity);

    /*删除医药公司政策*/
    int deletePolicy(Long id);

    int deletePolicyByCompany(Integer id);
}

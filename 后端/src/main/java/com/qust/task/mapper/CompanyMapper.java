package com.qust.task.mapper;

import com.qust.task.domain.DrugCompany;
import com.qust.task.entity.DrugCompanyEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyMapper {

    /*获取所有医药公司信息,name不为空则模糊查询*/
    List<DrugCompany> getAllCompany(String name);

    /*根据id查找一个医药公司信息*/
    DrugCompany getCompanyById(Integer id);
    /*添加一个医药公司信息*/
    int saveCompany(DrugCompanyEntity company);

    /*根据id删除医药公司信息*/
    int deleteCompanyById(Integer id);

    /*根据id更新数据*/
    int updateCompanyById(DrugCompany company);
}
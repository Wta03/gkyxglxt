package com.qust.task.mapper;

import com.qust.task.entity.DrugEntity;
import com.qust.task.model.DrugModel;
import com.qust.task.param.DrugParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugMapper {
    /*查询所有药品同时,封装药品销售地点*/
    List<DrugModel> getAllDrug(String name);

    /*新增药品信息*/
    int saveDrug(DrugParam drugParam);

    /*根据id更新药店数据*/
    int updateDrugById(DrugEntity sale);

    /*插入该药店的售卖地点*/
    int insertSalePlace(Long drugId, Long[] saleIds);

    /*根据药品id删除对应的售卖地点*/
    int deleteSaleByDrugId(Long drugId);

    int deleteDrugById(Long drugId);
}

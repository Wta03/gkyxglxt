package com.qust.task.mapper;

import com.qust.task.domain.Sale;
import com.qust.task.entity.SaleEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SaleMapper {

    /*获取所有药店信息,name不为空则模糊查询*/
    List<Sale> getAllSale(String name);

    /*根据id查找一个药店信息*/
    Sale getSaleById(Integer id);

    /*添加一个药店信息*/
    int saveSale(SaleEntity sale);

    /*根据id删除药店信息*/
    int deleteSaleById(Integer id);

    /*根据id更新药店数据*/
    int updateSaleById(Sale sale);
}
package com.qust.task.entity;

import com.qust.task.domain.DrugCompany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrugCompanyEntity extends DrugCompany {

    private Long total;//插入存储返回插入后的总记录数

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
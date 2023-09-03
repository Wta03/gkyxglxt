package com.qust.task.model;

import com.qust.task.domain.CompanyPolicy;

public class CompanyPolicyModel extends CompanyPolicy {

    private DrugCompanyModel drugCompanyModel;

    public DrugCompanyModel getDrugCompanyModel() {
        return drugCompanyModel;
    }

    public void setDrugCompanyModel(DrugCompanyModel drugCompanyModel) {
        this.drugCompanyModel = drugCompanyModel;
    }
}
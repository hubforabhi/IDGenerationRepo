package com.maintec.fincore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maintec.fincore.util.ResponseStatus;
import lombok.Data;

import java.util.List;

@Data
public class IDSearchResponseModel extends IDSearchRequestModel {
    private List<SearchByIDCustomerModel> customers;
    private List<SearchByIDCompanyModel> companies;

    @JsonIgnore
    private ResponseStatus responseStatus;
}

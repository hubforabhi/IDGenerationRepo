package com.maintec.fincore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class IDSearchRequestModel {
    private String id;
    private String name;
    private String aadhaar;
    private String pfNo;
    private String licenseNo;
    private String accountNo;

    @JsonIgnore
    private String userId;
}

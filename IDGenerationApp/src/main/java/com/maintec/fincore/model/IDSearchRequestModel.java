package com.maintec.fincore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class IDSearchRequestModel {
    private String searchType;

    private String name;
    private String status;

    @JsonIgnore
    private String userId;
}

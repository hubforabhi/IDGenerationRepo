package com.maintec.fincore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class IDSearchRequestModel {
    private String id;

    @JsonIgnore
    private String userId;
}

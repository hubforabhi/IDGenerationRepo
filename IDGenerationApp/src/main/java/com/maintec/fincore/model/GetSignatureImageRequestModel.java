package com.maintec.fincore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class GetSignatureImageRequestModel {
    private String id;

    @JsonIgnore
    private String imageURL;

    @JsonIgnore
    private String userId;
}

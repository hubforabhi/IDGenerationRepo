package com.maintec.fincore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maintec.fincore.util.ResponseStatus;
import lombok.Data;

@Data
public class PersonalIDGenerationResponseModel extends PersonalIDGenerationRequestModel {
    private String id;

    @JsonIgnore
    private ResponseStatus responseStatus;

    public PersonalIDGenerationResponseModel() {
        responseStatus = ResponseStatus.OK;
    }
}

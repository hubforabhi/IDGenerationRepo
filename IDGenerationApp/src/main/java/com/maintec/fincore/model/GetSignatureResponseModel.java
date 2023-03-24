package com.maintec.fincore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maintec.fincore.util.ResponseStatus;
import lombok.Data;

@Data
public class GetSignatureResponseModel {
    private String id;
    private String type;
    private byte[] content;
    private String extension;

    @JsonIgnore
    private ResponseStatus responseStatus;
}

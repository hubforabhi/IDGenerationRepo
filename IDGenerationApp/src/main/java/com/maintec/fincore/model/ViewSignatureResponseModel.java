package com.maintec.fincore.model;


import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maintec.fincore.util.ResponseStatus;

@Data
public class ViewSignatureResponseModel {
   private String id;
   private String searchIdNo;
   private String type;
   private String enteredDate;

   @JsonIgnore
    private ResponseStatus responseStatus;
}

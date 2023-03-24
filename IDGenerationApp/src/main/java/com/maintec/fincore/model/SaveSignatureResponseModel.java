package com.maintec.fincore.model;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maintec.fincore.util.ResponseStatus;

@Data
public class SaveSignatureResponseModel {
   private String searchIdNo;
   private long id;
   private String type;
   private String enteredDate;

   @JsonIgnore
   ResponseStatus responseStatus;
}

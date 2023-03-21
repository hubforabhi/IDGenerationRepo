package com.maintec.fincore.model;


import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maintec.fincore.util.ResponseStatus;

@Data
public class ViewSignatureResponseModel {
   private String searchIdNo;
   private String name;
   private String type;
   private String title;

   @JsonIgnore
    private ResponseStatus responseStatus;
}

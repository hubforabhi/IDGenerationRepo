package com.maintec.fincore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maintec.fincore.util.ResponseStatus;
import lombok.Data;

@Data
public class SearchCautionResponseModel {
   private long id;
   private String description;
   private String releaseReason;

   @JsonIgnore
   private ResponseStatus responseStatus;
}

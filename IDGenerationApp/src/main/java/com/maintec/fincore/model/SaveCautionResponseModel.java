package com.maintec.fincore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maintec.fincore.util.ResponseStatus;
import lombok.Data;

@Data
public class SaveCautionResponseModel extends SaveCautionRequestModel {
   private String id;

   @JsonIgnore
   private ResponseStatus responseStatus;
}

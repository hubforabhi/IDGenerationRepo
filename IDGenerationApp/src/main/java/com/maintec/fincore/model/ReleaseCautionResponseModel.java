package com.maintec.fincore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maintec.fincore.util.ResponseStatus;
import lombok.Data;

@Data
public class ReleaseCautionResponseModel extends ReleaseCautionRequestModel {

   @JsonIgnore
   private ResponseStatus responseStatus;
}

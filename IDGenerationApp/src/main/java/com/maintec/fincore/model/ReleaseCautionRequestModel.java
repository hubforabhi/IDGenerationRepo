package com.maintec.fincore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ReleaseCautionRequestModel {
   private String id;
   private String releaseReason;

   @JsonIgnore
   private String userId;
}

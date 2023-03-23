package com.maintec.fincore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class SaveCautionRequestModel {
   private String parentId;
   private String description;

   @JsonIgnore
   private String userId;

}

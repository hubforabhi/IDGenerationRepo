package com.maintec.fincore.model;


import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data public class CompanyIDGenerationRequestModel {
   protected String firmName;
   protected String searchIdNo;
   protected String decision;
   protected String reason;
   protected String idNo;
   protected String natueofAct;
   protected String income;
   protected String constitutionfirmType;
   protected String itWardCircle;
   protected String registrationNo;
   protected String registrationDate;
   protected String registrationPlace;
   protected String kstNo;
   protected String estNo;
   protected boolean wantHistory;
   protected String pan;

   @JsonIgnore
   private String userId;

}

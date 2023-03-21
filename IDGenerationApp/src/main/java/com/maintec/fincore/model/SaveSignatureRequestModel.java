package com.maintec.fincore.model;

import lombok.Data;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
public class SaveSignatureRequestModel {
   private String searchIdNo;
   private MultipartFile theFile;
   private String customerID;
   private String name;
   private String type;
   private String title;
   private String imageUrl;
   private String expiryDate;
   private String imgseq;

   @JsonIgnore
    private String userId;
}

package com.maintec.fincore.model;

import org.springframework.web.multipart.MultipartFile;

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

   public String getSearchIdNo() {
      return this.searchIdNo;
   }

   public MultipartFile getTheFile() {
      return this.theFile;
   }

   public String getCustomerID() {
      return this.customerID;
   }

   public String getName() {
      return this.name;
   }

   public String getType() {
      return this.type;
   }

   public String getTitle() {
      return this.title;
   }

   public String getImageUrl() {
      return this.imageUrl;
   }

   public String getExpiryDate() {
      return this.expiryDate;
   }

   public String getImgseq() {
      return this.imgseq;
   }

   public void setSearchIdNo(final String searchIdNo) {
      this.searchIdNo = searchIdNo;
   }

   public void setTheFile(final MultipartFile theFile) {
      this.theFile = theFile;
   }

   public void setCustomerID(final String customerID) {
      this.customerID = customerID;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setType(final String type) {
      this.type = type;
   }

   public void setTitle(final String title) {
      this.title = title;
   }

   public void setImageUrl(final String imageUrl) {
      this.imageUrl = imageUrl;
   }

   public void setExpiryDate(final String expiryDate) {
      this.expiryDate = expiryDate;
   }

   public void setImgseq(final String imgseq) {
      this.imgseq = imgseq;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SaveSignatureRequestModel)) {
         return false;
      } else {
         SaveSignatureRequestModel other = (SaveSignatureRequestModel)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$searchIdNo = this.getSearchIdNo();
            Object other$searchIdNo = other.getSearchIdNo();
            if (this$searchIdNo == null) {
               if (other$searchIdNo != null) {
                  return false;
               }
            } else if (!this$searchIdNo.equals(other$searchIdNo)) {
               return false;
            }

            Object this$theFile = this.getTheFile();
            Object other$theFile = other.getTheFile();
            if (this$theFile == null) {
               if (other$theFile != null) {
                  return false;
               }
            } else if (!this$theFile.equals(other$theFile)) {
               return false;
            }

            Object this$customerID = this.getCustomerID();
            Object other$customerID = other.getCustomerID();
            if (this$customerID == null) {
               if (other$customerID != null) {
                  return false;
               }
            } else if (!this$customerID.equals(other$customerID)) {
               return false;
            }

            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null) {
               if (other$name != null) {
                  return false;
               }
            } else if (!this$name.equals(other$name)) {
               return false;
            }

            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null) {
               if (other$type != null) {
                  return false;
               }
            } else if (!this$type.equals(other$type)) {
               return false;
            }

            Object this$title = this.getTitle();
            Object other$title = other.getTitle();
            if (this$title == null) {
               if (other$title != null) {
                  return false;
               }
            } else if (!this$title.equals(other$title)) {
               return false;
            }

            Object this$imageUrl = this.getImageUrl();
            Object other$imageUrl = other.getImageUrl();
            if (this$imageUrl == null) {
               if (other$imageUrl != null) {
                  return false;
               }
            } else if (!this$imageUrl.equals(other$imageUrl)) {
               return false;
            }

            Object this$expiryDate = this.getExpiryDate();
            Object other$expiryDate = other.getExpiryDate();
            if (this$expiryDate == null) {
               if (other$expiryDate != null) {
                  return false;
               }
            } else if (!this$expiryDate.equals(other$expiryDate)) {
               return false;
            }

            Object this$imgseq = this.getImgseq();
            Object other$imgseq = other.getImgseq();
            if (this$imgseq == null) {
               if (other$imgseq != null) {
                  return false;
               }
            } else if (!this$imgseq.equals(other$imgseq)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SaveSignatureRequestModel;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $searchIdNo = this.getSearchIdNo();
      result = result * 59 + ($searchIdNo == null ? 43 : $searchIdNo.hashCode());
      Object $theFile = this.getTheFile();
      result = result * 59 + ($theFile == null ? 43 : $theFile.hashCode());
      Object $customerID = this.getCustomerID();
      result = result * 59 + ($customerID == null ? 43 : $customerID.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $title = this.getTitle();
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $imageUrl = this.getImageUrl();
      result = result * 59 + ($imageUrl == null ? 43 : $imageUrl.hashCode());
      Object $expiryDate = this.getExpiryDate();
      result = result * 59 + ($expiryDate == null ? 43 : $expiryDate.hashCode());
      Object $imgseq = this.getImgseq();
      return result * 59 + ($imgseq == null ? 43 : $imgseq.hashCode());
   }

   public String toString() {
      return "SaveSignatureRequestModel(searchIdNo="
         + this.getSearchIdNo()
         + ", theFile="
         + String.valueOf(this.getTheFile())
         + ", customerID="
         + this.getCustomerID()
         + ", name="
         + this.getName()
         + ", type="
         + this.getType()
         + ", title="
         + this.getTitle()
         + ", imageUrl="
         + this.getImageUrl()
         + ", expiryDate="
         + this.getExpiryDate()
         + ", imgseq="
         + this.getImgseq()
         + ")";
   }
}

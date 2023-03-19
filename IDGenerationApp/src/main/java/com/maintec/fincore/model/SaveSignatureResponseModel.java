package com.maintec.fincore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maintec.fincore.util.ResponseStatus;

public class SaveSignatureResponseModel {
   private String searchIdNo;
   private long id;
   private String type;
   private String title;
   @JsonIgnore
   ResponseStatus responseStatus;

   public String getSearchIdNo() {
      return this.searchIdNo;
   }

   public long getId() {
      return this.id;
   }

   public String getType() {
      return this.type;
   }

   public String getTitle() {
      return this.title;
   }

   public ResponseStatus getResponseStatus() {
      return this.responseStatus;
   }

   public void setSearchIdNo(final String searchIdNo) {
      this.searchIdNo = searchIdNo;
   }

   public void setId(final long id) {
      this.id = id;
   }

   public void setType(final String type) {
      this.type = type;
   }

   public void setTitle(final String title) {
      this.title = title;
   }

   @JsonIgnore
   public void setResponseStatus(final ResponseStatus responseStatus) {
      this.responseStatus = responseStatus;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SaveSignatureResponseModel)) {
         return false;
      } else {
         SaveSignatureResponseModel other = (SaveSignatureResponseModel)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.getId() != other.getId()) {
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

            Object this$responseStatus = this.getResponseStatus();
            Object other$responseStatus = other.getResponseStatus();
            if (this$responseStatus == null) {
               if (other$responseStatus != null) {
                  return false;
               }
            } else if (!this$responseStatus.equals(other$responseStatus)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SaveSignatureResponseModel;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $id = this.getId();
      result = result * 59 + (int)($id >>> 32 ^ $id);
      Object $searchIdNo = this.getSearchIdNo();
      result = result * 59 + ($searchIdNo == null ? 43 : $searchIdNo.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $title = this.getTitle();
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $responseStatus = this.getResponseStatus();
      return result * 59 + ($responseStatus == null ? 43 : $responseStatus.hashCode());
   }

   public String toString() {
      return "SaveSignatureResponseModel(searchIdNo="
         + this.getSearchIdNo()
         + ", id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", title="
         + this.getTitle()
         + ", responseStatus="
         + String.valueOf(this.getResponseStatus())
         + ")";
   }
}

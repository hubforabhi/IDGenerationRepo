package com.maintec.fincore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SaveCautionRequestModel {
   private String parentId;
   private String description;
   @JsonIgnore
   private String userId;

   public String getParentId() {
      return this.parentId;
   }

   public String getDescription() {
      return this.description;
   }

   public String getUserId() {
      return this.userId;
   }

   public void setParentId(final String parentId) {
      this.parentId = parentId;
   }

   public void setDescription(final String description) {
      this.description = description;
   }

   @JsonIgnore
   public void setUserId(final String userId) {
      this.userId = userId;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SaveCautionRequestModel)) {
         return false;
      } else {
         SaveCautionRequestModel other = (SaveCautionRequestModel)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$parentId = this.getParentId();
            Object other$parentId = other.getParentId();
            if (this$parentId == null) {
               if (other$parentId != null) {
                  return false;
               }
            } else if (!this$parentId.equals(other$parentId)) {
               return false;
            }

            Object this$description = this.getDescription();
            Object other$description = other.getDescription();
            if (this$description == null) {
               if (other$description != null) {
                  return false;
               }
            } else if (!this$description.equals(other$description)) {
               return false;
            }

            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null) {
               if (other$userId != null) {
                  return false;
               }
            } else if (!this$userId.equals(other$userId)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SaveCautionRequestModel;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $parentId = this.getParentId();
      result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
      Object $description = this.getDescription();
      result = result * 59 + ($description == null ? 43 : $description.hashCode());
      Object $userId = this.getUserId();
      return result * 59 + ($userId == null ? 43 : $userId.hashCode());
   }

   public String toString() {
      return "SaveCautionRequestModel(parentId=" + this.getParentId() + ", description=" + this.getDescription() + ", userId=" + this.getUserId() + ")";
   }
}

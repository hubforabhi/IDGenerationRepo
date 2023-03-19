package com.maintec.fincore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ReleaseCautionRequestModel {
   private String id;
   private String releaseReason;
   @JsonIgnore
   private String userId;

   public String getId() {
      return this.id;
   }

   public String getReleaseReason() {
      return this.releaseReason;
   }

   public String getUserId() {
      return this.userId;
   }

   public void setId(final String id) {
      this.id = id;
   }

   public void setReleaseReason(final String releaseReason) {
      this.releaseReason = releaseReason;
   }

   @JsonIgnore
   public void setUserId(final String userId) {
      this.userId = userId;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ReleaseCautionRequestModel)) {
         return false;
      } else {
         ReleaseCautionRequestModel other = (ReleaseCautionRequestModel)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null) {
               if (other$id != null) {
                  return false;
               }
            } else if (!this$id.equals(other$id)) {
               return false;
            }

            Object this$releaseReason = this.getReleaseReason();
            Object other$releaseReason = other.getReleaseReason();
            if (this$releaseReason == null) {
               if (other$releaseReason != null) {
                  return false;
               }
            } else if (!this$releaseReason.equals(other$releaseReason)) {
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
      return other instanceof ReleaseCautionRequestModel;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $releaseReason = this.getReleaseReason();
      result = result * 59 + ($releaseReason == null ? 43 : $releaseReason.hashCode());
      Object $userId = this.getUserId();
      return result * 59 + ($userId == null ? 43 : $userId.hashCode());
   }

   public String toString() {
      return "ReleaseCautionRequestModel(id=" + this.getId() + ", releaseReason=" + this.getReleaseReason() + ", userId=" + this.getUserId() + ")";
   }
}

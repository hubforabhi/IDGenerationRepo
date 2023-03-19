package com.maintec.fincore.model;

public class SearchCautionResponseModel {
   private long id;
   private String description;
   private String releaseReason;

   public long getId() {
      return this.id;
   }

   public String getDescription() {
      return this.description;
   }

   public String getReleaseReason() {
      return this.releaseReason;
   }

   public void setId(final long id) {
      this.id = id;
   }

   public void setDescription(final String description) {
      this.description = description;
   }

   public void setReleaseReason(final String releaseReason) {
      this.releaseReason = releaseReason;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SearchCautionResponseModel)) {
         return false;
      } else {
         SearchCautionResponseModel other = (SearchCautionResponseModel)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.getId() != other.getId()) {
            return false;
         } else {
            Object this$description = this.getDescription();
            Object other$description = other.getDescription();
            if (this$description == null) {
               if (other$description != null) {
                  return false;
               }
            } else if (!this$description.equals(other$description)) {
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

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SearchCautionResponseModel;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $id = this.getId();
      result = result * 59 + (int)($id >>> 32 ^ $id);
      Object $description = this.getDescription();
      result = result * 59 + ($description == null ? 43 : $description.hashCode());
      Object $releaseReason = this.getReleaseReason();
      return result * 59 + ($releaseReason == null ? 43 : $releaseReason.hashCode());
   }

   public String toString() {
      return "SearchCautionResponseModel(id=" + this.getId() + ", description=" + this.getDescription() + ", releaseReason=" + this.getReleaseReason() + ")";
   }
}

package com.maintec.fincore.model;

public class ReleaseCautionResponseModel {
   private String releaseReason;

   public String getReleaseReason() {
      return this.releaseReason;
   }

   public void setReleaseReason(final String releaseReason) {
      this.releaseReason = releaseReason;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ReleaseCautionResponseModel)) {
         return false;
      } else {
         ReleaseCautionResponseModel other = (ReleaseCautionResponseModel)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
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
      return other instanceof ReleaseCautionResponseModel;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $releaseReason = this.getReleaseReason();
      return result * 59 + ($releaseReason == null ? 43 : $releaseReason.hashCode());
   }

   public String toString() {
      return "ReleaseCautionResponseModel(releaseReason=" + this.getReleaseReason() + ")";
   }
}

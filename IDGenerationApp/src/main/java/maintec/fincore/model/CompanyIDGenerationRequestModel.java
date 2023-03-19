package com.maintec.fincore.model;

public class CompanyIDGenerationRequestModel {
   private String firmName;

   public String getFirmName() {
      return this.firmName;
   }

   public void setFirmName(final String firmName) {
      this.firmName = firmName;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CompanyIDGenerationRequestModel)) {
         return false;
      } else {
         CompanyIDGenerationRequestModel other = (CompanyIDGenerationRequestModel)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$firmName = this.getFirmName();
            Object other$firmName = other.getFirmName();
            if (this$firmName == null) {
               if (other$firmName != null) {
                  return false;
               }
            } else if (!this$firmName.equals(other$firmName)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CompanyIDGenerationRequestModel;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $firmName = this.getFirmName();
      return result * 59 + ($firmName == null ? 43 : $firmName.hashCode());
   }

   public String toString() {
      return "CompanyIDGenerationRequestModel(firmName=" + this.getFirmName() + ")";
   }
}

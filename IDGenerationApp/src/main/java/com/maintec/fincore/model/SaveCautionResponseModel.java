package com.maintec.fincore.model;

public class SaveCautionResponseModel {
   private String description;

   public String getDescription() {
      return this.description;
   }

   public void setDescription(final String description) {
      this.description = description;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SaveCautionResponseModel)) {
         return false;
      } else {
         SaveCautionResponseModel other = (SaveCautionResponseModel)o;
         if (!other.canEqual(this)) {
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

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SaveCautionResponseModel;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $description = this.getDescription();
      return result * 59 + ($description == null ? 43 : $description.hashCode());
   }

   public String toString() {
      return "SaveCautionResponseModel(description=" + this.getDescription() + ")";
   }
}

package com.maintec.fincore.model;

public class CompanyIDGenerationResponseModel extends CompanyIDGenerationRequestModel {
   private String id;

   public String getId() {
      return this.id;
   }

   public void setId(final String id) {
      this.id = id;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CompanyIDGenerationResponseModel)) {
         return false;
      } else {
         CompanyIDGenerationResponseModel other = (CompanyIDGenerationResponseModel)o;
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

            return true;
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CompanyIDGenerationResponseModel;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      return result * 59 + ($id == null ? 43 : $id.hashCode());
   }

   @Override
   public String toString() {
      return "CompanyIDGenerationResponseModel(id=" + this.getId() + ")";
   }
}

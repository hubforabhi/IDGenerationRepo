package com.maintec.fincore.model;

public class ViewSignatureRequestModel {
   private String searchIdNo;

   public String getSearchIdNo() {
      return this.searchIdNo;
   }

   public void setSearchIdNo(final String searchIdNo) {
      this.searchIdNo = searchIdNo;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ViewSignatureRequestModel)) {
         return false;
      } else {
         ViewSignatureRequestModel other = (ViewSignatureRequestModel)o;
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

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ViewSignatureRequestModel;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $searchIdNo = this.getSearchIdNo();
      return result * 59 + ($searchIdNo == null ? 43 : $searchIdNo.hashCode());
   }

   public String toString() {
      return "ViewSignatureRequestModel(searchIdNo=" + this.getSearchIdNo() + ")";
   }
}

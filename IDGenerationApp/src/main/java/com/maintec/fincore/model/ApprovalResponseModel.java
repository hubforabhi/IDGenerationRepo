package com.maintec.fincore.model;

public class ApprovalResponseModel {
   private String response;

   public String getResponse() {
      return this.response;
   }

   public void setResponse(final String response) {
      this.response = response;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ApprovalResponseModel)) {
         return false;
      } else {
         ApprovalResponseModel other = (ApprovalResponseModel)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$response = this.getResponse();
            Object other$response = other.getResponse();
            if (this$response == null) {
               if (other$response != null) {
                  return false;
               }
            } else if (!this$response.equals(other$response)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ApprovalResponseModel;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $response = this.getResponse();
      return result * 59 + ($response == null ? 43 : $response.hashCode());
   }

   public String toString() {
      return "ApprovalResponseModel(response=" + this.getResponse() + ")";
   }
}

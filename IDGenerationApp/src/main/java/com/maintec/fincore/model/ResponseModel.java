package com.maintec.fincore.model;

public class ResponseModel {
   private Object data;
   private String message;
   private int statusCode;
   private String status;

   public Object getData() {
      return this.data;
   }

   public String getMessage() {
      return this.message;
   }

   public int getStatusCode() {
      return this.statusCode;
   }

   public String getStatus() {
      return this.status;
   }

   public void setData(final Object data) {
      this.data = data;
   }

   public void setMessage(final String message) {
      this.message = message;
   }

   public void setStatusCode(final int statusCode) {
      this.statusCode = statusCode;
   }

   public void setStatus(final String status) {
      this.status = status;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ResponseModel)) {
         return false;
      } else {
         ResponseModel other = (ResponseModel)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.getStatusCode() != other.getStatusCode()) {
            return false;
         } else {
            Object this$data = this.getData();
            Object other$data = other.getData();
            if (this$data == null) {
               if (other$data != null) {
                  return false;
               }
            } else if (!this$data.equals(other$data)) {
               return false;
            }

            Object this$message = this.getMessage();
            Object other$message = other.getMessage();
            if (this$message == null) {
               if (other$message != null) {
                  return false;
               }
            } else if (!this$message.equals(other$message)) {
               return false;
            }

            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null) {
               if (other$status != null) {
                  return false;
               }
            } else if (!this$status.equals(other$status)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ResponseModel;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getStatusCode();
      Object $data = this.getData();
      result = result * 59 + ($data == null ? 43 : $data.hashCode());
      Object $message = this.getMessage();
      result = result * 59 + ($message == null ? 43 : $message.hashCode());
      Object $status = this.getStatus();
      return result * 59 + ($status == null ? 43 : $status.hashCode());
   }

   public String toString() {
      return "ResponseModel(data="
         + String.valueOf(this.getData())
         + ", message="
         + this.getMessage()
         + ", statusCode="
         + this.getStatusCode()
         + ", status="
         + this.getStatus()
         + ")";
   }
}

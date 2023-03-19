package com.maintec.fincore.model;

public class ApprovalRequestModel {
   private String decision;
   private String reason;
   private String exceptionalReason;

   public String getDecision() {
      return this.decision;
   }

   public String getReason() {
      return this.reason;
   }

   public String getExceptionalReason() {
      return this.exceptionalReason;
   }

   public void setDecision(final String decision) {
      this.decision = decision;
   }

   public void setReason(final String reason) {
      this.reason = reason;
   }

   public void setExceptionalReason(final String exceptionalReason) {
      this.exceptionalReason = exceptionalReason;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ApprovalRequestModel)) {
         return false;
      } else {
         ApprovalRequestModel other = (ApprovalRequestModel)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$decision = this.getDecision();
            Object other$decision = other.getDecision();
            if (this$decision == null) {
               if (other$decision != null) {
                  return false;
               }
            } else if (!this$decision.equals(other$decision)) {
               return false;
            }

            Object this$reason = this.getReason();
            Object other$reason = other.getReason();
            if (this$reason == null) {
               if (other$reason != null) {
                  return false;
               }
            } else if (!this$reason.equals(other$reason)) {
               return false;
            }

            Object this$exceptionalReason = this.getExceptionalReason();
            Object other$exceptionalReason = other.getExceptionalReason();
            if (this$exceptionalReason == null) {
               if (other$exceptionalReason != null) {
                  return false;
               }
            } else if (!this$exceptionalReason.equals(other$exceptionalReason)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ApprovalRequestModel;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $decision = this.getDecision();
      result = result * 59 + ($decision == null ? 43 : $decision.hashCode());
      Object $reason = this.getReason();
      result = result * 59 + ($reason == null ? 43 : $reason.hashCode());
      Object $exceptionalReason = this.getExceptionalReason();
      return result * 59 + ($exceptionalReason == null ? 43 : $exceptionalReason.hashCode());
   }

   public String toString() {
      return "ApprovalRequestModel(decision="
         + this.getDecision()
         + ", reason="
         + this.getReason()
         + ", exceptionalReason="
         + this.getExceptionalReason()
         + ")";
   }
}

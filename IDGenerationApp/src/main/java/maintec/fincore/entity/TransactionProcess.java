package com.maintec.fincore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;

@Embeddable
public class TransactionProcess {
   private String txnSource;
   @OneToOne
   @JoinColumn(
      name = "FC_FIRST_APPROVED_BY"
   )
   private User firstApprovedBy;
   @OneToOne
   @JoinColumn(
      name = "FC_SECOND_APPROVED_BY"
   )
   private User secondApprovedBy;
   @OneToOne
   @JoinColumn(
      name = "FC_DENIED_BY"
   )
   private User deniedBy;
   @Column(
      name = "FC_FIRST_APPROVED_DATE"
   )
   private LocalDate firstApprovedDate;
   @Column(
      name = "FC_SECOND_APPROVED_DATE"
   )
   private LocalDate secondApprovedDate;
   @Column(
      name = "FC_DENIED_DATE"
   )
   private LocalDate deniedDate;
   @Column(
      name = "FC_EXCE_REASON_ENTRY"
   )
   private String entryExceptionalReason;
   @Column(
      name = "FC_EXCE_REASON_FIRST_APPROVE"
   )
   private String firstApproveExceptionalReason;
   @Column(
      name = "FC_EXCE_REASON_SECOND_APPROVE"
   )
   private String secondApproveExceptionalReason;
   @Column(
      name = "FC_DENIED_REASON"
   )
   private String deniedReason;
   @Column(
      name = "approval_reason"
   )
   private String approvalReason;
   @Column(
      name = "FC_TXN_STATUS"
   )
   private Integer transactionStatus;
   @Column(
      name = "FC_EXCEPTIONAL"
   )
   private boolean exceptional;
   @Column(
      name = "FC_APPROVED"
   )
   private boolean txnApproved;

   public String getTxnSource() {
      return this.txnSource;
   }

   public User getFirstApprovedBy() {
      return this.firstApprovedBy;
   }

   public User getSecondApprovedBy() {
      return this.secondApprovedBy;
   }

   public User getDeniedBy() {
      return this.deniedBy;
   }

   public LocalDate getFirstApprovedDate() {
      return this.firstApprovedDate;
   }

   public LocalDate getSecondApprovedDate() {
      return this.secondApprovedDate;
   }

   public LocalDate getDeniedDate() {
      return this.deniedDate;
   }

   public String getEntryExceptionalReason() {
      return this.entryExceptionalReason;
   }

   public String getFirstApproveExceptionalReason() {
      return this.firstApproveExceptionalReason;
   }

   public String getSecondApproveExceptionalReason() {
      return this.secondApproveExceptionalReason;
   }

   public String getDeniedReason() {
      return this.deniedReason;
   }

   public String getApprovalReason() {
      return this.approvalReason;
   }

   public Integer getTransactionStatus() {
      return this.transactionStatus;
   }

   public boolean isExceptional() {
      return this.exceptional;
   }

   public boolean isTxnApproved() {
      return this.txnApproved;
   }

   public void setTxnSource(final String txnSource) {
      this.txnSource = txnSource;
   }

   public void setFirstApprovedBy(final User firstApprovedBy) {
      this.firstApprovedBy = firstApprovedBy;
   }

   public void setSecondApprovedBy(final User secondApprovedBy) {
      this.secondApprovedBy = secondApprovedBy;
   }

   public void setDeniedBy(final User deniedBy) {
      this.deniedBy = deniedBy;
   }

   public void setFirstApprovedDate(final LocalDate firstApprovedDate) {
      this.firstApprovedDate = firstApprovedDate;
   }

   public void setSecondApprovedDate(final LocalDate secondApprovedDate) {
      this.secondApprovedDate = secondApprovedDate;
   }

   public void setDeniedDate(final LocalDate deniedDate) {
      this.deniedDate = deniedDate;
   }

   public void setEntryExceptionalReason(final String entryExceptionalReason) {
      this.entryExceptionalReason = entryExceptionalReason;
   }

   public void setFirstApproveExceptionalReason(final String firstApproveExceptionalReason) {
      this.firstApproveExceptionalReason = firstApproveExceptionalReason;
   }

   public void setSecondApproveExceptionalReason(final String secondApproveExceptionalReason) {
      this.secondApproveExceptionalReason = secondApproveExceptionalReason;
   }

   public void setDeniedReason(final String deniedReason) {
      this.deniedReason = deniedReason;
   }

   public void setApprovalReason(final String approvalReason) {
      this.approvalReason = approvalReason;
   }

   public void setTransactionStatus(final Integer transactionStatus) {
      this.transactionStatus = transactionStatus;
   }

   public void setExceptional(final boolean exceptional) {
      this.exceptional = exceptional;
   }

   public void setTxnApproved(final boolean txnApproved) {
      this.txnApproved = txnApproved;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TransactionProcess)) {
         return false;
      } else {
         TransactionProcess other = (TransactionProcess)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.isExceptional() != other.isExceptional()) {
            return false;
         } else if (this.isTxnApproved() != other.isTxnApproved()) {
            return false;
         } else {
            Object this$transactionStatus = this.getTransactionStatus();
            Object other$transactionStatus = other.getTransactionStatus();
            if (this$transactionStatus == null) {
               if (other$transactionStatus != null) {
                  return false;
               }
            } else if (!this$transactionStatus.equals(other$transactionStatus)) {
               return false;
            }

            Object this$txnSource = this.getTxnSource();
            Object other$txnSource = other.getTxnSource();
            if (this$txnSource == null) {
               if (other$txnSource != null) {
                  return false;
               }
            } else if (!this$txnSource.equals(other$txnSource)) {
               return false;
            }

            Object this$firstApprovedBy = this.getFirstApprovedBy();
            Object other$firstApprovedBy = other.getFirstApprovedBy();
            if (this$firstApprovedBy == null) {
               if (other$firstApprovedBy != null) {
                  return false;
               }
            } else if (!this$firstApprovedBy.equals(other$firstApprovedBy)) {
               return false;
            }

            Object this$secondApprovedBy = this.getSecondApprovedBy();
            Object other$secondApprovedBy = other.getSecondApprovedBy();
            if (this$secondApprovedBy == null) {
               if (other$secondApprovedBy != null) {
                  return false;
               }
            } else if (!this$secondApprovedBy.equals(other$secondApprovedBy)) {
               return false;
            }

            Object this$deniedBy = this.getDeniedBy();
            Object other$deniedBy = other.getDeniedBy();
            if (this$deniedBy == null) {
               if (other$deniedBy != null) {
                  return false;
               }
            } else if (!this$deniedBy.equals(other$deniedBy)) {
               return false;
            }

            Object this$firstApprovedDate = this.getFirstApprovedDate();
            Object other$firstApprovedDate = other.getFirstApprovedDate();
            if (this$firstApprovedDate == null) {
               if (other$firstApprovedDate != null) {
                  return false;
               }
            } else if (!this$firstApprovedDate.equals(other$firstApprovedDate)) {
               return false;
            }

            Object this$secondApprovedDate = this.getSecondApprovedDate();
            Object other$secondApprovedDate = other.getSecondApprovedDate();
            if (this$secondApprovedDate == null) {
               if (other$secondApprovedDate != null) {
                  return false;
               }
            } else if (!this$secondApprovedDate.equals(other$secondApprovedDate)) {
               return false;
            }

            Object this$deniedDate = this.getDeniedDate();
            Object other$deniedDate = other.getDeniedDate();
            if (this$deniedDate == null) {
               if (other$deniedDate != null) {
                  return false;
               }
            } else if (!this$deniedDate.equals(other$deniedDate)) {
               return false;
            }

            Object this$entryExceptionalReason = this.getEntryExceptionalReason();
            Object other$entryExceptionalReason = other.getEntryExceptionalReason();
            if (this$entryExceptionalReason == null) {
               if (other$entryExceptionalReason != null) {
                  return false;
               }
            } else if (!this$entryExceptionalReason.equals(other$entryExceptionalReason)) {
               return false;
            }

            Object this$firstApproveExceptionalReason = this.getFirstApproveExceptionalReason();
            Object other$firstApproveExceptionalReason = other.getFirstApproveExceptionalReason();
            if (this$firstApproveExceptionalReason == null) {
               if (other$firstApproveExceptionalReason != null) {
                  return false;
               }
            } else if (!this$firstApproveExceptionalReason.equals(other$firstApproveExceptionalReason)) {
               return false;
            }

            Object this$secondApproveExceptionalReason = this.getSecondApproveExceptionalReason();
            Object other$secondApproveExceptionalReason = other.getSecondApproveExceptionalReason();
            if (this$secondApproveExceptionalReason == null) {
               if (other$secondApproveExceptionalReason != null) {
                  return false;
               }
            } else if (!this$secondApproveExceptionalReason.equals(other$secondApproveExceptionalReason)) {
               return false;
            }

            Object this$deniedReason = this.getDeniedReason();
            Object other$deniedReason = other.getDeniedReason();
            if (this$deniedReason == null) {
               if (other$deniedReason != null) {
                  return false;
               }
            } else if (!this$deniedReason.equals(other$deniedReason)) {
               return false;
            }

            Object this$approvalReason = this.getApprovalReason();
            Object other$approvalReason = other.getApprovalReason();
            if (this$approvalReason == null) {
               if (other$approvalReason != null) {
                  return false;
               }
            } else if (!this$approvalReason.equals(other$approvalReason)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TransactionProcess;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isExceptional() ? 79 : 97);
      result = result * 59 + (this.isTxnApproved() ? 79 : 97);
      Object $transactionStatus = this.getTransactionStatus();
      result = result * 59 + ($transactionStatus == null ? 43 : $transactionStatus.hashCode());
      Object $txnSource = this.getTxnSource();
      result = result * 59 + ($txnSource == null ? 43 : $txnSource.hashCode());
      Object $firstApprovedBy = this.getFirstApprovedBy();
      result = result * 59 + ($firstApprovedBy == null ? 43 : $firstApprovedBy.hashCode());
      Object $secondApprovedBy = this.getSecondApprovedBy();
      result = result * 59 + ($secondApprovedBy == null ? 43 : $secondApprovedBy.hashCode());
      Object $deniedBy = this.getDeniedBy();
      result = result * 59 + ($deniedBy == null ? 43 : $deniedBy.hashCode());
      Object $firstApprovedDate = this.getFirstApprovedDate();
      result = result * 59 + ($firstApprovedDate == null ? 43 : $firstApprovedDate.hashCode());
      Object $secondApprovedDate = this.getSecondApprovedDate();
      result = result * 59 + ($secondApprovedDate == null ? 43 : $secondApprovedDate.hashCode());
      Object $deniedDate = this.getDeniedDate();
      result = result * 59 + ($deniedDate == null ? 43 : $deniedDate.hashCode());
      Object $entryExceptionalReason = this.getEntryExceptionalReason();
      result = result * 59 + ($entryExceptionalReason == null ? 43 : $entryExceptionalReason.hashCode());
      Object $firstApproveExceptionalReason = this.getFirstApproveExceptionalReason();
      result = result * 59 + ($firstApproveExceptionalReason == null ? 43 : $firstApproveExceptionalReason.hashCode());
      Object $secondApproveExceptionalReason = this.getSecondApproveExceptionalReason();
      result = result * 59 + ($secondApproveExceptionalReason == null ? 43 : $secondApproveExceptionalReason.hashCode());
      Object $deniedReason = this.getDeniedReason();
      result = result * 59 + ($deniedReason == null ? 43 : $deniedReason.hashCode());
      Object $approvalReason = this.getApprovalReason();
      return result * 59 + ($approvalReason == null ? 43 : $approvalReason.hashCode());
   }

   public String toString() {
      return "TransactionProcess(txnSource="
         + this.getTxnSource()
         + ", firstApprovedBy="
         + String.valueOf(this.getFirstApprovedBy())
         + ", secondApprovedBy="
         + String.valueOf(this.getSecondApprovedBy())
         + ", deniedBy="
         + String.valueOf(this.getDeniedBy())
         + ", firstApprovedDate="
         + String.valueOf(this.getFirstApprovedDate())
         + ", secondApprovedDate="
         + String.valueOf(this.getSecondApprovedDate())
         + ", deniedDate="
         + String.valueOf(this.getDeniedDate())
         + ", entryExceptionalReason="
         + this.getEntryExceptionalReason()
         + ", firstApproveExceptionalReason="
         + this.getFirstApproveExceptionalReason()
         + ", secondApproveExceptionalReason="
         + this.getSecondApproveExceptionalReason()
         + ", deniedReason="
         + this.getDeniedReason()
         + ", approvalReason="
         + this.getApprovalReason()
         + ", transactionStatus="
         + this.getTransactionStatus()
         + ", exceptional="
         + this.isExceptional()
         + ", txnApproved="
         + this.isTxnApproved()
         + ")";
   }
}

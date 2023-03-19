package com.maintec.fincore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(
   name = "PENDING_TABLE",
   schema = "public"
)
public class TransactionPendingTray {
   @Id
   @Column(
      name = "FC_ID"
   )
   @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "PENDING_SEQUENCER"
   )
   @SequenceGenerator(
      name = "PENDING_SEQUENCER",
      sequenceName = "PENDING_SEQUENCER"
   )
   private Long id;
   private Integer versionID;
   private Integer previousVersionID;
   private String refNumber;
   private String tableClassName;
   private String linkURL;
   private String processDescription;
   private String reason;
   private boolean expired;
   private boolean exceptional;
   private boolean master;
   private boolean committed;
   private Integer status;
   @OneToOne
   @JoinColumn(
      name = "FC_ENTERED_BY"
   )
   private User enteredBy;
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
   @ManyToOne(
      fetch = FetchType.LAZY,
      optional = false
   )
   @JoinColumn(
      name = "FC_BRANCH"
   )
   private Branch branch;
   private LocalDate enteredDate;
   private BigDecimal balanceBeforeTxn;

   public Long getId() {
      return this.id;
   }

   public Integer getVersionID() {
      return this.versionID;
   }

   public Integer getPreviousVersionID() {
      return this.previousVersionID;
   }

   public String getRefNumber() {
      return this.refNumber;
   }

   public String getTableClassName() {
      return this.tableClassName;
   }

   public String getLinkURL() {
      return this.linkURL;
   }

   public String getProcessDescription() {
      return this.processDescription;
   }

   public String getReason() {
      return this.reason;
   }

   public boolean isExpired() {
      return this.expired;
   }

   public boolean isExceptional() {
      return this.exceptional;
   }

   public boolean isMaster() {
      return this.master;
   }

   public boolean isCommitted() {
      return this.committed;
   }

   public Integer getStatus() {
      return this.status;
   }

   public User getEnteredBy() {
      return this.enteredBy;
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

   public Branch getBranch() {
      return this.branch;
   }

   public LocalDate getEnteredDate() {
      return this.enteredDate;
   }

   public BigDecimal getBalanceBeforeTxn() {
      return this.balanceBeforeTxn;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setVersionID(final Integer versionID) {
      this.versionID = versionID;
   }

   public void setPreviousVersionID(final Integer previousVersionID) {
      this.previousVersionID = previousVersionID;
   }

   public void setRefNumber(final String refNumber) {
      this.refNumber = refNumber;
   }

   public void setTableClassName(final String tableClassName) {
      this.tableClassName = tableClassName;
   }

   public void setLinkURL(final String linkURL) {
      this.linkURL = linkURL;
   }

   public void setProcessDescription(final String processDescription) {
      this.processDescription = processDescription;
   }

   public void setReason(final String reason) {
      this.reason = reason;
   }

   public void setExpired(final boolean expired) {
      this.expired = expired;
   }

   public void setExceptional(final boolean exceptional) {
      this.exceptional = exceptional;
   }

   public void setMaster(final boolean master) {
      this.master = master;
   }

   public void setCommitted(final boolean committed) {
      this.committed = committed;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setEnteredBy(final User enteredBy) {
      this.enteredBy = enteredBy;
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

   public void setBranch(final Branch branch) {
      this.branch = branch;
   }

   public void setEnteredDate(final LocalDate enteredDate) {
      this.enteredDate = enteredDate;
   }

   public void setBalanceBeforeTxn(final BigDecimal balanceBeforeTxn) {
      this.balanceBeforeTxn = balanceBeforeTxn;
   }

   public String toString() {
      return "TransactionPendingTray(id="
         + this.getId()
         + ", versionID="
         + this.getVersionID()
         + ", previousVersionID="
         + this.getPreviousVersionID()
         + ", refNumber="
         + this.getRefNumber()
         + ", tableClassName="
         + this.getTableClassName()
         + ", linkURL="
         + this.getLinkURL()
         + ", processDescription="
         + this.getProcessDescription()
         + ", reason="
         + this.getReason()
         + ", expired="
         + this.isExpired()
         + ", exceptional="
         + this.isExceptional()
         + ", master="
         + this.isMaster()
         + ", committed="
         + this.isCommitted()
         + ", status="
         + this.getStatus()
         + ", enteredBy="
         + String.valueOf(this.getEnteredBy())
         + ", firstApprovedBy="
         + String.valueOf(this.getFirstApprovedBy())
         + ", secondApprovedBy="
         + String.valueOf(this.getSecondApprovedBy())
         + ", deniedBy="
         + String.valueOf(this.getDeniedBy())
         + ", branch="
         + String.valueOf(this.getBranch())
         + ", enteredDate="
         + String.valueOf(this.getEnteredDate())
         + ", balanceBeforeTxn="
         + String.valueOf(this.getBalanceBeforeTxn())
         + ")";
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TransactionPendingTray)) {
         return false;
      } else {
         TransactionPendingTray other = (TransactionPendingTray)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.isExpired() != other.isExpired()) {
            return false;
         } else if (this.isExceptional() != other.isExceptional()) {
            return false;
         } else if (this.isMaster() != other.isMaster()) {
            return false;
         } else if (this.isCommitted() != other.isCommitted()) {
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

            Object this$versionID = this.getVersionID();
            Object other$versionID = other.getVersionID();
            if (this$versionID == null) {
               if (other$versionID != null) {
                  return false;
               }
            } else if (!this$versionID.equals(other$versionID)) {
               return false;
            }

            Object this$previousVersionID = this.getPreviousVersionID();
            Object other$previousVersionID = other.getPreviousVersionID();
            if (this$previousVersionID == null) {
               if (other$previousVersionID != null) {
                  return false;
               }
            } else if (!this$previousVersionID.equals(other$previousVersionID)) {
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

            Object this$refNumber = this.getRefNumber();
            Object other$refNumber = other.getRefNumber();
            if (this$refNumber == null) {
               if (other$refNumber != null) {
                  return false;
               }
            } else if (!this$refNumber.equals(other$refNumber)) {
               return false;
            }

            Object this$tableClassName = this.getTableClassName();
            Object other$tableClassName = other.getTableClassName();
            if (this$tableClassName == null) {
               if (other$tableClassName != null) {
                  return false;
               }
            } else if (!this$tableClassName.equals(other$tableClassName)) {
               return false;
            }

            Object this$linkURL = this.getLinkURL();
            Object other$linkURL = other.getLinkURL();
            if (this$linkURL == null) {
               if (other$linkURL != null) {
                  return false;
               }
            } else if (!this$linkURL.equals(other$linkURL)) {
               return false;
            }

            Object this$processDescription = this.getProcessDescription();
            Object other$processDescription = other.getProcessDescription();
            if (this$processDescription == null) {
               if (other$processDescription != null) {
                  return false;
               }
            } else if (!this$processDescription.equals(other$processDescription)) {
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

            Object this$enteredBy = this.getEnteredBy();
            Object other$enteredBy = other.getEnteredBy();
            if (this$enteredBy == null) {
               if (other$enteredBy != null) {
                  return false;
               }
            } else if (!this$enteredBy.equals(other$enteredBy)) {
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

            Object this$branch = this.getBranch();
            Object other$branch = other.getBranch();
            if (this$branch == null) {
               if (other$branch != null) {
                  return false;
               }
            } else if (!this$branch.equals(other$branch)) {
               return false;
            }

            Object this$enteredDate = this.getEnteredDate();
            Object other$enteredDate = other.getEnteredDate();
            if (this$enteredDate == null) {
               if (other$enteredDate != null) {
                  return false;
               }
            } else if (!this$enteredDate.equals(other$enteredDate)) {
               return false;
            }

            Object this$balanceBeforeTxn = this.getBalanceBeforeTxn();
            Object other$balanceBeforeTxn = other.getBalanceBeforeTxn();
            if (this$balanceBeforeTxn == null) {
               if (other$balanceBeforeTxn != null) {
                  return false;
               }
            } else if (!this$balanceBeforeTxn.equals(other$balanceBeforeTxn)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TransactionPendingTray;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isExpired() ? 79 : 97);
      result = result * 59 + (this.isExceptional() ? 79 : 97);
      result = result * 59 + (this.isMaster() ? 79 : 97);
      result = result * 59 + (this.isCommitted() ? 79 : 97);
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $versionID = this.getVersionID();
      result = result * 59 + ($versionID == null ? 43 : $versionID.hashCode());
      Object $previousVersionID = this.getPreviousVersionID();
      result = result * 59 + ($previousVersionID == null ? 43 : $previousVersionID.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $refNumber = this.getRefNumber();
      result = result * 59 + ($refNumber == null ? 43 : $refNumber.hashCode());
      Object $tableClassName = this.getTableClassName();
      result = result * 59 + ($tableClassName == null ? 43 : $tableClassName.hashCode());
      Object $linkURL = this.getLinkURL();
      result = result * 59 + ($linkURL == null ? 43 : $linkURL.hashCode());
      Object $processDescription = this.getProcessDescription();
      result = result * 59 + ($processDescription == null ? 43 : $processDescription.hashCode());
      Object $reason = this.getReason();
      result = result * 59 + ($reason == null ? 43 : $reason.hashCode());
      Object $enteredBy = this.getEnteredBy();
      result = result * 59 + ($enteredBy == null ? 43 : $enteredBy.hashCode());
      Object $firstApprovedBy = this.getFirstApprovedBy();
      result = result * 59 + ($firstApprovedBy == null ? 43 : $firstApprovedBy.hashCode());
      Object $secondApprovedBy = this.getSecondApprovedBy();
      result = result * 59 + ($secondApprovedBy == null ? 43 : $secondApprovedBy.hashCode());
      Object $deniedBy = this.getDeniedBy();
      result = result * 59 + ($deniedBy == null ? 43 : $deniedBy.hashCode());
      Object $branch = this.getBranch();
      result = result * 59 + ($branch == null ? 43 : $branch.hashCode());
      Object $enteredDate = this.getEnteredDate();
      result = result * 59 + ($enteredDate == null ? 43 : $enteredDate.hashCode());
      Object $balanceBeforeTxn = this.getBalanceBeforeTxn();
      return result * 59 + ($balanceBeforeTxn == null ? 43 : $balanceBeforeTxn.hashCode());
   }
}

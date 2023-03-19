package com.maintec.fincore.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.time.LocalDate;

@Entity
@Table(
   name = "CAUTION",
   schema = "public"
)
public class Caution {
   @Id
   @Column(
      name = "ID"
   )
   @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "caution_counter"
   )
   @SequenceGenerator(
      name = "caution_counter",
      sequenceName = "caution_counter"
   )
   private Long id;
   @ManyToOne(
      fetch = FetchType.LAZY,
      optional = false
   )
   @JoinColumn(
      name = "accountID"
   )
   private ID parentID;
   @Column(
      name = "FC_CAUTION_DESC"
   )
   private String cautionDesc;
   @Column(
      name = "FC_RELEASE_DATE"
   )
   private LocalDate releaseDate;
   @Column(
      name = "FC_RELEASE_REASON"
   )
   private String releaseReson;
   @Column(
      name = "FC_ENTERED_DATE"
   )
   private LocalDate enteredDate;
   @Column(
      name = "FC_RELEASE_BY"
   )
   private Long releasedBy;
   @Column(
      name = "FC_COMPLETED"
   )
   private boolean completed;
   @Embedded
   private TransactionProcess transactionProcess;
   @ManyToOne(
      fetch = FetchType.LAZY
   )
   @JoinColumn(
      name = "FC_ENTERED_BY"
   )
   private User enteredBy;
   @ManyToOne(
      fetch = FetchType.LAZY,
      cascade = {CascadeType.PERSIST}
   )
   @JoinColumn(
      name = "FC_PENDING_TRAY_ID"
   )
   private TransactionPendingTray pendingTray;
   @Version
   @Column(
      name = "FC_VERSION_ID",
      nullable = false
   )
   private long versionID;

   public Long getId() {
      return this.id;
   }

   public ID getParentID() {
      return this.parentID;
   }

   public String getCautionDesc() {
      return this.cautionDesc;
   }

   public LocalDate getReleaseDate() {
      return this.releaseDate;
   }

   public String getReleaseReson() {
      return this.releaseReson;
   }

   public LocalDate getEnteredDate() {
      return this.enteredDate;
   }

   public Long getReleasedBy() {
      return this.releasedBy;
   }

   public boolean isCompleted() {
      return this.completed;
   }

   public TransactionProcess getTransactionProcess() {
      return this.transactionProcess;
   }

   public User getEnteredBy() {
      return this.enteredBy;
   }

   public TransactionPendingTray getPendingTray() {
      return this.pendingTray;
   }

   public long getVersionID() {
      return this.versionID;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setParentID(final ID parentID) {
      this.parentID = parentID;
   }

   public void setCautionDesc(final String cautionDesc) {
      this.cautionDesc = cautionDesc;
   }

   public void setReleaseDate(final LocalDate releaseDate) {
      this.releaseDate = releaseDate;
   }

   public void setReleaseReson(final String releaseReson) {
      this.releaseReson = releaseReson;
   }

   public void setEnteredDate(final LocalDate enteredDate) {
      this.enteredDate = enteredDate;
   }

   public void setReleasedBy(final Long releasedBy) {
      this.releasedBy = releasedBy;
   }

   public void setCompleted(final boolean completed) {
      this.completed = completed;
   }

   public void setTransactionProcess(final TransactionProcess transactionProcess) {
      this.transactionProcess = transactionProcess;
   }

   public void setEnteredBy(final User enteredBy) {
      this.enteredBy = enteredBy;
   }

   public void setPendingTray(final TransactionPendingTray pendingTray) {
      this.pendingTray = pendingTray;
   }

   public String toString() {
      return "Caution(id="
         + this.getId()
         + ", parentID="
         + String.valueOf(this.getParentID())
         + ", cautionDesc="
         + this.getCautionDesc()
         + ", releaseDate="
         + String.valueOf(this.getReleaseDate())
         + ", releaseReson="
         + this.getReleaseReson()
         + ", enteredDate="
         + String.valueOf(this.getEnteredDate())
         + ", releasedBy="
         + this.getReleasedBy()
         + ", completed="
         + this.isCompleted()
         + ", transactionProcess="
         + String.valueOf(this.getTransactionProcess())
         + ", enteredBy="
         + String.valueOf(this.getEnteredBy())
         + ", pendingTray="
         + String.valueOf(this.getPendingTray())
         + ", versionID="
         + this.getVersionID()
         + ")";
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof Caution)) {
         return false;
      } else {
         Caution other = (Caution)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.isCompleted() != other.isCompleted()) {
            return false;
         } else if (this.getVersionID() != other.getVersionID()) {
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

            Object this$releasedBy = this.getReleasedBy();
            Object other$releasedBy = other.getReleasedBy();
            if (this$releasedBy == null) {
               if (other$releasedBy != null) {
                  return false;
               }
            } else if (!this$releasedBy.equals(other$releasedBy)) {
               return false;
            }

            Object this$parentID = this.getParentID();
            Object other$parentID = other.getParentID();
            if (this$parentID == null) {
               if (other$parentID != null) {
                  return false;
               }
            } else if (!this$parentID.equals(other$parentID)) {
               return false;
            }

            Object this$cautionDesc = this.getCautionDesc();
            Object other$cautionDesc = other.getCautionDesc();
            if (this$cautionDesc == null) {
               if (other$cautionDesc != null) {
                  return false;
               }
            } else if (!this$cautionDesc.equals(other$cautionDesc)) {
               return false;
            }

            Object this$releaseDate = this.getReleaseDate();
            Object other$releaseDate = other.getReleaseDate();
            if (this$releaseDate == null) {
               if (other$releaseDate != null) {
                  return false;
               }
            } else if (!this$releaseDate.equals(other$releaseDate)) {
               return false;
            }

            Object this$releaseReson = this.getReleaseReson();
            Object other$releaseReson = other.getReleaseReson();
            if (this$releaseReson == null) {
               if (other$releaseReson != null) {
                  return false;
               }
            } else if (!this$releaseReson.equals(other$releaseReson)) {
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

            Object this$transactionProcess = this.getTransactionProcess();
            Object other$transactionProcess = other.getTransactionProcess();
            if (this$transactionProcess == null) {
               if (other$transactionProcess != null) {
                  return false;
               }
            } else if (!this$transactionProcess.equals(other$transactionProcess)) {
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

            Object this$pendingTray = this.getPendingTray();
            Object other$pendingTray = other.getPendingTray();
            if (this$pendingTray == null) {
               if (other$pendingTray != null) {
                  return false;
               }
            } else if (!this$pendingTray.equals(other$pendingTray)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof Caution;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isCompleted() ? 79 : 97);
      long $versionID = this.getVersionID();
      result = result * 59 + (int)($versionID >>> 32 ^ $versionID);
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $releasedBy = this.getReleasedBy();
      result = result * 59 + ($releasedBy == null ? 43 : $releasedBy.hashCode());
      Object $parentID = this.getParentID();
      result = result * 59 + ($parentID == null ? 43 : $parentID.hashCode());
      Object $cautionDesc = this.getCautionDesc();
      result = result * 59 + ($cautionDesc == null ? 43 : $cautionDesc.hashCode());
      Object $releaseDate = this.getReleaseDate();
      result = result * 59 + ($releaseDate == null ? 43 : $releaseDate.hashCode());
      Object $releaseReson = this.getReleaseReson();
      result = result * 59 + ($releaseReson == null ? 43 : $releaseReson.hashCode());
      Object $enteredDate = this.getEnteredDate();
      result = result * 59 + ($enteredDate == null ? 43 : $enteredDate.hashCode());
      Object $transactionProcess = this.getTransactionProcess();
      result = result * 59 + ($transactionProcess == null ? 43 : $transactionProcess.hashCode());
      Object $enteredBy = this.getEnteredBy();
      result = result * 59 + ($enteredBy == null ? 43 : $enteredBy.hashCode());
      Object $pendingTray = this.getPendingTray();
      return result * 59 + ($pendingTray == null ? 43 : $pendingTray.hashCode());
   }
}

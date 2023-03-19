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
import java.time.LocalDate;

@Entity
@Table(
   name = "ID_TABLE",
   schema = "public"
)
public class ID {
   @Id
   @Column(
      name = "FC_ID"
   )
   @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "ID_SEQUENCER"
   )
   @SequenceGenerator(
      name = "ID_SEQUENCER",
      sequenceName = "ID_SEQUENCER"
   )
   private Long id;
   @Column(
      name = "FC_ENTERED_DATE",
      nullable = false
   )
   private LocalDate enteredDate;
   @Column(
      name = "FC_CREATION_DATE",
      nullable = false
   )
   private LocalDate creationDate;
   @OneToOne
   private Caution currentCaution;
   @ManyToOne(
      fetch = FetchType.LAZY,
      optional = false
   )
   @JoinColumn(
      name = "FC_ENTERED_BY"
   )
   private User enteredBy;
   @ManyToOne(
      fetch = FetchType.LAZY,
      optional = false
   )
   @JoinColumn(
      name = "FC_BRANCH"
   )
   private Branch branch;
   private Long oldId;
   private TransactionProcess transactionProcess;

   public Long getId() {
      return this.id;
   }

   public LocalDate getEnteredDate() {
      return this.enteredDate;
   }

   public LocalDate getCreationDate() {
      return this.creationDate;
   }

   public Caution getCurrentCaution() {
      return this.currentCaution;
   }

   public User getEnteredBy() {
      return this.enteredBy;
   }

   public Branch getBranch() {
      return this.branch;
   }

   public Long getOldId() {
      return this.oldId;
   }

   public TransactionProcess getTransactionProcess() {
      return this.transactionProcess;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setEnteredDate(final LocalDate enteredDate) {
      this.enteredDate = enteredDate;
   }

   public void setCreationDate(final LocalDate creationDate) {
      this.creationDate = creationDate;
   }

   public void setCurrentCaution(final Caution currentCaution) {
      this.currentCaution = currentCaution;
   }

   public void setEnteredBy(final User enteredBy) {
      this.enteredBy = enteredBy;
   }

   public void setBranch(final Branch branch) {
      this.branch = branch;
   }

   public void setOldId(final Long oldId) {
      this.oldId = oldId;
   }

   public void setTransactionProcess(final TransactionProcess transactionProcess) {
      this.transactionProcess = transactionProcess;
   }

   public String toString() {
      return "ID(id="
         + this.getId()
         + ", enteredDate="
         + String.valueOf(this.getEnteredDate())
         + ", creationDate="
         + String.valueOf(this.getCreationDate())
         + ", currentCaution="
         + String.valueOf(this.getCurrentCaution())
         + ", enteredBy="
         + String.valueOf(this.getEnteredBy())
         + ", branch="
         + String.valueOf(this.getBranch())
         + ", oldId="
         + this.getOldId()
         + ", transactionProcess="
         + String.valueOf(this.getTransactionProcess())
         + ")";
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ID)) {
         return false;
      } else {
         ID other = (ID)o;
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

            Object this$oldId = this.getOldId();
            Object other$oldId = other.getOldId();
            if (this$oldId == null) {
               if (other$oldId != null) {
                  return false;
               }
            } else if (!this$oldId.equals(other$oldId)) {
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

            Object this$creationDate = this.getCreationDate();
            Object other$creationDate = other.getCreationDate();
            if (this$creationDate == null) {
               if (other$creationDate != null) {
                  return false;
               }
            } else if (!this$creationDate.equals(other$creationDate)) {
               return false;
            }

            Object this$currentCaution = this.getCurrentCaution();
            Object other$currentCaution = other.getCurrentCaution();
            if (this$currentCaution == null) {
               if (other$currentCaution != null) {
                  return false;
               }
            } else if (!this$currentCaution.equals(other$currentCaution)) {
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

            Object this$branch = this.getBranch();
            Object other$branch = other.getBranch();
            if (this$branch == null) {
               if (other$branch != null) {
                  return false;
               }
            } else if (!this$branch.equals(other$branch)) {
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

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ID;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $oldId = this.getOldId();
      result = result * 59 + ($oldId == null ? 43 : $oldId.hashCode());
      Object $enteredDate = this.getEnteredDate();
      result = result * 59 + ($enteredDate == null ? 43 : $enteredDate.hashCode());
      Object $creationDate = this.getCreationDate();
      result = result * 59 + ($creationDate == null ? 43 : $creationDate.hashCode());
      Object $currentCaution = this.getCurrentCaution();
      result = result * 59 + ($currentCaution == null ? 43 : $currentCaution.hashCode());
      Object $enteredBy = this.getEnteredBy();
      result = result * 59 + ($enteredBy == null ? 43 : $enteredBy.hashCode());
      Object $branch = this.getBranch();
      result = result * 59 + ($branch == null ? 43 : $branch.hashCode());
      Object $transactionProcess = this.getTransactionProcess();
      return result * 59 + ($transactionProcess == null ? 43 : $transactionProcess.hashCode());
   }
}

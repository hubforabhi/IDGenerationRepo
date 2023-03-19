package com.maintec.fincore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(
   name = "BRANCH"
)
public class Branch {
   @Id
   @Column(
      name = "FC_BR_MASTER_ID"
   )
   @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "BRANCH_SEQUENCER"
   )
   @SequenceGenerator(
      name = "BRANCH_SEQUENCER",
      sequenceName = "BRANCH_SEQUENCER"
   )
   private Long id;

   public Long getId() {
      return this.id;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public String toString() {
      return "Branch(id=" + this.getId() + ")";
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof Branch)) {
         return false;
      } else {
         Branch other = (Branch)o;
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

   protected boolean canEqual(final Object other) {
      return other instanceof Branch;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      return result * 59 + ($id == null ? 43 : $id.hashCode());
   }
}

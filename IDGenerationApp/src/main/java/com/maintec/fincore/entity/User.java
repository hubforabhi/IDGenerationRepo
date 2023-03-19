package com.maintec.fincore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(
   name = "USER_TABLE"
)
public class User {
   @Id
   @Column(
      name = "FC_USER_ID"
   )
   @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "USER_SEQUENCER"
   )
   @SequenceGenerator(
      name = "USER_SEQUENCER",
      sequenceName = "USER_SEQUENCER"
   )
   private Long id;
   @ManyToOne(
      fetch = FetchType.LAZY,
      optional = false
   )
   @JoinColumn(
      name = "FC_BRANCH"
   )
   private Branch branch;

   public Long getId() {
      return this.id;
   }

   public Branch getBranch() {
      return this.branch;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBranch(final Branch branch) {
      this.branch = branch;
   }

   public String toString() {
      return "User(id=" + this.getId() + ", branch=" + String.valueOf(this.getBranch()) + ")";
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof User)) {
         return false;
      } else {
         User other = (User)o;
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

            Object this$branch = this.getBranch();
            Object other$branch = other.getBranch();
            if (this$branch == null) {
               if (other$branch != null) {
                  return false;
               }
            } else if (!this$branch.equals(other$branch)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof User;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $branch = this.getBranch();
      return result * 59 + ($branch == null ? 43 : $branch.hashCode());
   }
}

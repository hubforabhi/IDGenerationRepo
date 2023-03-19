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
import jakarta.persistence.Version;
import java.time.LocalDate;

@Entity
@Table(
   name = "PHOTOGRAPHS",
   schema = "public"
)
public class Images {
   @Id
   @Column(
      name = "FC_IMAGE_ID"
   )
   @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "IMAGE_SEQUENCER"
   )
   @SequenceGenerator(
      name = "IMAGE_SEQUENCER",
      sequenceName = "IMAGE_SEQUENCER"
   )
   private Long id;
   @Column(
      name = "FC_TITLE",
      length = 255
   )
   private String title;
   @Column(
      name = "FC_IMAGE_URL",
      length = 255
   )
   private String imageURL;
   @Column(
      name = "FC_IMAGE_TYPE",
      length = 255
   )
   private String imageType;
   @ManyToOne(
      fetch = FetchType.LAZY
   )
   @JoinColumn(
      name = "FC_ENTERED_BY"
   )
   private User enteredBy;
   @Column(
      name = "FC_ENTERED_DATE"
   )
   private LocalDate enteredDate;
   @Column(
      name = "FC_EXPIRY_DATE"
   )
   private String expiryDate;
   @ManyToOne(
      fetch = FetchType.LAZY
   )
   @JoinColumn(
      name = "BRANCH"
   )
   private Branch branch;
   @ManyToOne(
      fetch = FetchType.LAZY
   )
   @JoinColumn(
      name = "FC_ID_IMAGES"
   )
   private ID parentID;
   @Version
   @Column(
      name = "FC_VERSION_ID",
      nullable = false
   )
   private long versionID;

   public Long getId() {
      return this.id;
   }

   public String getTitle() {
      return this.title;
   }

   public String getImageURL() {
      return this.imageURL;
   }

   public String getImageType() {
      return this.imageType;
   }

   public User getEnteredBy() {
      return this.enteredBy;
   }

   public LocalDate getEnteredDate() {
      return this.enteredDate;
   }

   public String getExpiryDate() {
      return this.expiryDate;
   }

   public Branch getBranch() {
      return this.branch;
   }

   public ID getParentID() {
      return this.parentID;
   }

   public long getVersionID() {
      return this.versionID;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setTitle(final String title) {
      this.title = title;
   }

   public void setImageURL(final String imageURL) {
      this.imageURL = imageURL;
   }

   public void setImageType(final String imageType) {
      this.imageType = imageType;
   }

   public void setEnteredBy(final User enteredBy) {
      this.enteredBy = enteredBy;
   }

   public void setEnteredDate(final LocalDate enteredDate) {
      this.enteredDate = enteredDate;
   }

   public void setExpiryDate(final String expiryDate) {
      this.expiryDate = expiryDate;
   }

   public void setBranch(final Branch branch) {
      this.branch = branch;
   }

   public void setParentID(final ID parentID) {
      this.parentID = parentID;
   }

   public String toString() {
      return "Images(id="
         + this.getId()
         + ", title="
         + this.getTitle()
         + ", imageURL="
         + this.getImageURL()
         + ", imageType="
         + this.getImageType()
         + ", enteredBy="
         + String.valueOf(this.getEnteredBy())
         + ", enteredDate="
         + String.valueOf(this.getEnteredDate())
         + ", expiryDate="
         + this.getExpiryDate()
         + ", branch="
         + String.valueOf(this.getBranch())
         + ", parentID="
         + String.valueOf(this.getParentID())
         + ", versionID="
         + this.getVersionID()
         + ")";
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof Images)) {
         return false;
      } else {
         Images other = (Images)o;
         if (!other.canEqual(this)) {
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

            Object this$title = this.getTitle();
            Object other$title = other.getTitle();
            if (this$title == null) {
               if (other$title != null) {
                  return false;
               }
            } else if (!this$title.equals(other$title)) {
               return false;
            }

            Object this$imageURL = this.getImageURL();
            Object other$imageURL = other.getImageURL();
            if (this$imageURL == null) {
               if (other$imageURL != null) {
                  return false;
               }
            } else if (!this$imageURL.equals(other$imageURL)) {
               return false;
            }

            Object this$imageType = this.getImageType();
            Object other$imageType = other.getImageType();
            if (this$imageType == null) {
               if (other$imageType != null) {
                  return false;
               }
            } else if (!this$imageType.equals(other$imageType)) {
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

            Object this$enteredDate = this.getEnteredDate();
            Object other$enteredDate = other.getEnteredDate();
            if (this$enteredDate == null) {
               if (other$enteredDate != null) {
                  return false;
               }
            } else if (!this$enteredDate.equals(other$enteredDate)) {
               return false;
            }

            Object this$expiryDate = this.getExpiryDate();
            Object other$expiryDate = other.getExpiryDate();
            if (this$expiryDate == null) {
               if (other$expiryDate != null) {
                  return false;
               }
            } else if (!this$expiryDate.equals(other$expiryDate)) {
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

            Object this$parentID = this.getParentID();
            Object other$parentID = other.getParentID();
            if (this$parentID == null) {
               if (other$parentID != null) {
                  return false;
               }
            } else if (!this$parentID.equals(other$parentID)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof Images;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $versionID = this.getVersionID();
      result = result * 59 + (int)($versionID >>> 32 ^ $versionID);
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $title = this.getTitle();
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $imageURL = this.getImageURL();
      result = result * 59 + ($imageURL == null ? 43 : $imageURL.hashCode());
      Object $imageType = this.getImageType();
      result = result * 59 + ($imageType == null ? 43 : $imageType.hashCode());
      Object $enteredBy = this.getEnteredBy();
      result = result * 59 + ($enteredBy == null ? 43 : $enteredBy.hashCode());
      Object $enteredDate = this.getEnteredDate();
      result = result * 59 + ($enteredDate == null ? 43 : $enteredDate.hashCode());
      Object $expiryDate = this.getExpiryDate();
      result = result * 59 + ($expiryDate == null ? 43 : $expiryDate.hashCode());
      Object $branch = this.getBranch();
      result = result * 59 + ($branch == null ? 43 : $branch.hashCode());
      Object $parentID = this.getParentID();
      return result * 59 + ($parentID == null ? 43 : $parentID.hashCode());
   }
}

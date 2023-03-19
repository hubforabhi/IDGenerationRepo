package com.maintec.fincore.model;

public class ViewSignatureResponseModel {
   private String searchIdNo;
   private String name;
   private String type;
   private String title;

   public String getSearchIdNo() {
      return this.searchIdNo;
   }

   public String getName() {
      return this.name;
   }

   public String getType() {
      return this.type;
   }

   public String getTitle() {
      return this.title;
   }

   public void setSearchIdNo(final String searchIdNo) {
      this.searchIdNo = searchIdNo;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setType(final String type) {
      this.type = type;
   }

   public void setTitle(final String title) {
      this.title = title;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ViewSignatureResponseModel)) {
         return false;
      } else {
         ViewSignatureResponseModel other = (ViewSignatureResponseModel)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$searchIdNo = this.getSearchIdNo();
            Object other$searchIdNo = other.getSearchIdNo();
            if (this$searchIdNo == null) {
               if (other$searchIdNo != null) {
                  return false;
               }
            } else if (!this$searchIdNo.equals(other$searchIdNo)) {
               return false;
            }

            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null) {
               if (other$name != null) {
                  return false;
               }
            } else if (!this$name.equals(other$name)) {
               return false;
            }

            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null) {
               if (other$type != null) {
                  return false;
               }
            } else if (!this$type.equals(other$type)) {
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

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ViewSignatureResponseModel;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $searchIdNo = this.getSearchIdNo();
      result = result * 59 + ($searchIdNo == null ? 43 : $searchIdNo.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $title = this.getTitle();
      return result * 59 + ($title == null ? 43 : $title.hashCode());
   }

   public String toString() {
      return "ViewSignatureResponseModel(searchIdNo="
         + this.getSearchIdNo()
         + ", name="
         + this.getName()
         + ", type="
         + this.getType()
         + ", title="
         + this.getTitle()
         + ")";
   }
}

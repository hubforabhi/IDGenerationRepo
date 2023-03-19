package com.maintec.fincore.util;

public enum ImageType {
   PHOTO("Photo"),
   SIGNATURE("Signature"),
   THUMB_IMPRESSION("Thumb Impression");

   private String value;

   private ImageType(String value) {
      this.value = value;
   }

   public String getValue() {
      return this.value;
   }

   public static String getValue(String ordinal) {
      switch(ordinal) {
         case "1":
            return PHOTO.value;
         case "2":
            return SIGNATURE.value;
         case "3":
            return THUMB_IMPRESSION.value;
         default:
            return PHOTO.value;
      }
   }
}

package com.maintec.fincore;

import java.time.format.DateTimeFormatter;

public interface IDGenerationConstants {
   String SUCCESS = "SUCCESS";
   String FAILURE = "FAILURE";

   String FILE_PATH_SEPARATOR = System.getProperty("file.separator");

   DateTimeFormatter BUSINESS_DATE_FORMATTER = DateTimeFormatter.ISO_DATE;

   DateTimeFormatter BUSINESS_DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;
}

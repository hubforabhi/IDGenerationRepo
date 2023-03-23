package com.maintec.fincore.util;

public enum ResponseStatus {
    OK("ok"),
    USER_NOT_FOUND("User not found"),
    PARENT_ID_NOT_FOUND("Parent ID not found"),

    CAUTION_NOT_FOUND("Caution not found"),

    SIGNATURE_NOT_FOUND("Signature Image not found"),

    SIGNATURE_IMAGE_TYPE_NOT_SUPPORTED("Signature image type not supported"),
    NOT_ABLE_TO_SAVE_FILE_ON_LOCAL("Not able to save Signature Image");

    private String message;

    ResponseStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}

package com.tr.domain;

public enum ShowErrorEnum {
    EMPTY_SHOE(10001, "No Shoe Data"),
    EMPTY_DRESS(20001, "No Dress Data");
    private int errorCode;
    private String errorMessage;

    ShowErrorEnum(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

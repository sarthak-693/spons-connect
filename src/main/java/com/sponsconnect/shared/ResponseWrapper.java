package com.sponsconnect.shared;

public class ResponseWrapper {

    private boolean success;
    private String message;

    public ResponseWrapper() {

    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseWrapper(boolean success, String message) {
        this.success = success;
        this.message = message;
    }


}


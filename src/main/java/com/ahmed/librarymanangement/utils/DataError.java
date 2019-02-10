package com.ahmed.librarymanangement.utils;

public class DataError {

    private String id;
    private String code;
    private String message;

    public DataError() {
        super();
    }

    public DataError(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public DataError(String id, String code, String message) {
        super();
        this.id = id;
        this.code = code;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Error [code=" + code + ", message=" + message + "]";
    }
}


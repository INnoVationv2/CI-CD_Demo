package edu.ecnu.smart.agriculture.model;

public enum ErrorCode {
    Success(1),
    Fail(-1);
    private final int code;
    ErrorCode(int code){this.code = code;}

    public int getCode(){return code;}
}

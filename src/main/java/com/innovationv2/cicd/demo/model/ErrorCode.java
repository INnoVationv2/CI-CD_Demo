package com.innovationv2.cicd.demo.model;

import lombok.Getter;

@Getter
public enum ErrorCode {
    Success(1),
    Fail(-1);
    private final int code;

    ErrorCode(int code) {
        this.code = code;
    }
}

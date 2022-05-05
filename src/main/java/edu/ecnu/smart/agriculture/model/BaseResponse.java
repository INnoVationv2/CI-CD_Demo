package edu.ecnu.smart.agriculture.model;

import lombok.Data;

@Data
public class BaseResponse {
    private ErrorCode status;
    private String message;
    private Object data;

    public static BaseResponse SuccessResponse(){
        BaseResponse response = new BaseResponse();
        response.setStatus(ErrorCode.Success);
        return response;
    }

    public static BaseResponse SuccessResponse(String msg){
        BaseResponse response = new BaseResponse();
        response.setStatus(ErrorCode.Success);
        response.setMessage(msg);
        return response;
    }

    public static BaseResponse FailResponse(){
        BaseResponse response = new BaseResponse();
        response.setStatus(ErrorCode.Fail);
        return response;
    }

    public static BaseResponse FailResponse(String msg){
        BaseResponse response = new BaseResponse();
        response.setStatus(ErrorCode.Fail);
        response.setMessage(msg);
        return response;
    }

}

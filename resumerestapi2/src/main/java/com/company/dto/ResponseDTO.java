package com.company.dto;

public class ResponseDTO {
    private Integer errorCode;
    private String errorMessage;
    private String successMessage;
    private Object obj;

    private ResponseDTO() {
    }

    public static ResponseDTO of(Object obj){
        ResponseDTO rsp=new ResponseDTO();
        rsp.setObj(obj);
        return rsp;
    }
    public static ResponseDTO of(Object obj,String successMessage){
        ResponseDTO rsp=new ResponseDTO();
        rsp.setObj(obj);
        rsp.setSuccessMessage(successMessage);
        return rsp;
    }
    public static ResponseDTO of(Object obj,Integer errorCode,String errorMessage){
        ResponseDTO rsp=new ResponseDTO();
        rsp.setObj(obj);
        rsp.setErrorCode(errorCode);
        rsp.setErrorMessage(errorMessage);
        return rsp;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}

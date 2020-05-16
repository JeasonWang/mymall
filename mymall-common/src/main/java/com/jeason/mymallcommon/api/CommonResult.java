package com.jeason.mymallcommon.api;

public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    public static <T> CommonResult<T> success(T data){
        return new CommonResult<>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }

    public static <T> CommonResult<T> failed(ResultCode resultCode) {
        return new CommonResult<T>(resultCode.getCode(), resultCode.getMessage(), null);
    }
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    public CommonResult(long code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

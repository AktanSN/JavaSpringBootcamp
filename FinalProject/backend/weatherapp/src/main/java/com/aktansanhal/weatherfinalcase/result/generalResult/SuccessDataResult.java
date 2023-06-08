package com.aktansanhal.weatherfinalcase.result.generalResult;

public class SuccessDataResult<T>  extends DataResult<T>{
    public SuccessDataResult(String message, T data) {
        super(true, message, data);
    }


}

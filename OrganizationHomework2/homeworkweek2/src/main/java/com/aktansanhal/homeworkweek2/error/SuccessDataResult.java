package com.aktansanhal.homeworkweek2.error;

public class SuccessDataResult<T>  extends DataResult<T>{
    public SuccessDataResult(String message, T data) {
        super(true, message, data);
    }


}

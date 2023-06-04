package com.aktansanhal.homeworkweek2.error;

public class ErrorDataResult<T>  extends DataResult<T>{
    public ErrorDataResult(String message, T data) {
        super(false, message, data);
    }

    public ErrorDataResult(String message) {
        super(false, message, null);
    }


}

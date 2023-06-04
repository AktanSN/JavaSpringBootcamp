package com.aktansanhal.homeworkweek2.error;

public class DataResult<T> extends Result{

    private T data;

    public DataResult(boolean isSuccess, String message, T data) {
        super(isSuccess, message);
        this.data = data;
    }

    public T getData() {
        return data;
    }
}

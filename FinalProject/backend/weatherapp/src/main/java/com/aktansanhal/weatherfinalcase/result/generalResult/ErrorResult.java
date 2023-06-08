package com.aktansanhal.weatherfinalcase.result.generalResult;

public class ErrorResult extends Result{
    public ErrorResult(String message) {
        super(false, message);
    }

}

package com.aktansanhal.homeworkweek2.exception.globalExceptionHandler;


import com.aktansanhal.homeworkweek2.error.Result;
import com.aktansanhal.homeworkweek2.exception.exceptions.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MyException.class})
    public ResponseEntity<Result> notfound(MyException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Result(false,exception.getMessage()));
    }


}

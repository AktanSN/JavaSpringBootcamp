package com.aktansanhal.weatherfinalcase.exception.globalExceptionHandler;



import com.aktansanhal.weatherfinalcase.kafka.ProducerService;
import com.aktansanhal.weatherfinalcase.result.generalResult.Result;
import com.aktansanhal.weatherfinalcase.exception.exceptions.MyException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final ProducerService producerService;

    @ExceptionHandler({MyException.class})
    public ResponseEntity<Result> notfound(MyException exception){
        String record = String.format("[%s:%d] Error occurred : %s", getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getLineNumber(), exception.getMessage());
        producerService.sendMessage(record,"warn");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Result(false,exception.getMessage()));
    }



}

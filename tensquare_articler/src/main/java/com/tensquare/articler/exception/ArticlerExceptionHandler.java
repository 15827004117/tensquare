package com.tensquare.articler.exception;
import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理类
 */
@RestControllerAdvice
public class ArticlerExceptionHandler {
	
    @ExceptionHandler(value = Exception.class)
    public Result error(Exception e){
        e.printStackTrace();        
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}

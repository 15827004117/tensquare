package com.tensquare.qa.exception;
import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 统一异常处理类
 */
@RestControllerAdvice
public class QaExceptionHandler {
	
    @ExceptionHandler(value = Exception.class)
    public Result error(Exception e){
        e.printStackTrace();        
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}

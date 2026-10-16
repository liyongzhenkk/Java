package com.lyzstack.springmvc.exception;


import com.lyzstack.springmvc.entities.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class HandleException {

    @ExceptionHandler(NullPointerException.class)
    public Result handlerNullPointerException(NullPointerException e){
        e.printStackTrace();
        return Result.failed("空指针异常");
    }

    @ExceptionHandler(IOException.class)
    public Result handlerIOException(IOException e){
        e.printStackTrace();
        return Result.failed("IO异常");
    }

    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e){
        e.printStackTrace();
        return Result.failed("System error");
    }
}

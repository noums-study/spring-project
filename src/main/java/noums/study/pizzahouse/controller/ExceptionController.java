package noums.study.pizzahouse.controller;

import noums.study.pizzahouse.exception.CustomException;
import noums.study.pizzahouse.interceptor.ExceptionInterceptor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(CustomException.class)
    public String  customExceptionHandler(){
        System.out.println(">>>>>> customExceptionHandler ");
        return "error/exception";
    }

}

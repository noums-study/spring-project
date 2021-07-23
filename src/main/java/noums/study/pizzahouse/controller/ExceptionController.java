package noums.study.pizzahouse.controller;

import noums.study.pizzahouse.exception.CustomException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(CustomException.class)
    public String  customExceptionHandler(){
        System.out.println(">>>>>> customExceptionHandler ");
        return "error/exception";
    }

}

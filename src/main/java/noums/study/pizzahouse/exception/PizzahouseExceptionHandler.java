package noums.study.pizzahouse.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@ControllerAdvice
public class PizzahouseExceptionHandler {

    @ExceptionHandler(PizzahouseException.class)
    public void handlingPizzahouseException() {
      log.error("error handling");
    }


}

package noums.study.pizzahouse.exception;

public class PizzahouseException extends RuntimeException{

    private ErrorCode errorCode;

    public PizzahouseException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }


}

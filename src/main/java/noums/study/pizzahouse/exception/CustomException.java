package noums.study.pizzahouse.exception;

public class CustomException extends RuntimeException{

    public  CustomException(String msg){
        System.out.println(">>>>>> CustomException");
    }
}

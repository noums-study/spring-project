package noums.study.pizzahouse.exception;

public enum ErrorCode {

    INVALID_MENU("존재하지 않는 메뉴입니다."),
    INVALID_PAYMENT("존재하지 않는 결제 방법입니다.")
    ;

    private String msg;

    ErrorCode(String msg) {
        this.msg = msg;
    }

}

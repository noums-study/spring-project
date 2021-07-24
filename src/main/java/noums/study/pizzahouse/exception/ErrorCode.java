package noums.study.pizzahouse.exception;

public enum ErrorCode {

    INVALID_MENU("존재하지 않는 메뉴입니다.", 100),
    INVALID_PAYMENT("존재하지 않는 결제 방법입니다.", 101)
    ;

    private String msg;
    private int code;

    ErrorCode(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

}

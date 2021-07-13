package noums.study.pizzahouse.aop;

import lombok.extern.slf4j.Slf4j;
import noums.study.pizzahouse.bean.OrderRequest;
import noums.study.pizzahouse.enums.Menu;
import noums.study.pizzahouse.exception.ErrorCode;
import noums.study.pizzahouse.exception.PizzahouseException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MenuCheckingAspect {

    @Around("execution(public * noums.study.pizzahouse.controller.*..*(..))")
    public Object checkingMenu(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
            Object[] args = proceedingJoinPoint.getArgs();
            OrderRequest orderRequest = (OrderRequest) args[0];
            Menu menu = orderRequest.getMenu();
            System.out.println(menu);
            if (menu == Menu.NONE) {
                log.error("존재하지 않는 메뉴입니다.");
                throw new PizzahouseException(ErrorCode.INVALID_MENU);
            }
            result = proceedingJoinPoint.proceed();
        return result;
    }


}

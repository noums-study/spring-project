package noums.study.pizzahouse.aspect;

import net.bytebuddy.implementation.bytecode.Throw;
import noums.study.pizzahouse.bean.OrderRequest;
import noums.study.pizzahouse.enums.FoodMenu;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MenuCheckAspect {

    @Around("execution(public * noums.study.pizzahouse.controller.*..*(..))")
    public Object menuCheck(ProceedingJoinPoint joinPoint) throws Throwable {

        Object proceed = null;
        System.out.println(">>>> MenuCheckAspect start ...");

        try {
            Object[] args = joinPoint.getArgs();
            OrderRequest orderRequest = (OrderRequest) args[0];
            FoodMenu menu = orderRequest.getMenu();
            System.out.println(menu);
            if (menu == null) {
                System.out.println("판매중인 메뉴가 아닙니다.");
                throw new Exception("판매중인 메뉴가 아닙니다.");
            }
            proceed = joinPoint.proceed();

        } catch (Exception e) {

        }

        System.out.println(">>>> MenuCheckAspect end ...");
        return proceed;
    }
}

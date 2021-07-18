package noums.study.pizzahouse.aspect;

import net.bytebuddy.implementation.bytecode.Throw;
import noums.study.pizzahouse.bean.OrderRequest;
import noums.study.pizzahouse.controller.ExceptionController;
import noums.study.pizzahouse.enums.FoodMenu;
import noums.study.pizzahouse.exception.CustomException;
import org.apache.commons.lang3.ObjectUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MenuCheckAspect {

    @Around("execution(public * noums.study.pizzahouse.controller.OrderController.*(..))")
    public Object menuCheck(ProceedingJoinPoint joinPoint) throws Throwable {

        Object proceed = null;
        System.out.println(">>>> MenuCheckAspect start ...");

//        try {
            Object[] args = joinPoint.getArgs();
            System.out.println(">>>>>> arg.length ::: "+args.length);
            OrderRequest orderRequest = (OrderRequest) args[0];
            FoodMenu menu = orderRequest.getMenu();
            System.out.println(menu);
            if (menu == null) {
                throw new CustomException("판매중인 메뉴가 아닙니다.");
            } else {
                proceed = joinPoint.proceed();
            }
//        } catch (Exception e) {
            //throwable.printStackTrace();
//        }

        System.out.println(">>>> MenuCheckAspect end ...");
        return proceed;
    }
}

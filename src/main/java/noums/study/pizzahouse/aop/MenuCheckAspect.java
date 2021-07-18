package noums.study.pizzahouse.aop;

import noums.study.pizzahouse.bean.OrderRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MenuCheckAspect {

    @Around("execution(* noums.study.pizzahouse.service.OrderService.order(..))")
    public Object isValidMenu(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("##### [AOP] MenuCheckAspect isValidMenu");
        Object[] args = joinPoint.getArgs();
        OrderRequest req = (OrderRequest) args[0];
        if (req.getMenu() == null) {
            throw new RuntimeException();
        }
        return joinPoint.proceed();
    }
}

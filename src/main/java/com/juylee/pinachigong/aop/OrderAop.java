package com.juylee.pinachigong.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.juylee.pinachigong.config.Constant;
import com.juylee.pinachigong.dto.OrderRequest;
import com.juylee.pinachigong.enums.Menu;
import com.juylee.pinachigong.exception.NoMenuException;

@Aspect
@Component
public class OrderAop {
	
	@Before("execution(* com.juylee.pinachigong.service.OrderService.*(..))")
	public void checkInvalidMenu(JoinPoint joinPoint) {
		OrderRequest orderRequest = (OrderRequest)joinPoint.getArgs()[0];
		
		for(Menu menu : Menu.values()) {
			if(menu.equals(orderRequest.getMenu())) {
				return;
			}
		}
		
		throw new NoMenuException(Constant.NO_MENU_EXCEPTION_MESSAGE);
	}
}

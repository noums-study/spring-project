package com.juylee.pinachigong.food.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.juylee.pinachigong.enums.Menu;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class KitchenManager {
	private final ApplicationContext applicationContext;
	
	private Map<String, FoodManager> managers = new HashMap<>();
	
	// 생성자 대신 Bean을 이용해서 초기화할 때 사용하는 어노테이션, Bean은 여러 번 인스턴스화 될 수 있지만
	// @PostConstruct는 생명 주기 중 딱 한 번만 수행
	@PostConstruct 
	public void init() {
		Collection<FoodManager> managerCollction 
			= applicationContext.getBeansOfType(FoodManager.class).values();
		
		for(FoodManager manager : managerCollction) {
			managers.put(manager.getPart(), manager);
		}
	}
	
	// 음식 만들기
	public String makeFood(Menu menu) {
		FoodManager manager = managers.get(menu.getPart());
		return manager.makeFood(menu);
	}
}

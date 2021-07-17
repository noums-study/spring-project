package com.juylee.pinachigong.food.maker.chicken;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.juylee.pinachigong.enums.Menu;
import com.juylee.pinachigong.food.manager.FoodManager;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ChickenManager implements FoodManager{
	private final ApplicationContext applicationContext;
	
	private Map<Menu, ChickenMaker> makers = new HashMap<>();
	
	private String partName = "CHICKEN";
	
	@PostConstruct
	public void init() {
		Collection<ChickenMaker> makersCollection 
										= applicationContext.getBeansOfType(ChickenMaker.class).values();
		
		for(ChickenMaker maker : makersCollection) {
			makers.put(maker.getMenu(), maker);
		}
	}

	@Override
	public String getPart() {
		return partName;
	}

	@Override
	public String makeFood(Menu menu) {
		ChickenMaker maker = makers.get(menu);
		maker.prepare();
		maker.frying();
		return partName;
	}

	@Override
	public int caculationPrice(Menu menu, int count) {
		return menu.getPrice() * count;
	}
}

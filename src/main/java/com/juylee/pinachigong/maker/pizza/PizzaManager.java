package com.juylee.pinachigong.maker.pizza;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.juylee.pinachigong.enums.Menu;
import com.juylee.pinachigong.manager.FoodManager;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PizzaManager implements FoodManager{
	private final ApplicationContext applicationContext;
	
	private Map<Menu, PizzaMaker> makers = new HashMap<>();
	
	private String partName = "PIZZA";
	
	@PostConstruct
	public void init() {
		Collection<PizzaMaker> makersCollction 
								= applicationContext.getBeansOfType(PizzaMaker.class).values();
		
		for(PizzaMaker maker : makersCollction) {
			makers.put(maker.getMenu(), maker);
		}
	}

	@Override
	public String getPart() {
		return partName;
	}

	@Override
	public String makeFood(Menu menu) {
		PizzaMaker maker = makers.get(menu);
        maker.prepare();
        maker.makeDough();
        maker.bake();
		return partName;
	}

	@Override
	public int caculationPrice(Menu menu, int count) {
		return menu.getPrice() * count;
	}
}

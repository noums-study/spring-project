package com.juylee.pinachigong.food.maker.pizza;

import org.springframework.stereotype.Component;

import com.juylee.pinachigong.enums.Menu;

@Component
public class CheesePizzaMaker implements PizzaMaker{

	@Override
	public Menu getMenu() {
		return Menu.CHEESE_PIZZA;
	}

	@Override
	public String prepare() {
		return "치즈 피자 준비";
	}

	@Override
	public String bake() {
		return "치즈 피자 굽기";
	}
}

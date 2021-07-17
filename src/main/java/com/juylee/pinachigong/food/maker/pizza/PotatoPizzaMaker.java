package com.juylee.pinachigong.food.maker.pizza;

import org.springframework.stereotype.Component;

import com.juylee.pinachigong.enums.Menu;

@Component
public class PotatoPizzaMaker implements PizzaMaker{

	@Override
	public Menu getMenu() {
		return Menu.POTATO_PIZZA;
	}

	@Override
	public String prepare() {
		return "포테이토 피자 준비";
	}

	@Override
	public String bake() {
		return "포테이토 피자 굽기";
	}
}

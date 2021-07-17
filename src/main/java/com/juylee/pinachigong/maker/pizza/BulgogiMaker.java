package com.juylee.pinachigong.maker.pizza;

import org.springframework.stereotype.Component;

import com.juylee.pinachigong.enums.Menu;

@Component
public class BulgogiMaker implements PizzaMaker{

	@Override
	public Menu getMenu() {
		return Menu.BULGOGI_PIZZA;
	}

	@Override
	public String prepare() {
		return "불고기 피자 준비";
	}

	@Override
	public String bake() {
		return "불고기 피자 굽기";
	}
	
}

package com.juylee.pinachigong.maker.chicken;

import org.springframework.stereotype.Component;

import com.juylee.pinachigong.enums.Menu;

@Component
public class FriedChickenMaker implements ChickenMaker{

	@Override
	public Menu getMenu() {
		return Menu.FRIED_CHICKEN;
	}

	@Override
	public String prepare() {
		return "후라이드 치킨 준비";
	}

	@Override
	public String frying() {
		return "후라이드 치킨 튀김";
	}
	
}

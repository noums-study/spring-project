package com.juylee.pinachigong.maker.chicken;

import org.springframework.stereotype.Component;

import com.juylee.pinachigong.enums.Menu;

@Component
public class GarlicChickenMaker implements ChickenMaker{

	@Override
	public Menu getMenu() {
		return Menu.GARLIC_CHICKEN;
	}

	@Override
	public String prepare() {
		return "갈릭 치킨 준비";
	}

	@Override
	public String frying() {
		return "갈릭 치킨 튀김";
	}
	
}

package com.juylee.pinachigong.food.maker.pizza;

import com.juylee.pinachigong.enums.Menu;

public interface PizzaMaker {
	// default method는 인스턴스 안에서 기본 기능을 구현할 수 있으며 인스턴스를 상속받은 곳에서는 오버라이딩이 불가하다.
	default String makeDough() {
		return "피자 도우 생성";
	}
	
	public Menu getMenu();

	public String prepare();

	public String bake();
}

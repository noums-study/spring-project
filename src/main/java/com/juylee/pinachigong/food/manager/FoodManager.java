package com.juylee.pinachigong.food.manager;

import com.juylee.pinachigong.enums.Menu;

public interface FoodManager {
	public String getPart();
	public String makeFood(Menu menu);
	public int caculationPrice(Menu menu, int count);
}

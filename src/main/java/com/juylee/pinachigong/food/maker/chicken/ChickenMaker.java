package com.juylee.pinachigong.food.maker.chicken;

import com.juylee.pinachigong.enums.Menu;

public interface ChickenMaker {
	public Menu getMenu();

    public String prepare();

    public String frying();
}

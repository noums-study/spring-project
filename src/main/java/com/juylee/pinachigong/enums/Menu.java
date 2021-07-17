package com.juylee.pinachigong.enums;

import lombok.Getter;

@Getter
public enum Menu {
	BULGOGI_PIZZA(10000, "PIZZA"),
    CHEESE_PIZZA(8000, "PIZZA"),
    POTATO_PIZZA(11000, "PIZZA"),

    GARLIC_CHICKEN(15000, "CHICKEN"),
    FRIED_CHICKEN(12000, "CHICKEN"),

    NONE(0, "");
    ;
    
    private int price;
    private String part;
    private String menuName;
    
    Menu(int price, String part) {
    	this.price = price;
    	this.part = part;
    	this.menuName = this.name();
    }
    
}

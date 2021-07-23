package com.juylee.pinachigong.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum Menu {
	BULGOGI_PIZZA(10000, "PIZZA"),
    CHEESE_PIZZA(8000, "PIZZA"),
    POTATO_PIZZA(11000, "PIZZA"),

    GARLIC_CHICKEN(15000, "CHICKEN"),
    FRIED_CHICKEN(12000, "CHICKEN"),

//    NONE(0, "");
    ;
    
    private int price;
    private String part;
    private String menuName;
    
    @JsonCreator
    public static Menu getEnumFromValue(String value) {
    	// for 문으로 enum 값 체크
//    	for (Menu menu : values()) {
//            if (menu.name().equals(value)) {
//                return menu;
//            }
//        }
//    	return null;
    	
    	// enum의 valueOf를 이용해서 값 체크
    	try {
        	return Menu.valueOf(value.toUpperCase());
    	} catch (Exception e) {
    		return null;
//    		throw new NoMenuException(Constant.NO_MENU_EXCEPTION_MESSAGE);
    		// 여기서 메뉴 체크를 해도 되지만 여기서 메뉴 체크를 할 경우 IllegalArgumentException의 에러 메시지까지
    		// NoMenuException의 super(message)에 들어가 ReseponseBodyUtil에서 만드는
    		// Exception 메시지가 더러워진다.
    		// TODO: NoMenuException의 에러 메시지만 들어가게 하는 방법은 없을까?
    	}
    }
    
    Menu(int price, String part) {
    	this.price = price;
    	this.part = part;
    	this.menuName = this.name();
    }
    
}

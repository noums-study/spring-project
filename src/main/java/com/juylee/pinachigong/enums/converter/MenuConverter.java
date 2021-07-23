package com.juylee.pinachigong.enums.converter;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.juylee.pinachigong.enums.Menu;

@Converter(autoApply = true)
public class MenuConverter implements AttributeConverter<Menu, String>{

	@Override
	public String convertToDatabaseColumn(Menu menu) {
		if(menu == null) {
			 return null;
		}
		return menu.getMenuName();
	}

	@Override
	public Menu convertToEntityAttribute(String menuName) {
		if(menuName == null) {
			return null;
		}
		
		return Stream.of(Menu.values())
				.filter(m -> m.getMenuName().equals(menuName))
				.findFirst()
				.orElse(null);
	}

}

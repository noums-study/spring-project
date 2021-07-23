package com.juylee.pinachigong.dto;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MenuRequest {
	@NotNull
	private int id;
	
	private String menuName;
	
	private String partName;
}

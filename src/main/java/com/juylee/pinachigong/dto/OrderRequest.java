package com.juylee.pinachigong.dto;

import com.juylee.pinachigong.enums.Menu;
import com.juylee.pinachigong.enums.PayMethod;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderRequest {
	@NotNull
	private Menu menu;
	
	@NotNull
	private int count;
	
	@NotNull
	private PayMethod payMethod;
}

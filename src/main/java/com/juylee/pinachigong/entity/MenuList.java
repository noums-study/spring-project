package com.juylee.pinachigong.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "menu_list")
@Getter
@NoArgsConstructor
public class MenuList {
	@Id
	@Column(name = "id")
	private int id;
	
	
	@Column(name = "menu_name")
	private String menuName;
	
	@Column(name = "part_name")
	private String partName;
	
	public MenuList(int id) {
		this.id = id;
	}
	
	public MenuList(int id, String menuName, String partName) {
		this.id = id;
		this.menuName = menuName;
		this.partName = partName;
	}
	
	public void updateMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	public void updatePartName(String partName) {
		this.partName = partName;
	}
}

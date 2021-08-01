package com.juylee.pinachigong.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juylee.pinachigong.dto.MenuRequest;
import com.juylee.pinachigong.entity.MenuList;
import com.juylee.pinachigong.enums.Menu;
import com.juylee.pinachigong.repository.MenuListRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MenuService {
	private final MenuListRepository menuListRepository;
	
	// 메뉴 리스트 가져오기
	@Transactional(readOnly = true)
	@Cacheable(value = "menu")
	public List<MenuList> getMenuList() {
		return this.menuListRepository.findAll();
	}
	
	// 메뉴 하나 가져오기
	@Transactional(readOnly = true)
	@Cacheable(value = "menu", key = "#id")
	public MenuList getOneMenu(int id) {
		return this.menuListRepository.findById(id).orElseThrow();
	}
	
	// 메뉴 업데이트 하기
	@CachePut(value = "menu", key = "#menuRequest.id")
	public MenuList updateMenu(MenuRequest menuRequest) {
		MenuList menuList = this.menuListRepository.findById(menuRequest.getId())
							.orElse(new MenuList((int)this.menuListRepository.count()));
		
		if(menuRequest.getMenuName() != null) {
			menuList.updateMenuName(menuRequest.getMenuName());			
		}
		
		if(menuRequest.getPartName() != null) {
			menuList.updatePartName(menuRequest.getPartName());			
		}
		
		this.menuListRepository.save(menuList);
		
		return menuList;
	}
	
	// 모든 메뉴 업데이트
	@CachePut(value = "menu", key = "'SimpleKey []'")
	public List<MenuList> updateAllMenu(){
		return this.menuListRepository.findAll();
	}
	
	// 메뉴 하나 삭제하기
	@CacheEvict(value = "menu", key = "#id")
	public void deleteOneMenu(int id) {
		this.menuListRepository.deleteById(id);
	}
	
	// 메뉴 모두 삭제하기
	@CacheEvict(value = "menu", allEntries = true)
	public void deleteAllMenu() {
		this.menuListRepository.deleteAllInBatch();
	}
	
	// 메뉴 처음에 다 넣기
	public void initMenu() {
		this.deleteAllMenu();
		
		List<MenuList> menuLists = new ArrayList<MenuList>();
		
		for(Menu menu: Menu.values()) {
			MenuList menuList = new MenuList(menu.ordinal(), menu.getMenuName(), menu.getPart());
			menuLists.add(menuList);
		}
		
		this.menuListRepository.saveAllAndFlush(menuLists);
	}
}

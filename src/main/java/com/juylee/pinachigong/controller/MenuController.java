package com.juylee.pinachigong.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juylee.pinachigong.dto.MenuRequest;
import com.juylee.pinachigong.service.MenuService;
import com.juylee.pinachigong.util.ResponseBodyUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {
	private Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);
	
	private final MenuService menuService;
	
	@GetMapping("/init")
	public ResponseEntity<Map<String, Object>> initMenuList() throws Exception {
		this.menuService.initMenu();
		return ResponseEntity.ok(ResponseBodyUtil.createResponseData("메뉴 리스트 초기화 완료"));
	}
	
	@GetMapping("/get/list")
	public ResponseEntity<Map<String, Object>> getMenuList() throws Exception {
		logger.info("==> /menu/get/list");
		return ResponseEntity.ok(ResponseBodyUtil.createResponseData(this.menuService.getMenuList()));
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Map<String, Object>> getMenuList(@PathVariable int id) throws Exception {
		logger.info("==> /menu/get/" + id);
		return ResponseEntity.ok(ResponseBodyUtil.createResponseData(this.menuService.getOneMenu(id)));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Map<String, Object>> updateMenu(@Validated @RequestBody MenuRequest menuRequest) throws Exception {
		logger.info("==> /menu/update");
		this.menuService.updateMenu(menuRequest);
		return ResponseEntity.ok(ResponseBodyUtil.createResponseData(
									String.format("%d번 메뉴 업데이트 완료", menuRequest.getId())));
	}
	
	@GetMapping("/update/all")
	public ResponseEntity<Map<String, Object>> updateAllMenu() throws Exception {
		logger.info("==> /menu/update/all");
		this.menuService.updateAllMenu();
		return ResponseEntity.ok(ResponseBodyUtil.createResponseData("모든 메뉴 업데이트 완료"));
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<Map<String, Object>> deleteMenu(@PathVariable int id) throws Exception {
		this.menuService.deleteOneMenu(id);
		return ResponseEntity.ok(ResponseBodyUtil.createResponseData(
				String.format("%d번 메뉴 삭제 완료", id)));
	}
	
	@GetMapping("/delete/all")
	public ResponseEntity<Map<String, Object>> deleteAllMenu() throws Exception {
		this.menuService.deleteAllMenu();
		return ResponseEntity.ok(ResponseBodyUtil.createResponseData("모든 메뉴 삭제 완료"));
	}
	
}

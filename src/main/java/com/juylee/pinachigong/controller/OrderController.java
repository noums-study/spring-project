package com.juylee.pinachigong.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juylee.pinachigong.dto.OrderRequest;
import com.juylee.pinachigong.service.OrderService;
import com.juylee.pinachigong.util.ResponseBodyUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
	final private OrderService orderService;

	@PostMapping(value = "/food")
	public ResponseEntity<Map<String, Object>> order(@Validated @RequestBody OrderRequest orderRequest) throws Exception {
		this.orderService.order(orderRequest);
		return ResponseEntity.ok(ResponseBodyUtil.createResponseData("주문 성공 완료"));
	}
}

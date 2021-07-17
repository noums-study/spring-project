package com.juylee.pinachigong.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.juylee.pinachigong.dto.OrderRequest;
import com.juylee.pinachigong.entity.Order;
import com.juylee.pinachigong.food.manager.KitchenManager;
import com.juylee.pinachigong.repository.OrderListRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
	private final KitchenManager kitchenManager;
	private final PayService payService;
	
	private final OrderListRepository orderListRepository;
	
	public void order(OrderRequest orderRequest) throws Exception {
		// 주문 접수
		Order order = new Order(
									orderRequest.getMenu()
									, orderRequest.getPart()
									, orderRequest.getCount()
								);
		
		order = this.orderListRepository.save(order);		
		
		kitchenManager.makeFood(order.getMenu());
		
		this.payService.pay(order, orderRequest.getPayMethod());
	}
}

package com.juylee.pinachigong.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.juylee.pinachigong.entity.Order;
import com.juylee.pinachigong.enums.Menu;
import com.juylee.pinachigong.enums.PayMethod;
import com.juylee.pinachigong.repository.OrderListRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class PayService {
	private final OrderListRepository orderListRepository;
	
	public void pay(Order order, PayMethod pameMethod) {
		int totalPrice = 0;
		Menu menu = order.getMenu();
		totalPrice = menu.getPrice() * order.getCount();
		System.out.println(String.format("%s %d개 %d원 %s(으)로 결제 완료"
								, menu.getMenuName(), order.getCount()
								, totalPrice, pameMethod.name()));
		
		order.pay(totalPrice, pameMethod);
		
		this.orderListRepository.save(order);
	}
}

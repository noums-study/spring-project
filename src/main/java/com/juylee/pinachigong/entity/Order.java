package com.juylee.pinachigong.entity;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.juylee.pinachigong.enums.Menu;
import com.juylee.pinachigong.enums.PayMethod;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "order_list")
@Getter
@SequenceGenerator(
		name = "order_list_id_seq_gen",
		sequenceName = "order_list_id_seq",
		initialValue = 1,
		allocationSize = 1
)
@NoArgsConstructor
public class Order {
	@Id
	@Column(name = "id")
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "order_list_id_seq_gen"
	)
	private int id;
	
	@Column(name = "part")
	private String part;
	
	// enum 상수 값이 아닌 text 값 그대로 저장하기 위한 annotation
	@Enumerated(value = EnumType.STRING)
	@Column(name = "menu")
	private Menu menu;
	
	@Column(name = "count")
	private int count;
	
	@Column(name = "order_date")
	private ZonedDateTime orderDate;
	
	@Column(name = "total_price")
	private int totalPrice;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "pay_method")
	private PayMethod payMethod;
	
	
	public Order(Menu menu, int count) {
		this.menu = menu;
		this.count = count;
		this.part = menu.getPart();
		this.orderDate = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
	}
	
	public void pay(int totalPrice, PayMethod payMethod) {
		this.totalPrice = totalPrice;
		this.payMethod = payMethod;
	}
}

package com.juylee.pinachigong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juylee.pinachigong.entity.Order;

@Repository
public interface OrderListRepository extends JpaRepository<Order, Integer>{

}

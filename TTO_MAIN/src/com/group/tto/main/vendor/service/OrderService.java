package com.group.tto.main.vendor.service;

import java.util.List;

import com.group.tto.cmn.model.Order;

public interface OrderService {
	public List<Order> findOrdersByState(String state, long sid);
	public void updateOrder(Order order) ;
}

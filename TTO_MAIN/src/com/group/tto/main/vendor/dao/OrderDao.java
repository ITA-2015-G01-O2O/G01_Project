package com.group.tto.main.vendor.dao;

import java.util.List;


import com.group.tto.cmn.model.Order;


public interface OrderDao {
	public List<Order> findOrdersByState(String state, long sid);
	public List<Order> findNewOrders(long sid);	
	public List<Order> findAllCompletedOrders(long sid);	
	public Order findOrderByOrderId(long oid);	
	public int updateOrder(Order order) ;
}

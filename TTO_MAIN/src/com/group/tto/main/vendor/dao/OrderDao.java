package com.group.tto.main.vendor.dao;

import java.util.List;


import com.group.tto.cmn.model.Order;


public interface OrderDao {
	public List<Order> findOrdersByState(String state, long sid);
	public int updateOrder(Order order) ;
}

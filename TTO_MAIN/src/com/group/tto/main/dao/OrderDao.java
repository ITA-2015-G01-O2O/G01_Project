package com.group.tto.main.dao;

import java.util.List;

import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.UserProfile;

public interface OrderDao {
	
	public List<Order> getAllOrderByUserProfile(UserProfile userProfile);
	
	public Order getOrderById(Long orderId);
	
	public int addOrder(Order o);

}

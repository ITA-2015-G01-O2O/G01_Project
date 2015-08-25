package com.group.tto.main.service;

import java.util.List;

import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.UserProfile;

public interface OrderService {
	
	public List<Order> getAllOrderByUserProfile(UserProfile userProfile);
	public void cancelOrderById(Long orderId);
	
	public void addOrder(Order o);
}

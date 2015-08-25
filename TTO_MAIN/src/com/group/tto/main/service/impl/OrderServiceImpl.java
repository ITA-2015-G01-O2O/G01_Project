package com.group.tto.main.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.UserProfile;
import com.group.tto.main.dao.OrderDao;
import com.group.tto.main.service.OrderService;



@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao order;
	

	public OrderDao getOrder() {
		return order;
	}

	public void setOrder(OrderDao order) {
		this.order = order;
	}

	@Override
	@Transactional
	public List<Order> getAllOrderByUserProfile(UserProfile userProfile) {
		
		return order.getAllOrderByUserProfile(userProfile);
	}
	
	@Override
	@Transactional
	public void cancelOrderById(Long orderId) {

		try{
			Order o = order.getOrderById(orderId);
			o.setIsDelete(true);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
    @Transactional
  public void addOrder(Order proorder) {
	  order.addOrder(proorder);
    
  }
	

}

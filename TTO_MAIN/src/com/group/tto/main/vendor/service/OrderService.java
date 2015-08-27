package com.group.tto.main.vendor.service;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.group.tto.cmn.model.Order;
@Repository("vendorOrderService")
public interface OrderService {
	public List<Order> findOrdersByState(String state, long sid);
	public List<Order> findAllCompletedOrderd(long sid);
	public List<Order> findNewOrders(long sid);
	public void updateOrder(Order order) ;
}

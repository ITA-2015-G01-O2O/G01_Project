package com.group.tto.main.vendor.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Order;
import com.group.tto.main.vo.OrderModelVo;
@Repository("vendorOrderService")
public interface OrderService {
	public List<OrderModelVo> findOrdersByState(String state, long sid);
	public List<OrderModelVo> findAllCompletedOrderd(long sid);
	public List<OrderModelVo> findNewOrders(long sid);
	public void updateOrder(Order order) ;
}

package com.group.tto.main.vendor.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.Product;
import com.group.tto.main.vendor.service.OrderService;

@Controller
@RequestMapping("/order")
@Repository("OrderVendor")
public class OrderController {
	@Autowired
	private OrderService orderService;

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
	@RequestMapping(value = "/loadNewOrder.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public List<Order> loadOrders(HttpServletRequest request) {
	    String state=request.getParameter("state");
		List<Order> Orders= orderService.findOrdersByState(state,50);	
		return Orders;
	}
	
	
	@RequestMapping(value = "/updateOrder.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public List<Order> updateOrder(HttpServletRequest request) {
	   
		//
		//
	     Order order =new Order();   
	     orderService.updateOrder(order);
		 return null;
	}
	
}

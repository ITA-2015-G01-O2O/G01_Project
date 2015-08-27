package com.group.tto.main.vendor.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.cmn.model.OrderItem;
import com.group.tto.main.vendor.service.OrderItemService;

@Controller("OrderItemVendor")
@RequestMapping("/vendor/orderItem")
public class OrderItemController extends BaseController{
	@Autowired
	OrderItemService orderItemService;
	
	public OrderItemService getOrderItemService() {
		return orderItemService;
	}

	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}

	@RequestMapping(value = "/loadOrderItem.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public List<OrderItem> loadProducts(HttpServletRequest request) {
		// 模拟用户
		List<OrderItem> OrderItems = orderItemService.findAllCompleteItems(50);
		return OrderItems;
	}
	
	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "main/vendor";
	}

}

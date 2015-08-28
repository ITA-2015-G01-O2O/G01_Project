package com.group.tto.main.vendor.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.cmn.model.Comment;
import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.OrderItem;
import com.group.tto.main.vendor.service.OrderService;
import com.group.tto.main.vo.OrderModelVo;

@Controller("OrderVendor")
@RequestMapping("/vendor/order")
public class OrderController extends BaseController {
	@Autowired
	private OrderService orderService;
	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping(value = "/loaCompletedOrderByState.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public List<OrderModelVo> loadOrdersByState(HttpServletRequest request) {
		String state = request.getParameter("state");
		List<OrderModelVo> Orders = orderService.findOrdersByState(state, 50);
		return Orders;
	}

	@RequestMapping(value = "/loadAllNewOrder.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public List<OrderModelVo> loadAllOrders(HttpServletRequest request) {

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long sid = (long) request.getSession().getAttribute("sid");
		List<OrderModelVo> Orders = orderService.findNewOrders(sid);
		System.out.print(Orders.size());
		return Orders;
	}

	@RequestMapping(value = "/loadAllCompletedOrder.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public List<OrderModelVo> loadAllCompletedOrders(HttpServletRequest request) {
		long sid = (long) request.getSession().getAttribute("sid");
		List<OrderModelVo> Orders = orderService.findAllCompletedOrderd(sid);
		return Orders;

	}

	@RequestMapping(value = "/updateOrder.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public List<Order> updateOrder(HttpServletRequest request) {
		String status = request.getParameter("status");
		String id = request.getParameter("id");
		Order order = new Order();
		order.setOrderId(Long.parseLong(id));
		order.setStatus(status);
		orderService.updateOrder(order);
		return null;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "main/vendor";
	}


}

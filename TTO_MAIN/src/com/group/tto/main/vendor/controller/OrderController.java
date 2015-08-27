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
		List<Order> Orders = orderService.findOrdersByState(state, 50);
		return translateObject(Orders);
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
		List<Order> Orders = orderService.findNewOrders(sid);
		System.out.print(Orders.size());
		return translateObject(Orders);
	}

	@RequestMapping(value = "/loadAllCompletedOrder.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public List<OrderModelVo> loadAllCompletedOrders(HttpServletRequest request) {
		long sid = (long) request.getSession().getAttribute("sid");
		List<Order> Orders = orderService.findAllCompletedOrderd(sid);
		return translateObject(Orders);

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

	public List<OrderModelVo> translateObject(List<Order> orders) {
		List<OrderModelVo> listVo = new ArrayList<OrderModelVo>();
		for (Order order : orders) {
			OrderModelVo oo = new OrderModelVo();
			oo.setContacterName(order.getContacterName());
			oo.setContacterPhone(order.getContacterPhone());
			oo.setCreateTime(order.getCreateTime());
			oo.setDetailLocation(order.getDetailLocation());
			oo.setEndTime(order.getEndTime());
			oo.setIsDelete(order.getIsDelete());
			oo.setOrderId(order.getOrderId());
			// oo.setOrderItems(order.getOrderItems());
			oo.setEndTime(order.getEndTime());
			oo.setRemarks(order.getRemarks());
			oo.setStatus(order.getStatus());
			oo.setStoreId(order.getStoreId());
			oo.setVersion(order.getVersion());
			oo.setOrderNumber(order.getOrderNumber());
			List<OrderItem> orderItems = new ArrayList<OrderItem>();
			for (int i = 0; i < order.getOrderItems().size(); i++) {
				OrderItem orderItem = new OrderItem();
				orderItem.setAmount(order.getOrderItems().get(i).getAmount());
				orderItem.setOrderItemId(order.getOrderItems().get(i)
						.getOrderItemId());
				orderItem.setPrice(order.getOrderItems().get(i).getPrice());
				orderItem.setProduct(order.getOrderItems().get(i).getProduct());
				orderItems.add(orderItem);
			}
			oo.setOrderItems(orderItems);
			// orderItem.

			if (order.getComment() != null) {
				Comment comm = new Comment();
				comm.setCommentId(order.getComment().getCommentId());
				comm.setContext(order.getComment().getContext());
				comm.setPoint(order.getComment().getPoint());
				;
				oo.setComment(comm);
			}
			listVo.add(oo);
		}
		return listVo;

	}

}

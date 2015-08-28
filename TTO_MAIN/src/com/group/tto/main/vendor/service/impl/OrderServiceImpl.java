package com.group.tto.main.vendor.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Comment;
import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.OrderItem;
import com.group.tto.cmn.model.Product;
import com.group.tto.main.vendor.dao.OrderDao;
import com.group.tto.main.vendor.dao.PoductDao;
import com.group.tto.main.vendor.service.OrderService;
import com.group.tto.main.vo.OrderModelVo;

@Service("vendorOrderServiceImpl")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private PoductDao prodcutDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	@Transactional
	public List<OrderModelVo> findOrdersByState(String state, long sid) {
		return translateObject(orderDao.findOrdersByState(state, sid));
	}

	@Override
	@Transactional
	public void updateOrder(Order order) {
		orderDao.updateOrder(order);

		Order orderTemp = orderDao.findOrderByOrderId(order.getOrderId());
		for (int i = 0; i < orderTemp.getOrderItems().size(); i++) {
			BigDecimal sum = orderTemp.getOrderItems().get(i).getProduct()
					.getSalesVolume();
			Product product = orderTemp.getOrderItems().get(i).getProduct();
			product.setSalesVolume(sum.add(new BigDecimal("1")));
			prodcutDao.updateProduct(product);
		}
	}

	@Override
	@Transactional
	public List<OrderModelVo> findNewOrders(long sid) {
		return translateObject(orderDao.findNewOrders(sid));
	}

	@Override
	@Transactional
	public List<OrderModelVo> findAllCompletedOrderd(long sid) {

		return translateObject(orderDao.findAllCompletedOrders(sid));
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
				Product product = new Product();
				Product db = order.getOrderItems().get(i).getProduct();
				product.setDelete(db.getIsDelete());
				product.setIsDelete(db.getIsDelete());
				product.setPoint(db.getPoint());
				product.setProductLabel(db.getProductLabel());
				product.setStoreId(db.getStoreId());
				product.setVersion(db.getVersion());
				product.setProductName(db.getProductName());
				product.setProductId(db.getProductId());
				product.setSalesVolume(db.getSalesVolume());
				orderItem.setProduct(product);
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

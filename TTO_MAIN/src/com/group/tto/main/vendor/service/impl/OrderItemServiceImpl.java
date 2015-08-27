package com.group.tto.main.vendor.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.OrderItem;
import com.group.tto.main.vendor.dao.OrderItemDao;
import com.group.tto.main.vendor.service.OrderItemService;

@Service
@Repository("vendorOrderItemServiceImpl")
public class OrderItemServiceImpl implements OrderItemService {
	@Autowired
	private OrderItemDao orderItemDao;

	public OrderItemDao getOrderItemDao() {
		return orderItemDao;
	}

	public void setOrderItemDao(OrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}

	@Override
	@Transactional
	public List<OrderItem> findAllCompleteItems(long sid) {

		return orderItemDao.findAllCompleteItems(sid);
	}

}

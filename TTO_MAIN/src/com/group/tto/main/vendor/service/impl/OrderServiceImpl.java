package com.group.tto.main.vendor.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Order;
import com.group.tto.main.vendor.dao.OrderDao;
import com.group.tto.main.vendor.service.OrderService;

@Service("vendorOrderServiceImpl")
public class OrderServiceImpl implements OrderService {
  @Autowired
  private OrderDao orderDao;

  public OrderDao getOrderDao() {
    return orderDao;
  }

  public void setOrderDao(OrderDao orderDao) {
    this.orderDao = orderDao;
  }

  @Override
  @Transactional
  public List<Order> findOrdersByState(String state, long sid) {
    return orderDao.findOrdersByState(state, sid);
  }

  @Override
  @Transactional
  public void updateOrder(Order order) {
    orderDao.updateOrder(order);
  }

}

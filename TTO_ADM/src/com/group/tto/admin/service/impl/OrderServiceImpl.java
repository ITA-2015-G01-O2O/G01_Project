package com.group.tto.admin.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.admin.cmn.OrderSearchCriteria;
import com.group.tto.admin.dao.OrderDao;
import com.group.tto.admin.service.OrderService;
import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.type.OrderStatus;

@Service
public class OrderServiceImpl implements OrderService {
  @Autowired
  private OrderDao dao;

  @Override
  @Transactional
  public List<Order> getNeedAutoConfirmOrder(Date earliestDate) {
    OrderSearchCriteria search = new OrderSearchCriteria();
    search.getStatus().add(OrderStatus.NEW.toString());
    search.getStatus().add(OrderStatus.ACCEPT.toString());
    search.setEarliestDate(earliestDate);
    return this.dao.getOrder(search);
  }

  @Override
  @Transactional
  public List<Order> getNeedCancelConfirmOrder(Date earliestDate) {
    OrderSearchCriteria search = new OrderSearchCriteria();
    search.getStatus().add(OrderStatus.SENDING.toString());
    search.setEarliestDate(earliestDate);
    return this.dao.getOrder(search);
  }

  @Override
  @Transactional
  public void changeStatus(List<Order> orders, String status) {
    for (Order order : orders) {
      order.setStatus(status);
    }
    this.dao.save(orders);
  }

}

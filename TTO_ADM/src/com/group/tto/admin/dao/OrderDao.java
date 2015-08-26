package com.group.tto.admin.dao;

import java.util.List;

import com.group.tto.admin.cmn.OrderSearchCriteria;
import com.group.tto.cmn.model.Order;

public interface OrderDao {
  public List<Order> getOrder(OrderSearchCriteria searchCriteria);

  public void save(List<Order> orders);
}

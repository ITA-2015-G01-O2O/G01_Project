package com.group.tto.admin.service;

import java.util.Date;
import java.util.List;

import com.group.tto.admin.cmn.OrderSearchCriteria;
import com.group.tto.cmn.model.Order;

public interface OrderService {
  public List<Order> getNeedAutoConfirmOrder(Date earliestDate);
  
  public List<Order> getNeedCancelConfirmOrder(Date earliestDate);

  public void changeStatus(List<Order> orders,String status);
}

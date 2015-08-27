package com.group.tto.main.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.OrderItem;
import com.group.tto.cmn.model.UserProfile;
import com.group.tto.cmn.type.OrderStatus;
import com.group.tto.main.common.JMSHelper;
import com.group.tto.main.common.MessageType;
import com.group.tto.main.common.OrderJMSMsg;
import com.group.tto.main.dao.OrderDao;
import com.group.tto.main.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderDao order;

  private JMSHelper<OrderJMSMsg> jmsHelper = new JMSHelper<OrderJMSMsg>();

  public OrderDao getOrder() {
    return order;
  }

  public void setOrder(OrderDao order) {
    this.order = order;
  }

  @Override
  @Transactional
  public List<Order> getAllOrderByUserProfile(UserProfile userProfile) {

    List<Order> l = order.getAllOrderByUserProfile(userProfile);
    for (Order o : l) {
      List<OrderItem> ll = o.getOrderItems();
      Set<OrderItem> s = new HashSet<OrderItem>();
      for (OrderItem oi : ll) {
        s.add(oi);
      }
      List<OrderItem> lll = new ArrayList<OrderItem>();
      for (OrderItem ssss : s) {
        lll.add(ssss);
      }
      o.setOrderItems(lll);
    }
    
    return l;
  }

  @Override
  @Transactional
  public Boolean cancelOrderById(Long orderId) {

    try {

      Order o = order.getOrderById(orderId);
      if ("NEW".equals(o.getStatus())) {
        o.setStatus(OrderStatus.CANCEL.name());
        return true;
      } else {
        return false;
      }

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }

  }

  @Override
  @Transactional
  public void addOrder(Order proorder) {
    order.addOrder(proorder);

    OrderJMSMsg o = new OrderJMSMsg();
    o.setFlag(MessageType.ADD_ORDER.name());
    o.setId(UUID.randomUUID().toString());
    o.setOrderId(proorder.getOrderId());
    o.setStoreId(proorder.getStoreId());
    try {
      jmsHelper.sendJMSMessage(o);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  @Override
  @Transactional
  public List<Order> getAllOrderByStoreId(Long storeId) {

    return order.getAllOrderByStoreId(storeId);
  }

  @Override
  @Transactional
  public Boolean confirmOrderById(Long orderId) {
    try {

      Order o = order.getOrderById(orderId);
      if ("SENDING".equals(o.getStatus())) {
        o.setStatus(OrderStatus.FINISHED.name());
        System.out.println(o.getStatus());
        return true;
      } else {
        return false;
      }

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

}

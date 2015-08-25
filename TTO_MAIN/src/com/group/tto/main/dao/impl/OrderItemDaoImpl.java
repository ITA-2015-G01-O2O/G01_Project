package com.group.tto.main.dao.impl;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.OrderItem;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.dao.OrderItemDao;

@Repository
public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {

  @Override
  public int addOrderItem(OrderItem oi) {
   
    this.create(oi);
   return 1;
  }
}

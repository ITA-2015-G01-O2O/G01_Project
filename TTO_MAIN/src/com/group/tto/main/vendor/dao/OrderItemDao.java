package com.group.tto.main.vendor.dao;

import java.util.List;
import com.group.tto.cmn.model.OrderItem;
public interface OrderItemDao {
    public List<OrderItem> findAllCompleteItems(long sid);
}

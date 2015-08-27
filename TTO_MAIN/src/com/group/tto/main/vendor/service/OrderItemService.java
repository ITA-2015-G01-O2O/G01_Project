package com.group.tto.main.vendor.service;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.group.tto.cmn.model.OrderItem;


@Repository("vendorOrderItemService")
public interface OrderItemService {
	public List<OrderItem> findAllCompleteItems(long sid);
}

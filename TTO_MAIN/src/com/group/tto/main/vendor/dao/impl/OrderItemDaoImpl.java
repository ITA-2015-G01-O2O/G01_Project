package com.group.tto.main.vendor.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.OrderItem;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.vendor.dao.OrderItemDao;
@Repository("vendorOrderItemDaoImpl")
public class OrderItemDaoImpl extends BaseDao<Order>  implements OrderItemDao {
	@Override
	public List<OrderItem> findAllCompleteItems(long sid) {

		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<OrderItem> query = builder.createQuery(OrderItem.class);
		Root<OrderItem> order=query.from(OrderItem.class);
		Predicate condition =builder.equal(order.get("product").get("storeId"),sid);
	    List <OrderItem>orders=this.getEntityManager().createQuery(query.where(condition)).getResultList();
		return orders;
	}
}

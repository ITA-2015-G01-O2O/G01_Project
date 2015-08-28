package com.group.tto.main.vendor.dao.impl;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.group.tto.cmn.model.Order;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.vendor.dao.OrderDao;

@Repository("vendorOrderDaoImpl")
public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

	@Override
	public List<Order> findOrdersByState(String state, long sid) {
		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);
		Root<Order> order = query.from(Order.class);
		Predicate condition = builder.and(
				builder.equal(order.get("storeId"), sid),
				builder.equal(order.get("status"), state));
		List<Order> orders = this.getEntityManager()
				.createQuery(query.where(condition)).getResultList();
		return orders;

	}

	@Override
	public int updateOrder(Order order) {
		Order orderTemp = this.getEntityManager().find(Order.class,
				order.getOrderId());
		orderTemp.setStatus(order.getStatus());
		this.update(orderTemp);
		return 0;
	}

	@Override
	public List<Order> findNewOrders(long sid) {
		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);
		Root<Order> order = query.from(Order.class);
		Predicate condition = builder.and(
				builder.equal(order.get("storeId"), sid),
				builder.or(builder.equal(order.get("status"), "NEW"),
						builder.equal(order.get("status"), "ACCEPT"),
						builder.equal(order.get("status"), "SENDING")));
		List<Order> orders = this.getEntityManager()
				.createQuery(query.where(condition)).getResultList();
		return orders;
	}

	@Override
	public List<Order> findAllCompletedOrders(long sid) {
		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);
		Root<Order> order = query.from(Order.class);
		Predicate condition = builder.and(builder.equal(order.get("storeId"),
				sid), builder.or(
				builder.equal(order.get("status"), "FINISHED"),
				builder.equal(order.get("status"), "CANCEL")));
		List<Order> orders = this
				.getEntityManager()
				.createQuery(
						query.where(condition).orderBy(
								builder.desc(order.get("createTime"))))
				.getResultList();
		return orders;
	}

	@Override
	public Order findOrderByOrderId(long oid) {
		return this.getEntityManager().find(Order.class, oid);
	}

}

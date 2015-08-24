package com.group.tto.main.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.UserProfile;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.dao.OrderDao;
@Repository
public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {
	
	private static final String FIELD_USERPROFILE = "userProfile";
	private static final String FIELD_ORDERID ="orderId";

	@Override
	//根据userProfile查询所有的订单
	public List<Order> getAllOrderByUserProfile(UserProfile userProfile) {
		List<Order> orders = new ArrayList<Order>();

		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);
		Root<Order> order = query.from(Order.class);
		
		Predicate condition = builder.equal(order.get(FIELD_USERPROFILE), userProfile);		
		orders = this.getEntityManager().createQuery(query.where(condition)).getResultList();
		
		return orders;
	}

	@Override
	//根据orderId取消对应的订单
	public Order getOrderById(Long orderId) {
		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);
		Root<Order> order = query.from(Order.class);
		Predicate condition = builder.equal(order.get(FIELD_ORDERID), orderId);	
		Order o = this.getEntityManager().createQuery(query.where(condition)).getResultList().get(0);
		return o;
		
	}

	
}

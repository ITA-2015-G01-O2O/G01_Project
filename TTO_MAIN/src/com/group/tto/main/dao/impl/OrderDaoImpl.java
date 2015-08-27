package com.group.tto.main.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.UserProfile;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.dao.OrderDao;

@Repository
public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

  private static final String FIELD_USERPROFILE = "userProfile";
  private static final String FIELD_ORDERID = "orderId";
  private static final String FIELD_STOREID = "storeId";

  @Override
  // select all orders by userProfile
  public List<Order> getAllOrderByUserProfile(UserProfile userProfile) {
    List<Order> orders = new ArrayList<Order>();
//    String sql = "from Order where userProfile.userProfileId=:id";
//    Query q = this.getEntityManager().createQuery(sql);
//    q.setParameter("id", userProfile.getUserProfileId());
//    orders = (List<Order>)q.getResultList();
    
//    Session session = this.getEntityManager().unwrap(org.hibernate.Session.class);
//    String strSql= "from Order where userProfile.userProfileId=:id";
//    org.hibernate.Query  query = session.createQuery(strSql.toString());
//    query.setParameter("id", userProfile.getUserProfileId());
//    orders = (List<Order>)query.list();

    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Order> query = builder.createQuery(Order.class);
    Root<Order> order = query.from(Order.class);

		Predicate condition = builder.equal(order.get(FIELD_USERPROFILE).get("userProfileId").as(Long.class),
				userProfile.getUserProfileId());
		orders = this.getEntityManager().createQuery(query.where(condition))
				.getResultList();
    
    
    

    return orders;
  }

  @Override
  // select order by orderId
  public Order getOrderById(Long orderId) {
    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Order> query = builder.createQuery(Order.class);
    Root<Order> order = query.from(Order.class);
    Predicate condition = builder.equal(order.get(FIELD_ORDERID), orderId);
    Order o = this.getEntityManager().createQuery(query.where(condition)).getResultList().get(0);
    return o;

  }

  @Override
  public int addOrder(Order o) {
    this.create(o);
    return 1;
  }

  @Override
  public List<Order> getAllOrderByStoreId(Long storeId) {
    List<Order> orders = new ArrayList<Order>();

    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Order> query = builder.createQuery(Order.class);
    Root<Order> order = query.from(Order.class);

    Predicate condition = builder.equal(order.get(FIELD_STOREID), storeId);
    orders = this.getEntityManager().createQuery(query.where(condition)).getResultList();

    return orders;
  }

  @Override
  public void saveOrder(Order o) {
    this.update(o);
  }

}

package com.group.tto.admin.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.admin.cmn.OrderSearchCriteria;
import com.group.tto.admin.dao.BaseDao;
import com.group.tto.admin.dao.OrderDao;
import com.group.tto.cmn.model.Order;

@Repository
public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

  public OrderDaoImpl() {
    super(Order.class);
  }

  private static final String FIELD_STATUS = "status";
  private static final String FIELD_ORDER_ID = "orderId";
  private static final String FIELD_CREATE_TIME = "createTime";

  @Override
  public List<Order> getOrder(OrderSearchCriteria searchCriteria) {
    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Order> query = builder.createQuery(Order.class);
    Root<Order> order = query.from(Order.class);

    if (!searchCriteria.getStatus().isEmpty()) {
      Predicate predicate = builder.isNotNull(order.get(FIELD_ORDER_ID));
      for (String status : searchCriteria.getStatus()) {
        predicate = builder.or(builder.equal(order.get(FIELD_STATUS), status));
      }
      predicate =
          builder.and(builder.lessThan(order.get(FIELD_CREATE_TIME).as(Date.class),
              searchCriteria.getEarliestDate()));
      List<Order> result =
          this.getEntityManager().createQuery(query.where(predicate)).getResultList();
      return result;
    }
    return new ArrayList<Order>();
  }

  @Override
  public void save(List<Order> orders) {
    for (Order order : orders) {
      this.update(order);
    }
  }

}

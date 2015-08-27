package com.group.tto.main.service.impl;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Comment;
import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.Store;
import com.group.tto.main.dao.OrderDao;
import com.group.tto.main.dao.StoreDao;
import com.group.tto.main.dao.UserProfileDao;
import com.group.tto.main.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

  @Autowired
  private OrderDao orderDao;
  @Autowired
  private UserProfileDao userProfileDao;
  @Autowired
  private StoreDao storeDao;

  @Override
  @Transactional
  public boolean createComment(String context, BigDecimal point, BigDecimal deliverTime,
      Long userProfileId, Long orderId) {
    Comment comment = new Comment();
    comment.setContext(context);
    comment.setDeliverTime(deliverTime);
    comment.setPoint(point);
    comment.setUserProfile(this.userProfileDao.findUserProfileByProfileId(userProfileId));

    Order order = this.orderDao.getOrderById(orderId);
    if (order.getComment() == null) {
      order.setComment(comment);

      Store store = this.storeDao.getStoreById(order.getStoreId());
      BigDecimal avgPoint = store.getAvgPoint();
      BigDecimal avgDeliver = store.getAvgDeliverTime();
      Integer totalOrder = store.getOrders().size();

      store.setAvgDeliverTime(avgDeliver.multiply(new BigDecimal(totalOrder)).add(deliverTime)
          .multiply(new BigDecimal(totalOrder + 1)));
      store.setAvgPoint(avgPoint.multiply(new BigDecimal(totalOrder)).add(point)
          .multiply(new BigDecimal(totalOrder + 1)));

      this.orderDao.saveOrder(order);
      this.storeDao.updateStore(store);

      return true;
    } else {
      return false;
    }
  }

}

package com.group.tto.main.service.impl;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Comment;
import com.group.tto.cmn.model.Order;
import com.group.tto.main.dao.OrderDao;
import com.group.tto.main.dao.UserProfileDao;
import com.group.tto.main.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

  @Autowired
  private OrderDao orderDao;
  @Autowired
  private UserProfileDao userProfileDao;

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
      this.orderDao.saveOrder(order);
      return true;
    } else {
      return false;
    }



  }

}

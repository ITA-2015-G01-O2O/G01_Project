package com.group.tto.main.service;

import java.math.BigDecimal;

public interface CommentService {
  public boolean createComment(String context, BigDecimal point, BigDecimal deliverTime,
      Long userProfileId,Long orderId);
}

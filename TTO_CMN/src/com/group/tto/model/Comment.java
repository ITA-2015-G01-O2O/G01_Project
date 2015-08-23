package com.group.tto.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TTO_COMMENT")
public class Comment {
  @Id
  @Column(name = "COMMENT_ID")
  @SequenceGenerator(name = "COMMENT_ID_SEQ", sequenceName = "SEQ_TTO_COMMENT_ID")
  @GeneratedValue(generator = "COMMENT_ID_SEQ", strategy = GenerationType.SEQUENCE)
  private Long commentId;
  @Column(name = "CONTEXT")
  private String context;
  @Column(name = "POINT")
  private BigDecimal point;
  @Column(name = "DELIVER_TIME")
  private BigDecimal deliverTime;
  @ManyToOne(targetEntity = UserProfile.class, fetch = FetchType.EAGER)
  private UserProfile userProfile;

  public Long getCommentId() {
    return commentId;
  }

  public void setCommentId(Long commentId) {
    this.commentId = commentId;
  }

  public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;
  }

  public BigDecimal getPoint() {
    return point;
  }

  public void setPoint(BigDecimal point) {
    this.point = point;
  }

  public BigDecimal getDeliverTime() {
    return deliverTime;
  }

  public void setDeliverTime(BigDecimal deliverTime) {
    this.deliverTime = deliverTime;
  }

  public UserProfile getUserProfile() {
    return userProfile;
  }

  public void setUserProfile(UserProfile userProfile) {
    this.userProfile = userProfile;
  }


}

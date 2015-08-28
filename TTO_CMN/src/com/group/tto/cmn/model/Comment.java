package com.group.tto.cmn.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
  @ManyToOne(targetEntity = UserProfile.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "USER_PROFILE", foreignKey = @ForeignKey(name = "USER_PROFILE"))
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((commentId == null) ? 0 : commentId.hashCode());
    result = prime * result + ((context == null) ? 0 : context.hashCode());
    result = prime * result + ((deliverTime == null) ? 0 : deliverTime.hashCode());
    result = prime * result + ((point == null) ? 0 : point.hashCode());
    result = prime * result + ((userProfile == null) ? 0 : userProfile.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Comment other = (Comment) obj;
    if (commentId == null) {
      if (other.commentId != null) return false;
    } else if (!commentId.equals(other.commentId)) return false;
    if (context == null) {
      if (other.context != null) return false;
    } else if (!context.equals(other.context)) return false;
    if (deliverTime == null) {
      if (other.deliverTime != null) return false;
    } else if (!deliverTime.equals(other.deliverTime)) return false;
    if (point == null) {
      if (other.point != null) return false;
    } else if (!point.equals(other.point)) return false;
    if (userProfile == null) {
      if (other.userProfile != null) return false;
    } else if (!userProfile.equals(other.userProfile)) return false;
    return true;
  }


}

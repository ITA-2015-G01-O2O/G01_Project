package com.group.tto.main.vo;

import java.math.BigDecimal;
import java.util.List;

import com.group.tto.cmn.model.Comment;

public class CommentsVO {
  private String context;
  private BigDecimal point;
  private BigDecimal deliverTime;
  
  public CommentsVO(){
    
  }
  public CommentsVO(Comment c){
    this.context=c.getContext();
    this.point=c.getPoint();
    this.deliverTime=c.getDeliverTime();
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
  
  
    
}

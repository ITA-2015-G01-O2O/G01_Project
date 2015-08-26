package com.group.tto.admin.cmn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderSearchCriteria {
  private List<String> status = new ArrayList<String>();
  private Date earliestDate;

  public OrderSearchCriteria() {}

  public OrderSearchCriteria(List<String> status, Date earliestDate) {
    super();
    this.status = status;
    this.earliestDate = earliestDate;
  }

  public List<String> getStatus() {
    return status;
  }

  public void setStatus(List<String> status) {
    this.status = status;
  }

  public Date getEarliestDate() {
    return earliestDate;
  }

  public void setEarliestDate(Date earliestDate) {
    this.earliestDate = earliestDate;
  }



}

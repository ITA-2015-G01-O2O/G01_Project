package com.group.tto.main.vo;

import java.math.BigDecimal;

public class OrderEachItem {
  private BigDecimal amount;
  private String productName;
  private BigDecimal price;

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }



}

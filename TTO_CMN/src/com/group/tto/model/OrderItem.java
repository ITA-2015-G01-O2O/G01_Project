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
@Table(name = "TTO_ORDER_ITEM")
public class OrderItem {
  @Id
  @Column(name = "ORDER_ITEM_ID")
  @SequenceGenerator(name = "ORDER_ITEM_ID_SEQ", sequenceName = "SEQ_TTO_ORDER_ITEM_ID")
  @GeneratedValue(generator = "ORDER_ITEM_ID_SEQ", strategy = GenerationType.SEQUENCE)
  private Long orderItemId;
  @Column(name = "PRICE")
  private BigDecimal price;
  @Column(name = "AMOUNT")
  private BigDecimal amount;
  @ManyToOne(targetEntity = Product.class, fetch = FetchType.EAGER)
  private Product product;

  public Long getOrderItemId() {
    return orderItemId;
  }

  public void setOrderItemId(Long orderItemId) {
    this.orderItemId = orderItemId;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }


}

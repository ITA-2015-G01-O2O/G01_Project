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
  @JoinColumn(foreignKey = @ForeignKey(name = "PRODUCT"))
  private Product product;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "ORDER_ID", foreignKey = @ForeignKey(name = "ORDER_ID"))
  private Order order;

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

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((amount == null) ? 0 : amount.hashCode());
    result = prime * result + ((orderItemId == null) ? 0 : orderItemId.hashCode());
    result = prime * result + ((price == null) ? 0 : price.hashCode());
    result = prime * result + ((product == null) ? 0 : product.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    OrderItem other = (OrderItem) obj;
    if (amount == null) {
      if (other.amount != null) return false;
    } else if (!amount.equals(other.amount)) return false;
    if (orderItemId == null) {
      if (other.orderItemId != null) return false;
    } else if (!orderItemId.equals(other.orderItemId)) return false;
    if (price == null) {
      if (other.price != null) return false;
    } else if (!price.equals(other.price)) return false;
    if (product == null) {
      if (other.product != null) return false;
    } else if (!product.equals(other.product)) return false;
    return true;
  }

}

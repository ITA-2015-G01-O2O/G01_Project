package com.group.tto.main.vo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.Product;
import com.group.tto.cmn.model.ProductLabel;
import com.group.tto.cmn.model.Store;

public class MerProsList {
  private List<ProductVO> products = new ArrayList<ProductVO>();

  private Long storeId;
  private String storeName;
  private String logoPicUrl;

  private String detailLocation;
  private String serviceBeginTime;
  private String serviceEndTime;
  /**
   * kuai di fei qisong fei
   */
  private BigDecimal deliverFee;
  private BigDecimal startingFee;

  private BigDecimal avgPoint;

  private BigDecimal avgDeliverTime;

  private List<ProductLabelVO> productLabels = new ArrayList<ProductLabelVO>();
  /**
   * gong gao
   */
  private String announcement;

  List<OrderVO> orders = new ArrayList<OrderVO>();
  private String phone;

  public MerProsList() {

  }

  public MerProsList(Store stroe) {
    this.phone = stroe.getPhone();

    this.products = getProductVO(stroe.getProducts());


    this.storeId = stroe.getStoreId();
    this.storeName = stroe.getStoreName();

    this.detailLocation = stroe.getDetailLocation();

    this.serviceBeginTime = new SimpleDateFormat("HH:mm").format(stroe.getServiceBeginTime());
    this.serviceEndTime = new SimpleDateFormat("HH:mm").format(stroe.getServiceEndTime());
    /**
     * kuai di fei qisong fei
     */
    this.deliverFee = stroe.getDeliverFee();
    this.startingFee = stroe.getStartingFee();

    this.orders = getOrdersVO(stroe.getOrders());
    this.avgPoint = stroe.getAvgPoint();

    this.avgDeliverTime = stroe.getAvgDeliverTime();

    /**
     * gong gao
     */
    this.announcement = stroe.getAnnouncement();
    this.logoPicUrl = stroe.getLogoPicUrl();
    this.productLabels = getProductLabelVO(stroe.getProductLabels());
  }

  private List<ProductLabelVO> getProductLabelVO(List<ProductLabel> productLabels2) {
    List<ProductLabelVO> prolabelsVos = new ArrayList<ProductLabelVO>();
    for (ProductLabel pl : productLabels2) {
      ProductLabelVO p1 = new ProductLabelVO(pl);
      prolabelsVos.add(p1);
    }
    return prolabelsVos;
  }

  private List<OrderVO> getOrdersVO(List<Order> orders2) {
    List<OrderVO> ordersVos = new ArrayList<OrderVO>();
    for (Order pl : orders2) {
      OrderVO p1 = new OrderVO(pl);
      ordersVos.add(p1);
    }
    return ordersVos;
  }

  private List<ProductVO> getProductVO(List<Product> products2) {
    List<ProductVO> productsVos = new ArrayList<ProductVO>();
    for (Product pl : products2) {
      ProductVO p1 = new ProductVO(pl);
      productsVos.add(p1);
    }
    return productsVos;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }



  public String getLogoPicUrl() {
    return logoPicUrl;
  }



  public void setLogoPicUrl(String logoPicUrl) {
    this.logoPicUrl = logoPicUrl;
  }



  public List<ProductVO> getProducts() {
    return products;
  }

  public void setProducts(List<ProductVO> products) {
    this.products = products;
  }

  public List<ProductLabelVO> getProductLabels() {
    return productLabels;
  }

  public void setProductLabels(List<ProductLabelVO> productLabels) {
    this.productLabels = productLabels;
  }

  public List<OrderVO> getOrders() {
    return orders;
  }

  public void setOrders(List<OrderVO> orders) {
    this.orders = orders;
  }

  public Long getStoreId() {
    return storeId;
  }

  public void setStoreId(Long storeId) {
    this.storeId = storeId;
  }

  public String getStoreName() {
    return storeName;
  }

  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }

  public String getDetailLocation() {
    return detailLocation;
  }

  public void setDetailLocation(String detailLocation) {
    this.detailLocation = detailLocation;
  }

  public String getServiceBeginTime() {
    return serviceBeginTime;
  }

  public void setServiceBeginTime(String serviceBeginTime) {
    this.serviceBeginTime = serviceBeginTime;
  }

  public String getServiceEndTime() {
    return serviceEndTime;
  }

  public void setServiceEndTime(String serviceEndTime) {
    this.serviceEndTime = serviceEndTime;
  }

  public BigDecimal getDeliverFee() {
    return deliverFee;
  }

  public void setDeliverFee(BigDecimal deliverFee) {
    this.deliverFee = deliverFee;
  }

  public BigDecimal getStartingFee() {
    return startingFee;
  }

  public void setStartingFee(BigDecimal startingFee) {
    this.startingFee = startingFee;
  }

  public BigDecimal getAvgPoint() {
    return avgPoint;
  }

  public void setAvgPoint(BigDecimal avgPoint) {
    this.avgPoint = avgPoint;
  }

  public BigDecimal getAvgDeliverTime() {
    return avgDeliverTime;
  }

  public void setAvgDeliverTime(BigDecimal avgDeliverTime) {
    this.avgDeliverTime = avgDeliverTime;
  }

  public String getAnnouncement() {
    return announcement;
  }

  public void setAnnouncement(String announcement) {
    this.announcement = announcement;
  }

  
  public static void main(String[] arg) throws Exception{
    MerProsList mp=new MerProsList();
    List<ProductVO> pros=new ArrayList<ProductVO>();
    //pros.add(e)
    mp.setAnnouncement("12321321");
    System.out.println(new ObjectMapper().writeValueAsString(mp));
  }


}

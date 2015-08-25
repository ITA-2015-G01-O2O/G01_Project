package com.group.tto.main.vo;


import java.util.Map;

public class AddOrderVO {
    private String proName;
    private String proId;
    private String proPrice;
    private String proNum;
    private String bid;
    
    public AddOrderVO(){
      
    }
    
    public AddOrderVO(Map<String, Object> list) {
      if(list.containsKey("proName")){
        this.proName=list.get("proName").toString();
      }
      if(list.containsKey("proId")){
        this.proId=list.get("proId").toString();
      }
      if(list.containsKey("proPrice")){
        this.proPrice=list.get("proPrice").toString();
      }
      if(list.containsKey("proNum")){
        this.proNum=list.get("proNum").toString();
      }
      if(list.containsKey("bid")){
        this.bid=list.get("bid").toString();
      }
    }
    public String getProName() {
      return proName;
    }
    public void setProName(String proName) {
      this.proName = proName;
    }
    public String getProId() {
      return proId;
    }
    public void setProId(String proId) {
      this.proId = proId;
    }
    public String getProPrice() {
      return proPrice;
    }
    public void setProPrice(String proPrice) {
      this.proPrice = proPrice;
    }
    public String getProNum() {
      return proNum;
    }
    public void setProNum(String proNum) {
      this.proNum = proNum;
    }
    public String getBid() {
      return bid;
    }
    public void setBid(String bid) {
      this.bid = bid;
    }
    
    
    
    
}

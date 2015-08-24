package com.group.tto.main.vo;

import java.util.List;

import com.group.tto.cmn.model.Product;

public class MerProsList {
	private List<Product> products;
	
	private Long storeId;
	private String storeName;
	
	public MerProsList(){
		
	}
	public MerProsList(List<Product> products,Long storeId,String storeName){
		this.products=products;
		this.storeId=storeId;
		this.storeName=storeName;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
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
	
}

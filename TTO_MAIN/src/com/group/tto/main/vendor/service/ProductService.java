package com.group.tto.main.vendor.service;

import java.util.List;

import com.group.tto.cmn.model.Product;

public interface ProductService {
    public void addProduct(Product product);
    public List<Product> findAllProductsBySid(long sid);
    public List<Product> findProductsByLabel(String label,long sid);
    public void updateProducts(Product product);
    public void deleteProducts(long pid);
}

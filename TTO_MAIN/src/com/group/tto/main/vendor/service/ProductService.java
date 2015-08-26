package com.group.tto.main.vendor.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Product;
@Repository("vendorProductService")
public interface ProductService {
    public void addProduct(Product product,InputStream input);
    public List<Product> findAllProductsBySid(long sid);
    public List<Product> findProductsByLabel(long label,long sid);
    public void updateProducts(Product product);
    public void deleteProducts(long pid);
}

package com.group.tto.main.vendor.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.main.vendor.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController  extends BaseController{
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(value = "/addProduct.do", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	  public String addProduct(String loginname, String password, HttpServletRequest request) {
     
		
	  return password;

	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}

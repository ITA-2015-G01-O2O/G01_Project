package com.group.tto.main.vendor.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.group.tto.cmn.model.Product;
import com.group.tto.cmn.model.ProductLabel;
import com.group.tto.main.vendor.service.ProductLabelService;
import com.group.tto.main.vendor.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductLabelService productLabelService;

	public ProductLabelService getProductLabelService() {
		return productLabelService;
	}

	public void setProductLabelService(ProductLabelService productLabelService) {
		this.productLabelService = productLabelService;
	}

	@RequestMapping(value = "/addProduct.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String addProduct(HttpServletRequest request, @RequestParam(value = "productPic") MultipartFile pic1) {

	//	productPic
		String menuName = request.getParameter("menuName");
		String menuType = request.getParameter("selectType");
		String menuPrice = request.getParameter("menuPrice");
	    String picName1 = UUID.randomUUID().toString();
	    InputStream is1 = null;

		try {
			String proName = new String(menuName.getBytes("ISO-8859-1"),
					"UTF-8");
			// Attendation this.
			String proMenuType ="中餐"; //new String(menuType.getBytes("ISO-8859-1"),
					//"UTF-8");
			String proMenuPrice = new String(menuPrice.getBytes("ISO-8859-1"),
					"UTF-8");
		    is1=pic1.getInputStream();
			Product product = new Product();
			BigDecimal price = new BigDecimal(proMenuPrice);
			product.setIsDelete(false);
			product.setPrice(price);
			BigDecimal temp = new BigDecimal(0);
			product.setPoint(temp);
			product.setProductName(proName);
			product.setSalesVolume(temp);
			product.setVersion((long) 0);
			product.setProductPicUrl(picName1);
			// /////////////////////////////////////////////
			product.setStoreId((long) 50);
			ProductLabel productLabel = productLabelService
					.findProductLabel(Long.parseLong(menuType));
			product.setProductLabel(productLabel);
			productService.addProduct(product, is1);
			return this.getResultJSON(true, null);
			// return the table
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.getResultJSON(false, null);
	}

	@RequestMapping(value = "/loadProduct.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public List<Product> loadProducts(HttpServletRequest request) {
		// 模拟用户
		List<Product> products = productService.findAllProductsBySid(50);
		return products;
	}
	
	@RequestMapping(value = "/loadProductByLabel.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public List<Product> loadProductsByLabel(HttpServletRequest request) {
		String laeblID=request.getParameter("label");
		List<Product> products = productService.findProductsByLabel(Long.parseLong(laeblID), 50);
		return products;
	}
	
	
	@RequestMapping(value = "/deleteProduct.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String deleteProducts(HttpServletRequest request) {
		String pid = request.getParameter("pid");
		productService.deleteProducts(Long.parseLong(pid));
		return this.getResultJSON(true, null);
	}

	@RequestMapping(value = "/updateProduct.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String updateProducts(HttpServletRequest request) {

		String pid = request.getParameter("pid");
		String menuName = request.getParameter("name");
		String menuPrice = request.getParameter("price");

		try {
			String proName = new String(menuName.getBytes("ISO-8859-1"),
					"UTF-8");
			String proMenuPrice = new String(menuPrice.getBytes("ISO-8859-1"),
					"UTF-8");
			Product product = new Product();
			product.setProductId(Long.parseLong(pid));
			product.setProductName(proName);
			BigDecimal price = new BigDecimal(proMenuPrice);
			product.setPrice(price);
			productService.updateProducts(product);
			return this.getResultJSON(true, null);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return this.getResultJSON(false, null);
		// Attendation this.
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Override
	protected String getName() {
		return "main/vendor";
	}

}

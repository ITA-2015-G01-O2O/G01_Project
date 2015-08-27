package com.group.tto.main.vendor.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.cmn.model.ProductLabel;
import com.group.tto.main.vendor.service.ProductLabelService;

@Controller
@RequestMapping("/vendor/productLabel")
public class ProductLabelController extends BaseController {
	@Autowired
	private ProductLabelService productLabelService;
	
	public ProductLabelService getProductLabelService() {
		return productLabelService;
	}
	public void setProductLabelService(ProductLabelService productLabelService) {
		this.productLabelService = productLabelService;
	}

	@RequestMapping(value = "/addProductLabel.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String addProductLabel(HttpServletRequest request) {
		String LabelName=request.getParameter("LabelName");
		ProductLabel productLabel=new ProductLabel();
		productLabel.setProductLabelName(LabelName);
		long sid=(long) request.getSession().getAttribute("sid");
		productLabel.setStoreId(sid);
		productLabelService.addProductLabel(productLabel);
	    return this.getResultJSON(true, null);	
	}
	
	@RequestMapping(value = "/findProductLabel.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public List<ProductLabel> findProductLabels(HttpServletRequest request) {
	 List<ProductLabel> products=productLabelService.findAllProductLabels();
	 return products;
	}
	
	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "main/vendor";
	}

}

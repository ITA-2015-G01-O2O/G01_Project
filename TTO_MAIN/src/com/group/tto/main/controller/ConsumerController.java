package com.group.tto.main.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Store;
import com.group.tto.main.common.COMMON;
import com.group.tto.main.service.AccountService;
import com.group.tto.main.service.StoreService;



@Controller
@RequestMapping("/consumer")
public class ConsumerController extends BaseController {
	@Autowired
	  private StoreService storeService;
	
	  @RequestMapping(value = "/getMerchantById.do", produces = {"application/json;charset=UTF-8"})
	  @ResponseBody
	  public String getMerProsById(String merId, HttpServletRequest request) {
		  
		Store store=this.storeService.getAllProsById(Integer.parseInt(merId));
		String data=this.getResultJSON(true, store);
		return data;
	  }
	  
	  
	  @RequestMapping("/getMerprosById.view")
	  public String view(Long merId,Map map) {
		 map.put("merId", merId);
	    return this.getName() + "/showmerpros";
	  }
	  
	  
	  
	
	
	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "main/consumer";
	}
	
	@RequestMapping(value = "/getAllproByMerId.action", method = { RequestMethod.POST }, produces = { "application/json;charset=UTF-8" })
	public void showMerAllpros(String merId,OutputStream out){
		List<Store> store=null;
	}

}

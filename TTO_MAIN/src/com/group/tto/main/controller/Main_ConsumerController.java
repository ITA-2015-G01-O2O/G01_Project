package com.group.tto.main.controller;

import java.io.OutputStream;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group.tto.cmn.model.Store;

public class Main_ConsumerController extends BaseController {

	
	
	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "consumer";
	}
	
	@RequestMapping(value = "/getAllproByMerId.action", method = { RequestMethod.POST }, produces = { "application/json;charset=UTF-8" })
	public void showMerAllpros(String merId,OutputStream out){
		List<Store> store=null;
	}

}

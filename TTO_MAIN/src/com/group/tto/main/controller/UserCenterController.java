package com.group.tto.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.UserProfile;
import com.group.tto.main.service.OrderService;

@Controller
@RequestMapping(value="/usercenter")
public class UserCenterController extends BaseController{
	
	@Autowired
	private OrderService orderService;
	

	@Override
	protected String getName() {
		return "main/usercenter";
	}
	
	
	@RequestMapping(value="/getAllUser.do",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public void getAllOrderWhenLoadPage(){
		System.out.println("receive load all users' oders when load usercenter page..................");
		System.out.println("handling.................");
		UserProfile userProfile = new UserProfile();
		userProfile.setUserProfileId(50l);
		List<Order> orders = orderService.getAllOrderByUserProfile(userProfile);
		System.out.println(orders.size());

	}
	
	
	@RequestMapping(value="/getUserProfile.do")
	public void getUserProfileBy(){
		
	}
	
	@RequestMapping(value="/changeUserProfile.do")
	public void changeUserProfile(){
		
	}
	

}

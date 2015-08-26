package com.group.tto.main.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Collect;
import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.OrderItem;
import com.group.tto.cmn.model.Store;
import com.group.tto.cmn.model.UserProfile;
import com.group.tto.main.service.AccountService;
import com.group.tto.main.service.CollectService;
import com.group.tto.main.service.OrderService;
import com.group.tto.main.service.StoreService;
import com.group.tto.main.service.UserProfileService;
import com.group.tto.main.vo.OrderEachItem;
import com.group.tto.main.vo.OrderListVo;
import com.group.tto.main.vo.UserFavVendorsVo;
import com.group.tto.main.vo.UserInformationVo;

@Controller
@RequestMapping(value="/usercenter")
public class UserCenterController extends BaseController{
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserProfileService userProfileService;
	@Autowired
	private CollectService collectService;
	

	@Override
	protected String getName() {
		return "main/usercenter";
	}
	
	
	@RequestMapping(value="/getAllUser.do",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	/**
	 * this method accept a UserProfile Object and according this object to find their all order
	 * OrderListVo is some information for each order.
	 * this method is a list of OrderListVo
	 * Vo contains a lot of info.and Vo contains a OrderEachItem List,which is the decribe of shopping car.
	 * 
	 * this method is not final method.final method should accept a UserProfile,but I don't do it because the UserProfile 
	 * is other members' result.I mock a Userprofile to test it.
	 * 
	 * @return
	 */
	public List<OrderListVo> getAllOrderWhenLoadPage(){
		List<OrderListVo> orderlist = new ArrayList<OrderListVo>();
		System.out.println("receive load all users' oders when load usercenter page..................");
		System.out.println("handling.................");
		UserProfile userProfile = new UserProfile();
		userProfile.setUserProfileId(50l);
		List<Order> orders = orderService.getAllOrderByUserProfile(userProfile);	
		System.out.println("orders' amount:"+orders.size());
		System.out.println(orders.get(0).getOrderItems().size());
		for (Order order : orders) {
			OrderListVo o = new OrderListVo();
			Store s = storeService.getStoreById(order.getStoreId());
			o.setStoreName(s.getStoreName());
			o.setPhone(s.getPhone());
			o.setLogoPicUrl(s.getLogoPicUrl());
			o.setOrderNumber(order.getOrderNumber());
			o.setCreateTime(order.getCreateTime());
			o.setStatus(order.getStatus());
			List<OrderEachItem> orderEachItemList = new ArrayList<OrderEachItem>();
			List<OrderItem> orderItemList = order.getOrderItems();
			for (OrderItem orderItem : orderItemList) {
				OrderEachItem oo = new OrderEachItem();
				oo.setProductName(	orderItem.getProduct().getProductName());
				oo.setProductId(orderItem.getProduct().getProductId());
				oo.setPrice(orderItem.getProduct().getPrice());
				orderEachItemList.add(oo);
			}
			o.setOrderEachItemList(orderEachItemList);
			o.setContacterName(order.getContacterName());
			o.setContacterPhone(order.getContacterPhone());
			o.setDetailLocation(order.getDetailLocation());
			o.setRemarks(order.getRemarks());
			if(order.getComment()==null){
				o.setContext(null);
			}else{
				o.setContext(order.getComment().getContext());
			}


			orderlist.add(o);
			
		}
		
		return orderlist;

	}
	
	
	@RequestMapping(value="/getUserProfile.do",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public UserInformationVo getUserProfileBy(){
		System.out.println("receive load user's personal info by accountId..........");
		System.out.println("handling............");
		Account a = accountService.getAccountByAccountId(50L);
		UserInformationVo userInformationVo = new UserInformationVo();
		userInformationVo.setUname(a.getUsername());
		userInformationVo.setPassword(a.getPassword());
		userInformationVo.setFund(a.getUserProfile().getFund());		
		return userInformationVo;
		
	}
	
	@RequestMapping(value="/changeUserProfile.do",produces={"application/json;charset=UTF-8"})
	public UserInformationVo changeUserProfile(){
		System.out.println("receive change user's password  by Account..........");
		System.out.println("handling............");
		Account account = new Account();
		account.setAccountId(50l);
		accountService.changePasswordByAccount(account, "123");
		UserInformationVo userInformationVo = new UserInformationVo();
		userInformationVo.setPassword("123");
		return userInformationVo;
	}
	
	
	@RequestMapping(value="/chargeUserFund.do",produces={"application/json;charset=UTF-8"})
	public UserInformationVo chargeUserFund(){
		System.out.println("receive charge user's fund  by UserPRofile..........");
		System.out.println("handling............");
		BigDecimal addFund = new BigDecimal("20");
		UserProfile u = userProfileService.chargeUserProfileFundByProfileId(50l, addFund);
		UserInformationVo userInformationVo = new UserInformationVo();
		userInformationVo.setFund(u.getFund());
		return userInformationVo;
	}
	
	@RequestMapping(value="/getUserFavVendor.do",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<UserFavVendorsVo> getUserFavVendor(){
		List<UserFavVendorsVo> userFavVendorsVoList = new ArrayList<UserFavVendorsVo>();
		System.out.println("receive get user's favorite vendors  by UserProfile..........");
		System.out.println("handling............");
		List<Collect> vendors = userProfileService.getUserCollectVendorByProfileId(50L);
		for (Collect collect : vendors) {
			System.out.println(collect.getCollectId()+collect.getStore().getStoreName());
			UserFavVendorsVo u = new UserFavVendorsVo();
			Store s = collect.getStore();
			u.setStoreName(s.getStoreName());
			u.setServiceBeginTime(s.getServiceBeginTime());
			u.setServiceEndTime(s.getServiceEndTime());
			u.setLogoPicUrl(s.getLogoPicUrl());
			u.setDetailLocation(s.getDetailLocation());
			u.setPhone(s.getPhone());
			List<Order> orders = orderService.getAllOrderByStoreId(s.getStoreId());
			u.setOrderAmount(new BigDecimal(orders.size()));
			Long  l = collectService.findAllCollectsByStore(s);
			u.setCollectAmount(new BigDecimal(l));
			
			userFavVendorsVoList.add(u);
		}
		return userFavVendorsVoList;
	}
	
	@RequestMapping(value="/cancelUserFavVendor.do",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public void cancelUserFavVendor(){
		System.out.println("receive cancel user's favorite vendor  by storeId..........");
		System.out.println("handling............");
		UserProfile user = userProfileService.getUserProfilebyId(50L);
		
		List<Collect> collects = user.getCollects();
		for (Collect collect : collects) {
			if(collect.getStore().getStoreId()==50L){
				System.out.println("find this collect"+collect.getCollectId());
				collectService.updateCollectNode(collect);
				break;
			}
		}
	}
	
	
	
	
	
	
	
}
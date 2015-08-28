package com.group.tto.main.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Collect;
import com.group.tto.cmn.model.Comment;
import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.OrderItem;
import com.group.tto.cmn.model.Store;
import com.group.tto.cmn.model.UserProfile;
import com.group.tto.main.common.Constants;
import com.group.tto.main.service.AccountService;
import com.group.tto.main.service.CollectService;
import com.group.tto.main.service.CommentService;
import com.group.tto.main.service.OrderService;
import com.group.tto.main.service.StoreService;
import com.group.tto.main.service.UserProfileService;
import com.group.tto.main.vo.MerProsList;
import com.group.tto.main.vo.OrderEachItem;
import com.group.tto.main.vo.OrderListVo;
import com.group.tto.main.vo.UserFavVendorsVo;
import com.group.tto.main.vo.UserInformationVo;

@Controller
@RequestMapping(value = "/usercenter")
public class UserCenterController extends BaseController {

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
  @Autowired
  private CommentService commentService;


  @Override
  protected String getName() {
    return "main/usercenter";
  }


  @RequestMapping(value = "/getAllUser.do", produces = {"application/json;charset=UTF-8"})
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
  public List<OrderListVo> getAllOrderWhenLoadPage(HttpServletRequest request) {
    List<OrderListVo> orderlist = new ArrayList<OrderListVo>();
    Account a = (Account) request.getSession().getAttribute(Constants.SESSION_LOGIN_INFO);
    UserProfile userProfile = a.getUserProfile();
    List<Order> orders = orderService.getAllOrderByUserProfile(userProfile);
    if (orders.size() < 1) {
      return null;
    }
    for (Order order : orders) {
      OrderListVo o = new OrderListVo();
      MerProsList s = storeService.getStoreById(order.getStoreId());
      o.setOrderId(order.getOrderId());
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
        oo.setProductName(orderItem.getProduct().getProductName());
        oo.setAmount(orderItem.getAmount());
        oo.setPrice(orderItem.getProduct().getPrice());
        orderEachItemList.add(oo);
      }
      o.setOrderEachItemList(orderEachItemList);
      o.setContacterName(order.getContacterName());
      o.setContacterPhone(order.getContacterPhone());
      o.setDetailLocation(order.getDetailLocation());
      o.setRemarks(order.getRemarks());
      Comment c = order.getComment();
      if (c == null) {
        o.setContext(null);
      } else {
        o.setContext(order.getComment().getContext());
        o.setDeliverTime(c.getDeliverTime());
        o.setPoint(c.getPoint());
      }
      orderlist.add(o);
    }
    return orderlist;
  }


  @RequestMapping(value = "/getUserProfile.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public UserInformationVo getUserProfileBy(HttpServletRequest request) {
    Account a = (Account) request.getSession().getAttribute(Constants.SESSION_LOGIN_INFO);
    UserInformationVo userInformationVo = new UserInformationVo();
    userInformationVo.setUname(a.getUsername());
    userInformationVo.setPassword(a.getPassword());
    userInformationVo.setFund(a.getUserProfile().getFund());
    return userInformationVo;

  }

  @RequestMapping(value = "/changeUserProfile.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String changeUserProfile(String newPassword, HttpServletRequest request) {
    Boolean flag = false;
    if (newPassword != null) {
      Account account = (Account) request.getSession().getAttribute(Constants.SESSION_LOGIN_INFO);
      if (account != null) {
        flag = true;
        accountService.changePasswordByAccount(account, newPassword);
        request.getSession().setAttribute(Constants.SESSION_LOGIN_INFO, account);
      }
    }
    return this.getResultJSON(flag, "");
  }



  @RequestMapping(value = "/chargeUserFund.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public UserInformationVo chargeUserFund(HttpServletRequest request, String addMoney) {
    Account a = (Account) request.getSession().getAttribute(Constants.SESSION_LOGIN_INFO);
    UserProfile userProfile = a.getUserProfile();
    BigDecimal addFund = new BigDecimal(Integer.valueOf(addMoney));
    UserProfile u =
        userProfileService
            .chargeUserProfileFundByProfileId(userProfile.getUserProfileId(), addFund);
    UserInformationVo userInformationVo = new UserInformationVo();
    userInformationVo.setFund(u.getFund());
    return userInformationVo;
  }

  @RequestMapping(value = "/getUserFavVendor.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public List<UserFavVendorsVo> getUserFavVendor(HttpServletRequest request) {

    Account a = (Account) request.getSession().getAttribute(Constants.SESSION_LOGIN_INFO);
    List<UserFavVendorsVo> userFavVendorsVoList =
        storeService.getStoresByUserProfileId(a.getUserProfile().getUserProfileId());

    return userFavVendorsVoList;
  }

  @RequestMapping(value = "/cancelUserFavVendor.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public UserInformationVo cancelUserFavVendor(HttpServletRequest request, Long storeId) {
    Account a = (Account) request.getSession().getAttribute(Constants.SESSION_LOGIN_INFO);
    UserProfile user = a.getUserProfile();
    Long userId = user.getUserProfileId();
    this.collectService.removeCollect(storeId, userId);
    UserInformationVo userInformationVo = new UserInformationVo();
    return userInformationVo;
  }


  @RequestMapping(value = "/saveComment.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String saveComment(String context, String point, String deliverTime, Long orderId,
      HttpServletRequest request) {
    Account account = (Account) request.getSession().getAttribute(Constants.SESSION_LOGIN_INFO);
    if (account != null) {
      boolean result =
          this.commentService.createComment(context, new BigDecimal(point), new BigDecimal(
              deliverTime), account.getUserProfile().getUserProfileId(), orderId);
      return this.getResultJSON(result, "");
    } else {
      return this.getResultJSON(false, "");
    }
  }


  @RequestMapping(value = "/cancelOrder.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String cancelOrder(String orderId) {
    Boolean result = orderService.cancelOrderById(Long.valueOf(orderId));
    return this.getResultJSON(result, "");
  }

  @RequestMapping(value = "/confirmOrder.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String confirmOrder(String orderId) {
    Boolean result = orderService.confirmOrderById(Long.valueOf(orderId));
    return this.getResultJSON(result, "");
  }

}

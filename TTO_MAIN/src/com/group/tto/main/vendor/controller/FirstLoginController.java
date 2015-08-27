package com.group.tto.main.vendor.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Store;
import com.group.tto.main.common.Constants;
import com.group.tto.main.vendor.service.FirstLoginService;

@Controller
@RequestMapping("/vendor/firstLogin")
public class FirstLoginController extends BaseController{

  @Autowired
  private FirstLoginService fl;

  @RequestMapping(value = "/verify.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String verifyFirstLogin(HttpServletRequest req) {
    Account loginConsumer = (Account) req.getSession().getAttribute(Constants.SESSION_LOGIN_INFO);
    long uid = loginConsumer.getAccountId();
    
    Store store=fl.getStore((int) uid);
    req.getSession().setAttribute("sid", store.getStoreId());
    
    if(store.getServiceBeginTime()==null ||store.getServiceEndTime()==null)
      return this.getResultJSON(false, "");
    else
      return this.getResultJSON(true, "");

  }

  public FirstLoginService getFl() {
    return fl;
  }

  public void setFl(FirstLoginService fl) {
    this.fl = fl;
  }

  @Override
  protected String getName() {
    
    return null;
  }

}

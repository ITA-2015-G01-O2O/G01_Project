package com.group.tto.main.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Store;
import com.group.tto.cmn.type.StopProfileStatus;
import com.group.tto.main.common.Constants;
import com.group.tto.main.service.AccountService;



@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {
	@Autowired
	  private AccountService accountService;
	
	
	@RequestMapping(value = "/login.do", produces = {"application/json;charset=UTF-8"})
	  @ResponseBody
	  public String login(String loginname, String password, HttpServletRequest request) {
		if (this.accountService.contains(loginname)) {
	    	Account db = this.accountService.login(loginname, password);
	      if (db == null) {
	        return this.getResultJSON(false, "tip.error.psw");
	      } else if (isDuplicate(db, request)) {
	        return this.getResultJSON(true, "");
	      } else {
	        List<Account> loginAdmin =
	            (List<Account>) request.getServletContext().getAttribute(Constants.CONTEXT_LOGIN_INFO);
	       
	        loginAdmin.add(db);
	        request.getSession().setAttribute("mainName", db.getUsername());
	        request.getSession().setAttribute(Constants.SESSION_LOGIN_INFO, db);
	        return this.getResultJSON(true, "");
	      }
	    } else {
	      return this.getResultJSON(false, "tip.error.nofound");
	    }
	  }

	  private boolean isDuplicate(Account admin, HttpServletRequest request) {
	    List<Account> loginMain =
	        (List<Account>) request.getServletContext().getAttribute(Constants.CONTEXT_LOGIN_INFO);
	    if (loginMain == null) {
	    	loginMain = new ArrayList<Account>();
	      request.getServletContext().setAttribute(Constants.CONTEXT_LOGIN_INFO, loginMain);
	      return false;
	    }
	    for (Account temp : loginMain) {
	      if (temp.getUsername().equals(admin.getUsername())) {
	        return true;
	      }
	    }
	    return false;
	  }
	
	  @RequestMapping(value = "/register.do", produces = {"application/json;charset=UTF-8"})
      @ResponseBody
      public String register(String to_username, String to_password) {
        String loginname=to_username;
            String password=to_password;
        if (this.accountService.contains(loginname)) {
          return this.getResultJSON(false, "tip.error.exist");
        } else  if(loginname==null || password==null){
          return this.getResultJSON(false, "tip.error.notnull");
        }else{
          this.accountService.register(loginname, password);
          return this.getResultJSON(true, "tip.success.create");
        }
      }
	  
	  @RequestMapping(value = "/getMainName.do", produces = {"application/json;charset=UTF-8"})
      @ResponseBody
      public String getMainName(HttpServletRequest request) {
	    List<Account> loginMain =
	        (List<Account>) request.getServletContext().getAttribute(Constants.CONTEXT_LOGIN_INFO);

	    Account loginConsumer = (Account) request.getSession().getAttribute(Constants.SESSION_LOGIN_INFO);
	    String loginName = null;
	    boolean flag = false;
	    if (loginConsumer != null) {
	      if (loginMain != null) {
	        for (Account temp : loginMain) {
	          if (temp.getUsername().equals(loginConsumer.getUsername())) {
	            flag = true;
	            loginName=temp.getUsername();
	          }
	        }
	      }
	    }
	    String data = this.getResultJSON(flag, loginName);
         return data;
      }
	  
	  @RequestMapping(value = "/isStore.do", produces = {"application/json;charset=UTF-8"})
      @ResponseBody
      public String isStore(HttpServletRequest request) {
        List<Account> loginMain =
            (List<Account>) request.getServletContext().getAttribute(Constants.CONTEXT_LOGIN_INFO);

        Account loginConsumer = (Account) request.getSession().getAttribute(Constants.SESSION_LOGIN_INFO);
        String status = null;
        boolean flag = false;
        if (loginConsumer != null) {
          if (loginMain != null) {
            for (Account temp : loginMain) {
              if (temp.getUsername().equals(loginConsumer.getUsername())) {
                //flag = true;
                if(temp.getStore()!=null){
                  flag = true;
                    if(temp.getStore().getStoreProfile().getStatus().equals(StopProfileStatus.NORMAL.name())){
                      status="NORMAL";
                    }else if(temp.getStore().getStoreProfile().getStatus().equals(StopProfileStatus.CHECK.name())){
                      status="CHECK";
                    }if(temp.getStore().getStoreProfile().getStatus().equals(StopProfileStatus.FREEZE.name())){
                      status="FREEZE";
                    }
      
                }
              }
            }
          }
        }
        String data = this.getResultJSON(flag, status);
         return data;
      }
	  @RequestMapping(value = "/logout.do", produces = {"application/json;charset=UTF-8"})
	  @ResponseBody
	  public String logout(HttpServletRequest request) {
	    request.getSession().invalidate();
	    return "{}";
	  }
	  
	  
	@Override
	protected String getName() {
		return "main/consumer";
	}
	
	@RequestMapping(value = "/getAllproByMerId.action", method = { RequestMethod.POST }, produces = { "application/json;charset=UTF-8" })
	public void showMerAllpros(String merId,OutputStream out){
		List<Store> store=null;
	}

}

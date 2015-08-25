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
import com.group.tto.main.common.COMMON;
import com.group.tto.main.service.AccountService;



@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {
	@Autowired
	  private AccountService accountService;
	
	
	@RequestMapping(value = "/login.do", produces = {"application/json;charset=UTF-8"})
	  @ResponseBody
	  public String login(String loginname, String password, HttpServletRequest request) {
		System.out.println(loginname);
		System.out.println(password);
		if (this.accountService.contains(loginname)) {
	    	Account db = this.accountService.login(loginname, password);
	      if (db == null) {
	        return this.getResultJSON(false, "tip.error.psw");
	      } else if (isDuplicate(db, request)) {
	        return this.getResultJSON(true, "");
	      } else {
	        List<Account> loginAdmin =
	            (List<Account>) request.getServletContext().getAttribute(COMMON.CONTEXT_LOGIN_INFO);
	       
	        loginAdmin.add(db);
	        
	        request.getSession().setAttribute(COMMON.SESSION_LOGIN_INFO, db);
	        return this.getResultJSON(true, "");
	      }
	    } else {
	      return this.getResultJSON(false, "tip.error.nofound");
	    }
	  }

	  private boolean isDuplicate(Account admin, HttpServletRequest request) {
	    List<Account> loginMain =
	        (List<Account>) request.getServletContext().getAttribute(COMMON.CONTEXT_LOGIN_INFO);
	    if (loginMain == null) {
	    	loginMain = new ArrayList<Account>();
	      request.getServletContext().setAttribute(COMMON.CONTEXT_LOGIN_INFO, loginMain);
	      return false;
	    }
	    for (Account temp : loginMain) {
	      if (temp.getUsername().equals(admin.getUsername())) {
	        return true;
	      }
	    }
	    return false;
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

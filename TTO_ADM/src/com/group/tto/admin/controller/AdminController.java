package com.group.tto.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.admin.cmn.TTOConstants;
import com.group.tto.admin.service.AdminService;
import com.group.tto.cmn.model.Admin;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

  @Autowired
  private AdminService adminSerice;

  @RequestMapping(value = "/login.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String login(String loginname, String password, HttpServletRequest request) {
    if (this.adminSerice.contains(loginname)) {
      Admin db = this.adminSerice.login(loginname, password);
      if (db == null) {
        return this.getResultJSON(false, "tip.error.psw");
      } else if (isDuplicate(db, request)) {
        return this.getResultJSON(false, "tip.error.login");
      } else {
        List<Admin> loginAdmin =
            (List<Admin>) request.getServletContext().getAttribute(TTOConstants.CONTEXT_LOGIN_INFO);
        loginAdmin.add(db);
        request.getSession().setAttribute(TTOConstants.SESSION_LOGIN_INFO, db);
        return this.getResultJSON(true, "");
      }
    } else {
      return this.getResultJSON(false, "tip.error.nofound");
    }
  }

  private boolean isDuplicate(Admin admin, HttpServletRequest request) {
    List<Admin> loginAdmin =
        (List<Admin>) request.getServletContext().getAttribute(TTOConstants.CONTEXT_LOGIN_INFO);
    if (loginAdmin == null) {
      loginAdmin = new ArrayList<Admin>();
      request.getServletContext().setAttribute(TTOConstants.CONTEXT_LOGIN_INFO, loginAdmin);
      return false;
    }
    for (Admin temp : loginAdmin) {
      if (temp.getAdminId().equals(admin.getAdminId())) {
        return true;
      }
    }
    return false;
  }

  @Override
  protected String getName() {
    return "admin";
  }

  public AdminService getAdminSerice() {
    return adminSerice;
  }

  public void setAdminSerice(AdminService adminSerice) {
    this.adminSerice = adminSerice;
  }


}

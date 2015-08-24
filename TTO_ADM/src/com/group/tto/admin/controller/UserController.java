package com.group.tto.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.admin.cmn.UserSearchCriteria;
import com.group.tto.admin.dto.PageDTO;
import com.group.tto.admin.service.UserService;
import com.group.tto.cmn.model.Account;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

  @Autowired
  private UserService service;

  @Override
  protected String getName() {
    return "user";
  }

  @RequestMapping(value = "/load.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public PageDTO<Account> load(UserSearchCriteria searchCriteria) {
    return this.service.get(searchCriteria);
  }

  @RequestMapping(value = "/resetPsw.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String resetPsw(Long id) {
    this.service.resetPassword(id);
    return this.getResultJSON(true, "");
  }

}

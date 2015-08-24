package com.group.tto.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.admin.cmn.UserSearchCriteria;
import com.group.tto.admin.dto.PageDTO;
import com.group.tto.admin.service.UserService;
import com.group.tto.admin.vo.UserSearchVo;
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
  public PageDTO<UserSearchVo> load(UserSearchCriteria searchCriteria) {
    return this.converToSearchVo(this.service.get(searchCriteria));
  }

  @RequestMapping(value = "/resetPsw.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String resetPsw(Long id) {
    this.service.resetPassword(id);
    return this.getResultJSON(true, "");
  }

  private PageDTO<UserSearchVo> converToSearchVo(PageDTO<Account> data) {
    PageDTO<UserSearchVo> page = new PageDTO<UserSearchVo>();
    List<UserSearchVo> vos = new ArrayList<UserSearchVo>();
    for (Account account : data.getDatas()) {
      vos.add(new UserSearchVo(account));
    }
    page.setLimit(data.getLimit());
    page.setStart(data.getStart());
    page.setTotal(data.getTotal());
    page.setDatas(vos);
    return page;
  }

}

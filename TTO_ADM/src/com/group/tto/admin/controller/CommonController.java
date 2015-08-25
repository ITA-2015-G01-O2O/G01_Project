package com.group.tto.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonController {

  @RequestMapping(value = "/logout.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String logout(HttpServletRequest request) {
    request.getSession().invalidate();
    return "{}";

  }

}

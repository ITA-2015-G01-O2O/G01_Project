package com.group.tto.main.vendor.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.cmn.model.StoreProfile;
import com.group.tto.main.vendor.service.PersonalInfoService;

@Controller
@RequestMapping("/personalInfo")
public class PersonalInfoController extends BaseController {
  @Autowired
  private PersonalInfoService pi;

  @RequestMapping(value = "/load.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String loadPersonalInfo(HttpServletRequest req) {
    int sid = (int) req.getSession().getAttribute("sid");
    StoreProfile sp = pi.loadPersonInfo(sid);
    return this.getResultJSON(true, sp);

  }

  public PersonalInfoService getPi() {
    return pi;
  }

  public void setPi(PersonalInfoService pi) {
    this.pi = pi;
  }

  @Override
  protected String getName() {
    return "personalInfo";
  }

}

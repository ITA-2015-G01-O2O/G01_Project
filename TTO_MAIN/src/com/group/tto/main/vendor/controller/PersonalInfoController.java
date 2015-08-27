package com.group.tto.main.vendor.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.cmn.model.StoreProfile;
import com.group.tto.main.vendor.service.PersonalInfoService;
import com.group.tto.main.vo.PersonalInfo;

@Controller
@RequestMapping("/vendor/personalInfo")
public class PersonalInfoController extends BaseController {
  @Autowired
  private PersonalInfoService pi;

  @RequestMapping(value = "/load.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String loadPersonalInfo(HttpServletRequest req) {
    //int sid = (int) req.getSession().getAttribute("sid");
    int sid=2050;
    StoreProfile sp = pi.loadPersonInfo(sid);
    
    PersonalInfo pi=new PersonalInfo();
    pi.setRealName(sp.getRealName());
    pi.setIdCardNumber(sp.getIdCardNumber());
    
    String json=this.getResultJSON(true, pi);
    System.out.println(json);
    
    return json;

  }

  public PersonalInfoService getPi() {
    return pi;
  }

  public void setPi(PersonalInfoService pi) {
    this.pi = pi;
  }

  @Override
  protected String getName() {
    return "main/vendor";
  }

}

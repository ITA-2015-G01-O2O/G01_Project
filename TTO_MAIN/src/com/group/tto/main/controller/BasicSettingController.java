package com.group.tto.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.main.vendor.controller.BaseController;
import com.group.tto.main.vendor.service.BasicSettingService;

@Controller
@RequestMapping("/basicSetting")
public class BasicSettingController extends BaseController {
  @Autowired
  private BasicSettingService bs;
  
  @RequestMapping(value = "/load.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public void loadBasicSetting(HttpServletRequest req){
    String announcement=req.getParameter("announcement");
    String minPrice=req.getParameter("minPrice");
    String shipment=req.getParameter("shipment");
    String starttime=req.getParameter("starttime");
  }
  
  
  public BasicSettingService getBs() {
    return bs;
  }

  public void setBs(BasicSettingService bs) {
    this.bs = bs;
  }

  @Override
  protected String getName() {
    
    return "basicSetting";
  }

}

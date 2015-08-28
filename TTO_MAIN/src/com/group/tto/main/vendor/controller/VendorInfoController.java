package com.group.tto.main.vendor.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.main.vendor.service.VendorInfoService;
import com.group.tto.main.vo.VendorInfo;

@Controller
@RequestMapping(value = "/vendor/info")
public class VendorInfoController extends BaseController {
  @Autowired
  private VendorInfoService vi;

  @RequestMapping(value = "/getVendorInfo.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String getUserProfileBy(HttpServletRequest req) {
	  try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    long sid = (long) req.getSession().getAttribute("sid");
    //int sid=50;
    VendorInfo v = vi.getVendorInfo((int) sid);
    req.getSession().setAttribute("avgPoint", v.getAvgPoint());
    req.getSession().setAttribute("avgTime", v.getAvgDeliverTime());
    req.getSession().setAttribute("storeName", v.getStoreName());
    req.getSession().setAttribute("collectionNum", v.getCollectionNum());
    return this.getResultJSON(true, v);
  }

  @Override
  protected String getName() {
    return "main/vendor";
  }

  public VendorInfoService getVi() {
    return vi;
  }

  public void setVi(VendorInfoService vi) {
    this.vi = vi;
  }

}

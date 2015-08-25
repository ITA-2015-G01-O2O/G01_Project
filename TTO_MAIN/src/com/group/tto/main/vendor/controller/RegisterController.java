package com.group.tto.main.vendor.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Configuration;
import com.group.tto.cmn.model.Location;
import com.group.tto.cmn.model.Store;
import com.group.tto.cmn.model.StoreProfile;
import com.group.tto.cmn.type.StopProfileStatus;
import com.group.tto.main.common.COMMON;
import com.group.tto.main.vendor.service.VendorRegisterService;

@Controller
@RequestMapping("/vendorregister")
public class RegisterController extends BaseController {
  @Autowired
  private VendorRegisterService vr;

  @RequestMapping(value = "/register1.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public void register1(HttpServletRequest req) {
    String phone = req.getParameter("phone");
    Store store = new Store();
    store.setPhone(phone);
    req.getSession().setAttribute("store", store);
  }

  @RequestMapping(value = "/register2.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public void register2(HttpServletRequest req) {
    Store store = (Store) req.getSession().getAttribute("store");
    String addr1 = req.getParameter("addr1");
    String addr2 = req.getParameter("addr2");
    String type = req.getParameter("type");
    String storeName = req.getParameter("storename");

    String[] addrs = addr1.split(",");
    String area = addrs[0];
    String city = addrs[1];
    String place = addrs[2];
    int num = vr.getLocation(area, place, city);
    Location l = new Location();
    l.setLocationId((long) num);
    l.setArea(area);
    l.setCity(city);
    l.setPlace(place);
    store.setLocation(l);

    store.setStoreName(storeName);
    store.setDetailLocation(addr2);

    Configuration con = vr.getConfiguration(type);
    store.setTypeConfig(con);

    req.getSession().setAttribute("store", store);
  }

  @RequestMapping(value = "/register3.do")
  @ResponseBody
  public ModelAndView register3(HttpServletRequest req,
      @RequestParam(value = "idcardpic") MultipartFile pic1,
      @RequestParam(value = "licensepic") MultipartFile pic2) {
    Store store = (Store) req.getSession().getAttribute("store");
    String realName = req.getParameter("realname");
    String idcardNumber = req.getParameter("idcardnumber");
    // wrong
    String picName1 = UUID.randomUUID().toString();
    String picName2 = UUID.randomUUID().toString();
    try {
      pic1.transferTo(new File(picName1));
      pic2.transferTo(new File(picName2));
    } catch (IOException e) {
      e.printStackTrace();
    }

    StoreProfile sp = new StoreProfile();
    sp.setRealName(realName);
    sp.setIdCardNumber(idcardNumber);
    sp.setIdCardPicUrl(picName1);
    sp.setLicensePicUrl(picName2);
    sp.setIsDelete(false);
    sp.setStatus(StopProfileStatus.CHECK.name());
    sp.setVersion(1l);
    
    store.setStoreProfile(sp);
    store.setVersion(1l);
    store.setIsHot(false);
    store.setIsDelete(false);
    
    Account loginConsumer = (Account) req.getSession().getAttribute(COMMON.SESSION_LOGIN_INFO);
    long uid=loginConsumer.getAccountId();
    int num=vr.storeRegister(store, (int)uid);
    
    ModelAndView mv=new ModelAndView();
    if(num==1)
      mv.setViewName("vendor/register3");
    else
      mv.setViewName("vendor/register1");
    
    return mv;
  }

  @Override
  protected String getName() {

    return "vendorregister";
  }

  public VendorRegisterService getVr() {
    return vr;
  }

  public void setVr(VendorRegisterService vr) {
    this.vr = vr;
  }

}

package com.group.tto.main.vendor.controller;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Configuration;
import com.group.tto.cmn.model.Location;
import com.group.tto.cmn.model.Store;
import com.group.tto.cmn.model.StoreProfile;
import com.group.tto.cmn.type.StopProfileStatus;
import com.group.tto.main.common.Constants;
import com.group.tto.main.vendor.service.VendorRegisterService;

@Controller
@RequestMapping("/vendor/register")
public class RegisterController extends BaseController {
  @Autowired
  private VendorRegisterService vr;

  @RequestMapping(value = "/register1.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String register1(HttpServletRequest req) {
    String phone = req.getParameter("phone");
    Store store = new Store();
    store.setPhone(phone);
    req.getSession().setAttribute("store", store);
    return this.getResultJSON(true, "");
  }

  @RequestMapping(value = "/register2.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String register2(HttpServletRequest req) {
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
    BigDecimal avg = new BigDecimal(0);
    store.setAvgDeliverTime(avg);
    store.setAvgPoint(avg);

    Configuration con = vr.getConfiguration(type);
    store.setTypeConfig(con);

    req.getSession().setAttribute("store", store);
    return this.getResultJSON(true, "");
  }

  @RequestMapping(value = "/register3.do")
  public String register3(HttpServletRequest req,
      @RequestParam(value = "idcardpic") CommonsMultipartFile pic1,
      @RequestParam(value = "licensepic") CommonsMultipartFile pic2) {
    Store store = (Store) req.getSession().getAttribute("store");
    String realName = req.getParameter("realname");
    String idcardNumber = req.getParameter("idcardnumber");

    String picName1 = UUID.randomUUID().toString();
    String picName2 = UUID.randomUUID().toString();
    InputStream is1 = null;
    InputStream is2 = null;
    try {
      is1 = pic1.getInputStream();
      is2 = pic2.getInputStream();
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

    BigDecimal fee = new BigDecimal(0);
    store.setDeliverFee(fee);
    store.setStartingFee(fee);

    Account loginConsumer = (Account) req.getSession().getAttribute(Constants.SESSION_LOGIN_INFO);
    long uid = loginConsumer.getAccountId();
    //long uid = 52l;
    int num = vr.storeRegister(store, (int) uid, picName1, is1, picName2, is2);
    if (num == 1)
      return "redirect:/vendor/register/register4.view";
    else
      return "redirect:/vendor/register/register1.view";
  }

  @RequestMapping(value = "/loadCity.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String loadCity(HttpServletRequest req) {
    String area = req.getParameter("area");
    List<String> locations = vr.getCity(area);

    return this.getResultJSON(true, locations);
  }

  @RequestMapping(value = "/loadPlace.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String loadPlace(HttpServletRequest req) {
    String city = req.getParameter("city");
    List<Location> locations = vr.getPlace(city);

    return this.getResultJSON(true, locations);
  }

  @RequestMapping(value = "/loadLocation.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String loadLocation(HttpServletRequest req) {
    List<String> locations = vr.getAllArea();

    return this.getResultJSON(true, locations);
  }

  @RequestMapping(value = "/loadConfig.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String loadConfig(HttpServletRequest req) {
    List<Configuration> cons = vr.getAllConfig();

    return this.getResultJSON(true, cons);
  }

  @Override
  protected String getName() {

    return "main/vendor";
  }

  public VendorRegisterService getVr() {
    return vr;
  }

  public void setVr(VendorRegisterService vr) {
    this.vr = vr;
  }

}

package com.group.tto.main.vendor.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.cmn.model.Store;
import com.group.tto.main.vendor.service.BasicSettingService;

@Controller
@RequestMapping("/basicSetting")
public class BasicSettingController extends BaseController {
  @Autowired
  private BasicSettingService bs;

  @RequestMapping(value = "/update.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String updateBasicSetting(HttpServletRequest req) {
    //int sid = (int) req.getSession().getAttribute("sid");
    int sid=2050;
    String announcement = req.getParameter("announcement");
    String minPrice = req.getParameter("minPrice");
    String shipment = req.getParameter("shipment");
    String starttime = req.getParameter("starttime");
    String finishtime = req.getParameter("finishtime");

    Store store = new Store();
    store.setAnnouncement(announcement);
    BigDecimal startingFee = new BigDecimal(minPrice);
    store.setStartingFee(startingFee);
    BigDecimal deliverFee = new BigDecimal(shipment);
    store.setDeliverFee(deliverFee);

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    Date beginTime = null;
    Date endTime = null;
    try {
      beginTime = sdf.parse(starttime);
      endTime = sdf.parse(finishtime);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    store.setServiceBeginTime(beginTime);
    store.setServiceEndTime(endTime);

    int num = bs.updateBasicSetting(sid, store);
    return this.getResultJSON(true, num);
  }

  @RequestMapping(value = "/load.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String loadBasicSetting(HttpServletRequest req) {
    //int sid = (int) req.getSession().getAttribute("sid");
    int sid=2050;
    Store store=bs.loadBasicSetting(sid);
    
    return this.getResultJSON(true, store);

  }

  public BasicSettingService getBs() {
    return bs;
  }

  public void setBs(BasicSettingService bs) {
    this.bs = bs;
  }

  @Override
  protected String getName() {

    return "main/vendor";
  }

}

package com.group.tto.main.vendor.controller;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.group.tto.cmn.model.Store;
import com.group.tto.main.vendor.service.CompleteInfoService;

@Controller
@RequestMapping("/completeInfo")
public class CompleteInfoController extends BaseController {

  @Autowired
  private CompleteInfoService ci;

  @RequestMapping(value = "/update.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String completeInfo(HttpServletRequest req,
      @RequestParam(value = "logopic") CommonsMultipartFile pic) {
    int sid = (int) req.getSession().getAttribute("sid");
    //int sid = 2050;
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

    String filename = UUID.randomUUID().toString();
    InputStream is1 = null;
    try {
      is1 = pic.getInputStream();
    } catch (IOException e) {
      e.printStackTrace();
    }
    store.setLogoPicUrl(filename);



    int num = ci.updateStoreInfo(store, sid, filename, is1);
    return this.getResultJSON(true, num);

  }

  public CompleteInfoService getCi() {
    return ci;
  }

  public void setCi(CompleteInfoService ci) {
    this.ci = ci;
  }

  @Override
  protected String getName() {
    return "main/vendor";
  }

}

package com.group.tto.main.vendor.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.group.tto.cmn.model.Store;
import com.group.tto.main.vendor.service.CompleteInfoService;

@Controller
@RequestMapping("/completeInfo")
public class CompleteInfoController extends BaseController {

  @Autowired
  private CompleteInfoService ci;

  @RequestMapping(value = "/update.do")
  @ResponseBody
  public ModelAndView completeInfo(HttpServletRequest req,
      @RequestParam(value = "logopic") MultipartFile pic) {
    int sid = (int) req.getSession().getAttribute("sid");
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
    try {
      pic.transferTo(new File(filename));
    } catch (IOException e) {
      e.printStackTrace();
    }
    store.setLogoPicUrl(filename);

    int num = ci.updateStoreInfo(store, sid);
    ModelAndView mv;
    if (num == 1)
      mv = new ModelAndView("vendor/NewOrder");
    else {
      mv = new ModelAndView("vendor/complete", "wmsg", "Option fail!");
    }
    return mv;

  }

  public CompleteInfoService getCi() {
    return ci;
  }

  public void setCi(CompleteInfoService ci) {
    this.ci = ci;
  }

  @Override
  protected String getName() {
    return "completeInfo";
  }

}

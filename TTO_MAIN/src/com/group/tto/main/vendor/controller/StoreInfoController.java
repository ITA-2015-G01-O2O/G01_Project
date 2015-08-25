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

import com.group.tto.cmn.model.Store;
import com.group.tto.main.vendor.service.StoreInfoService;

@Controller
@RequestMapping("/storeInfo")
public class StoreInfoController extends BaseController {

  @Autowired
  private StoreInfoService si;

  @RequestMapping(value = "/load.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String loadStoreInfo(HttpServletRequest req) {
    int sid = (int) req.getSession().getAttribute("sid");
    Store store = si.loadStoreInfo(sid);

    return this.getResultJSON(true, store);
  }

  @RequestMapping(value = "/update.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String updateStoreInfo(HttpServletRequest req,
      @RequestParam(value = "storeLogo") MultipartFile pic) {
    int sid = (int) req.getSession().getAttribute("sid");
    String address = req.getParameter("address");
    String storeName = req.getParameter("storename");
    // wrong
    String filename = UUID.randomUUID().toString();
    System.out.println(pic);
    try {
      pic.transferTo(new File(filename));
    } catch (IOException e) {
      e.printStackTrace();
    }
    Store store = new Store();
    store.getLocation().setPlace(address);
    store.setStoreName(storeName);
    store.setLogoPicUrl(filename);

    int num = si.updateStoreInfo(store, sid);

    return this.getResultJSON(true, num);
  }

  @Override
  protected String getName() {
    return "storeInfo";
  }

  public StoreInfoService getSi() {
    return si;
  }

  public void setSi(StoreInfoService si) {
    this.si = si;
  }

}

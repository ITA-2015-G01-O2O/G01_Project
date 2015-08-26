package com.group.tto.main.vendor.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.group.tto.cmn.model.Configuration;
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
    // int sid = (int) req.getSession().getAttribute("sid");
    int sid = 2050;
    Store store = si.loadStoreInfo(sid);

    return this.getResultJSON(true, store);
  }

  @RequestMapping(value = "/update.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String updateStoreInfo(HttpServletRequest req,
      @RequestParam(value = "storeLogo", required = false) MultipartFile pic) {
    // int sid = (int) req.getSession().getAttribute("sid");
    int sid = 2050;
    String storeName = req.getParameter("storename");
    String phone = req.getParameter("phone");
    String type = req.getParameter("type");
    String piclog=req.getParameter("piclog");
       
    int num=0;
    Store store = new Store();
    store.setStoreName(storeName);   
    store.setPhone(phone);
    
    Configuration con = si.getConfiguration(type);
    store.setTypeConfig(con);    
    
    if("1".equals(piclog)){
      String filename = UUID.randomUUID().toString();
      InputStream is = null;
      
      try {
        is = pic.getInputStream();
      } catch (IOException e) {
        e.printStackTrace();
      }
      store.setLogoPicUrl(filename);

      num = si.updateStoreInfo(store, sid, filename, is);
    }else{
      num=si.updateStoreInfo(store, sid);
    }
    
    return this.getResultJSON(true, num);
  }

  @Override
  protected String getName() {
    return "main/vendor";
  }

  public StoreInfoService getSi() {
    return si;
  }

  public void setSi(StoreInfoService si) {
    this.si = si;
  }

}

package com.group.tto.main.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Store;
import com.group.tto.main.common.COMMON;
import com.group.tto.main.service.AccountService;
import com.group.tto.main.service.StoreService;
import com.group.tto.main.vo.MerProsList;



@Controller
@RequestMapping("/consumer")
public class ConsumerController extends BaseController {
  @Autowired
  private StoreService storeService;

  @RequestMapping(value = "/getMerchantById.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String getMerProsById(String merId) {
    System.out.println("--------" + merId);
    Store store = this.storeService.getStoreById(Long.parseLong(merId));

    System.out.println("--------" + store);
    if (store == null) {
      store = new Store();
    }
    MerProsList merProsList = this.getMerProsListVo(store);
    String data = this.getResultJSON(true, merProsList);
    return data;
  }
  
  
  
  

  @RequestMapping(value = "/isConsumerLogin.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String isConsumerLogin(HttpServletRequest request) {

    List<Account> loginMain =
        (List<Account>) request.getServletContext().getAttribute(COMMON.CONTEXT_LOGIN_INFO);

    Account loginConsumer = (Account) request.getSession().getAttribute(COMMON.SESSION_LOGIN_INFO);

    boolean flag = false;
    if (loginConsumer != null) {
      if (loginMain != null) {
        for (Account temp : loginMain) {
          if (temp.getUsername().equals(loginConsumer.getUsername())) {
            flag = true;
          }
        }
      }
    }

    String data = this.getResultJSON(flag, "");
    return data;
  }


  public MerProsList getMerProsListVo(Store store) {
    MerProsList merProsList = new MerProsList(store);
    return merProsList;
  }

  @RequestMapping("/getMerprosById.view")
  public String getMerprosById(Long merId, Map map) {
    map.put("merId", merId);
    return this.getName() + "/showmerpros";
  }
  
  /**
  @RequestMapping("/confirmOrder.view")
  public String confirmOrder(String dataJson, Map map) {
    map.put("ordercomfirm", dataJson);
   System.out.println("dataJson-----------------------------"+dataJson);
    return this.getName() + "/confirmOrder";
  }**/


  @Override
  protected String getName() {
    // TODO Auto-generated method stub
    return "main/consumer";
  }

  @RequestMapping(value = "/getAllproByMerId.action", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
  public void showMerAllpros(String merId, OutputStream out) {
    List<Store> store = null;
  }

}

package com.group.tto.main.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Collect;
import com.group.tto.cmn.model.Store;
import com.group.tto.main.common.Constants;
import com.group.tto.main.service.CollectService;
import com.group.tto.main.service.StoreService;
import com.group.tto.main.vo.UserFavVendorsVo;

@Controller
@RequestMapping(value = "/collect")
public class CollectionController extends BaseController {

  @Autowired
  private CollectService collectService;
  @Autowired
  private StoreService storeService;

  @RequestMapping(value = "/addCollect.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String addCollect(Long storeId, HttpServletRequest request) {
    Account loginConsumer =
        (Account) request.getSession().getAttribute(Constants.SESSION_LOGIN_INFO);
    boolean flag = false;
    if (loginConsumer != null && storeId != 0l) {
      flag = true;
      List<UserFavVendorsVo> userFavVendorsVoList =
          storeService.getStoresByUserProfileId(loginConsumer.getUserProfile().getUserProfileId());
      System.out.println("--=--=---=--=-"+userFavVendorsVoList.size() );
      if (userFavVendorsVoList.size() == 0) {
        Collect c = new Collect();
        Store s = new Store();
        s.setStoreId(storeId);
        c.setStore(s);
        c.setUserProfile(loginConsumer.getUserProfile());
        collectService.addCollectNode(c);
      }
    }

    String data = this.getResultJSON(flag, "");
    return data;
  }



  @Override
  protected String getName() {
    // TODO Auto-generated method stub
    return null;
  }

}

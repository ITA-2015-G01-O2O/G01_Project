package com.group.tto.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.cmn.model.Store;
import com.group.tto.main.common.StoreSearchCriteria;
import com.group.tto.main.service.StoreService;
import com.group.tto.main.vo.StoreSearchVo;

@Controller
@RequestMapping("/stores")
public class StoreController extends BaseController {
  @Autowired
  private StoreService storeService;

  @RequestMapping(value = "/location",produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public List<StoreSearchVo> getStores(int location,String storeType,String sortType,String orderType) {    
    StoreSearchCriteria criteria = new StoreSearchCriteria();  
    criteria.setStoreLocation(location);
    criteria.setOrderType(orderType);
    criteria.setSortType(sortType);
    criteria.setStoreType(storeType);
    List<Store> list = storeService.getStoresbyCriteria(criteria);
    List<StoreSearchVo> voList = new ArrayList<StoreSearchVo>();
    for(Store store:list){
      voList.add(new StoreSearchVo(store));
    }
    return voList;
  }
  
  
  @Override
  protected String getName() {
    return "main/consumer";
  }

}

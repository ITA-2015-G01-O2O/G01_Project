package com.group.tto.main.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.OrderItem;
import com.group.tto.cmn.model.Product;
import com.group.tto.cmn.model.Store;
import com.group.tto.cmn.model.UserProfile;
import com.group.tto.cmn.type.OrderStatus;
import com.group.tto.cmn.type.PayWay;
import com.group.tto.main.common.Constants;
import com.group.tto.main.service.AccountService;
import com.group.tto.main.service.OrderService;
import com.group.tto.main.vo.CommentsVO;
import com.group.tto.main.vo.AddOrderVO;
import com.group.tto.main.vo.MerProsList;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
  @Autowired
  private OrderService orderService;

  @RequestMapping(value = "/addOrder.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String getMerProsById(String dataJson, String ausername, String auserPhone,
      String auseraddress, String remark, HttpServletRequest request) throws Exception {


    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    System.out.println("-------==-=-----=-=-"+dataJson);
    List<Map<String, Object>> list = mapper.readValue(dataJson, List.class);
    String data = null;
    if (list.size() > 0 && ausername != null && auserPhone != null && auseraddress != null) {
      List<AddOrderVO> vos = new ArrayList<AddOrderVO>();
      for (Map<String, Object> map : list) {
        vos.add(new AddOrderVO(map));
      }
      System.out.println("-------==-=-----=-=-"+vos.size());
      Order o = getOrder(ausername, auserPhone, auseraddress, remark, vos);
      
      
      
      Account loginConsumer =
          (Account) request.getSession().getAttribute(Constants.SESSION_LOGIN_INFO);
      UserProfile up = new UserProfile();
      up.setUserProfileId(loginConsumer.getUserProfile().getUserProfileId());
      o.setUserProfile(up);

      
      orderService.addOrder(o);

      data = this.getResultJSON(true, "");
    } else {
      data = this.getResultJSON(false, "");
    }
    return data;

  }



  private Order getOrder(String ausername, String auserPhone, String auseraddress, String remark,
      List<AddOrderVO> vos) {
    Long bid = 0l;
    
    Order o = new Order();
    o.setContacterName(ausername);
    o.setContacterPhone(auserPhone);
    o.setDetailLocation(auseraddress);
    o.setRemarks(remark == null ? " " : remark);
 
    o.setCreateTime(new Date());
    o.setIsDelete(false);
    o.setPayWay(PayWay.CASH_PAY.name());
    o.setOrderNumber(UUID.randomUUID().toString());
    o.setStoreId(bid);
    o.setStatus(OrderStatus.NEW.name());
    o.setVersion(1l);
    
    
    
    List<OrderItem> ois = new ArrayList<OrderItem>();
    for (AddOrderVO aov : vos) {
      Product p = new Product();
      OrderItem oi = new OrderItem();
      oi.setAmount(new BigDecimal(aov.getProNum()));
      oi.setPrice(new BigDecimal(aov.getProPrice()));
      p.setProductId(Long.parseLong(aov.getProId()));
      oi.setProduct(p);
      oi.setOrder(o);
      bid = Long.parseLong(aov.getBid());
      ois.add(oi);
      
    }
    o.setStoreId(bid);
    o.setOrderItems(ois);
   
    return o;
  }



  @Override
  protected String getName() {
    // TODO Auto-generated method stub
    return null;
  }

}

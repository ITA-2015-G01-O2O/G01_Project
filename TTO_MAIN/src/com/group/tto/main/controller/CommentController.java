package com.group.tto.main.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.cmn.model.Comment;
import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.Store;
import com.group.tto.main.service.AccountService;
import com.group.tto.main.service.StoreService;
import com.group.tto.main.vo.CommentsVO;
import com.group.tto.main.vo.MerProsList;

@Controller
@RequestMapping("/comment")
public class CommentController extends BaseController {
  @Autowired
  private StoreService storeService;


  @RequestMapping(value = "/getallCommentBySid.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String getallCommentBySid(String merId) {
    MerProsList store = this.storeService.getStoreById(Long.parseLong(merId));
    List<Comment> merProsList = new ArrayList<Comment>();
    boolean flag = false;
    if (store != null) {
      List<Order> orders = store.getOrders();
      if (orders != null && orders.size() > 0) {
        flag = true;
        for (Order o : orders) {
          merProsList.add(o.getComment());
        }
      }
    }
    List<CommentsVO> commentsListVO = new ArrayList<CommentsVO>();
    if (merProsList != null && merProsList.size() > 0) {
      for (Comment c : merProsList) {
        if (c != null) {
          CommentsVO cvo = new CommentsVO(c);
          commentsListVO.add(cvo);
        }
      }
    }
    String data = this.getResultJSON(flag, commentsListVO);
    return data;
  }
  @RequestMapping(value = "/getallCommentByScore.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String getallCommentByScore(String merId,int score) {
    MerProsList store = this.storeService.getStoreById(Long.parseLong(merId));
    List<Comment> merProsList = new ArrayList<Comment>();
    boolean flag = false;
    if (store != null) {
      List<Order> orders = store.getOrders();
      if (orders != null && orders.size() > 0) {
        flag = true;
        for (Order o : orders) {
          merProsList.add(o.getComment());
        }
      }
    }
    List<CommentsVO> commentsListVO = new ArrayList<CommentsVO>();
    if (merProsList != null && merProsList.size() > 0) {
      for (Comment c : merProsList) {
        if (c != null) {
          
          if((score==1 || score==2) && ((c.getPoint().compareTo(new BigDecimal("1"))==0) ||  c.getPoint().compareTo(new BigDecimal("2"))==0)){
            CommentsVO cvo = new CommentsVO(c);
            commentsListVO.add(cvo);
          }else if(score==3 && (c.getPoint().compareTo(new BigDecimal("3"))==0)){
            CommentsVO cvo = new CommentsVO(c);
            commentsListVO.add(cvo);
          }else if((score==4 || score==5) && ((c.getPoint().compareTo(new BigDecimal("4"))==0) ||  c.getPoint().compareTo(new BigDecimal("5"))==0)){
            CommentsVO cvo = new CommentsVO(c);
            commentsListVO.add(cvo);
          }
        }
      }
    }
    String data = this.getResultJSON(flag, commentsListVO);
    return data;
  }



  @Override
  protected String getName() {
    return null;
  }



}

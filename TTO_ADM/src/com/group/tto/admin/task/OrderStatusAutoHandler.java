package com.group.tto.admin.task;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.group.tto.admin.cmn.OrderSearchCriteria;
import com.group.tto.admin.cmn.ServiceInfoPool;
import com.group.tto.admin.cmn.StringUtils;
import com.group.tto.admin.service.ConfigService;
import com.group.tto.admin.service.OrderService;
import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.type.ConfigName;
import com.group.tto.cmn.type.OrderStatus;

@Component
public class OrderStatusAutoHandler {

  @Autowired
  private OrderService orderService;
  @Autowired
  private ConfigService configService;

  @Scheduled(cron = "0 0/10 *  * * ? ")
  public void autoChangeOrder() {
    System.out.println("===Auto Change Order Status Job Start===");
    String cancelTime =
        (String) ServiceInfoPool.getAttribute(ConfigName.AUTO_CANCEL_TIME.toString());
    String confirmTime =
        (String) ServiceInfoPool.getAttribute(ConfigName.AUTO_CONFIRM_TIME.toString());

    if (StringUtils.isNullOrEmpty(cancelTime)) {
      cancelTime = this.configService.getValueByName(ConfigName.AUTO_CANCEL_TIME.toString());
    }
    if (StringUtils.isNullOrEmpty(confirmTime)) {
      confirmTime = this.configService.getValueByName(ConfigName.AUTO_CONFIRM_TIME.toString());
    }
    System.out.println("CANCEL TIME:" + cancelTime + ",CONFIRM TIME:" + confirmTime);

    Calendar confirmTimeDate = Calendar.getInstance();
    confirmTimeDate.setTime(new Date());
    confirmTimeDate.set(Calendar.HOUR_OF_DAY,
        confirmTimeDate.get(Calendar.HOUR_OF_DAY) - Integer.parseInt(confirmTime));

    Calendar cancelTimeDate = Calendar.getInstance();
    cancelTimeDate.setTime(new Date());
    cancelTimeDate.set(Calendar.HOUR_OF_DAY,
        cancelTimeDate.get(Calendar.HOUR_OF_DAY) - Integer.parseInt(cancelTime));


    List<Order> needConfirmOrder =
        this.orderService.getNeedAutoConfirmOrder(confirmTimeDate.getTime());
    this.orderService.changeStatus(needConfirmOrder, OrderStatus.FINISHED.toString());

    List<Order> needCancelOrder =
        this.orderService.getNeedCancelConfirmOrder(cancelTimeDate.getTime());
    this.orderService.changeStatus(needCancelOrder, OrderStatus.CANCEL.toString());

    System.out.println("===Auto Change Order Status Job End===");
  }
}

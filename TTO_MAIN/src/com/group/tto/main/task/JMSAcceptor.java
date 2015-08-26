package com.group.tto.main.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.group.tto.main.common.JMSHelper;
import com.group.tto.main.common.OrderJMSMsg;

@Component
public class JMSAcceptor {

  private JMSHelper<OrderJMSMsg> jmsHelper = new JMSHelper<OrderJMSMsg>();

  private static List<OrderJMSMsg> msgs = Collections
      .synchronizedList(new ArrayList<OrderJMSMsg>());


  public static List<OrderJMSMsg> getAllMsg() {
    List<OrderJMSMsg> copy = new ArrayList<OrderJMSMsg>();
    for (OrderJMSMsg msg : msgs) {
      copy.add(msg.clone());
    }
    return copy;
  }

  public static void removeMsg(Long orderId) {
    for (int i = msgs.size() - 1; i >= 0; i--) {
      if (msgs.get(i).getOrderId().equals(orderId)) {
        msgs.remove(i);
      }
    }
  }

  @Scheduled(cron = "0 0/1 *  * * ? ")
  public void acceptJMSMessage() {
    try {
      msgs.addAll(jmsHelper.getMessage(100, 5 * 1000L));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

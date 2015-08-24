package com.group.tto.main.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class JMSHelper<T extends Serializable> {
  private static ConnectionFactory factory;
  private static Queue workQueue;
  private static Connection conn;

  static {
    try {
      Properties properties = new Properties();
      properties.load(JMSHelper.class.getResourceAsStream("/config.properties"));
      factory = new ActiveMQConnectionFactory(properties.getProperty("jmsServerUrl"));
      workQueue = new ActiveMQQueue(properties.getProperty("workQueue"));
      conn = factory.createConnection();
      conn.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public List<T> getMessage(Integer maxSize, Long waitTime) throws Exception {
    Session session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
    MessageConsumer consumer = session.createConsumer(workQueue);
    List<T> msgs = new ArrayList<T>();
    while (msgs.size() < maxSize) {
      Message msg = consumer.receive(waitTime);
      if (msg == null) {
        break;
      } else {
        ObjectMessage objMsg = (ObjectMessage) msg;
        msgs.add((T) objMsg.getObject());
        session.commit();
      }
    }
    consumer.close();
    session.close();
    return msgs;
  }

  private Message buildMessage(Session session, T content) throws Exception {
    return session.createObjectMessage(content);
  }

  public void sendJMSMessage(T msg) throws Exception {
    Session session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
    MessageProducer producer = session.createProducer(workQueue);
    producer.send(this.buildMessage(session, msg));
    session.commit();

    session.close();
    producer.close();
  }
}

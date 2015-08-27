package com.group.tto.main.vendor.text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.group.tto.cmn.model.Store;
import com.group.tto.main.dao.FileDao;
import com.group.tto.main.vendor.dao.StoreDao;
import com.group.tto.main.vendor.service.impl.CompleteInfoServiceImpl;

public class TestCompleteInfo {
  private static ApplicationContext context;
  private static EntityManagerFactory factory;
  private static StoreDao s;
  private static FileDao f;
  private static CompleteInfoServiceImpl ci;

  @BeforeClass
  public static void beforeClass() {
    context = new ClassPathXmlApplicationContext("spring-beans.xml");
    s = (StoreDao) context.getBean("vendorStoreDaoImpl");
    f = (FileDao) context.getBean("fileDaoImpl");
    ci = new CompleteInfoServiceImpl();
  }

  @Test
  public void testUpdateStoreInfo() {
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();
    transaction.begin();

    BigDecimal fee = new BigDecimal(0);
    Date date = new Date();
    String uuid = UUID.randomUUID().toString();
    File file = new File("d:/xx.jpg");
    InputStream is = null;
    try {
      is = new FileInputStream(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    Store store = new Store();
    store.setAnnouncement("abc");
    store.setDeliverFee(fee);
    store.setStartingFee(fee);
    store.setServiceBeginTime(date);
    store.setServiceEndTime(date);
    store.setLogoPicUrl(uuid);
    int sid = 2050;

    ci.setStoreDao(s);
    ci.setF(f);
    int num=ci.updateStoreInfo(store, sid, uuid, is);

    transaction.commit();
    Assert.assertTrue(num!=0);
  }

}

package com.group.tto.main.vendor.text;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.group.tto.cmn.model.Store;
import com.group.tto.main.vendor.dao.StoreDao;
import com.group.tto.main.vendor.service.impl.BasicSettingServiceImpl;

public class TestBasicSetting {

private static ApplicationContext context;
  
  @BeforeClass
  public static void beforeClass(){
    context = new ClassPathXmlApplicationContext("spring-beans.xml");
  }
  
  @Test
  public void test() {
    EntityManagerFactory factory = (EntityManagerFactory) context.getBean("entityManagerFactory");
    StoreDao s = (StoreDao) context.getBean("vendorStoreDaoImpl");
    
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();
    transaction.begin();
    
    BigDecimal fee=new BigDecimal(0);
    Date date=new Date();
    
    Store store=new Store();
    store.setAnnouncement("abc");
    store.setDeliverFee(fee);
    store.setStartingFee(fee);
    store.setServiceBeginTime(date);
    store.setServiceEndTime(date);
    
    int sid=2050;
    
    BasicSettingServiceImpl bs=new BasicSettingServiceImpl();
    bs.setStoreDao(s);
    
    int num=bs.updateBasicSetting(sid, store);
    Store store1=bs.loadBasicSetting(sid);
    
    transaction.commit();
    Assert.assertTrue(num!=0 && store1!=null);
  }

}

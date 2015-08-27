package com.group.tto.main.vendor.text;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.group.tto.main.dao.CollectDao;
import com.group.tto.main.vendor.dao.StoreDao;
import com.group.tto.main.vendor.service.impl.VendorInfoServiceImpl;
import com.group.tto.main.vo.VendorInfo;

public class TestVendorInfo {
  
  private static ApplicationContext context;
  
  @BeforeClass
  public static void beforeClass(){
    context = new ClassPathXmlApplicationContext("spring-beans.xml");
  }
  
  @Test
  public void test() {
    EntityManagerFactory factory = (EntityManagerFactory) context.getBean("entityManagerFactory");
    CollectDao c = (CollectDao) context.getBean("collectDaoImpl");
    StoreDao s = (StoreDao) context.getBean("vendorStoreDaoImpl");
    
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();
    transaction.begin();
    
    int sid=50;
    VendorInfoServiceImpl v=new VendorInfoServiceImpl();
    v.setC(c);
    v.setStore(s);
    
    VendorInfo vi=v.getVendorInfo(sid);
    
    transaction.commit();
    Assert.assertTrue(vi!=null);
  }

}

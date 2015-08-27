package com.group.tto.main.vendor.text;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.group.tto.cmn.model.StoreProfile;
import com.group.tto.main.vendor.dao.StoreProfileDao;
import com.group.tto.main.vendor.service.impl.PersonalInfoServiceImpl;

public class TestPersonalInfo {
  private static ApplicationContext context;

  @BeforeClass
  public static void beforeClass() {
    context = new ClassPathXmlApplicationContext("spring-beans.xml");
  }

  @Test
  public void testLoadPersonInfo() {
    EntityManagerFactory factory = (EntityManagerFactory) context.getBean("entityManagerFactory");
    StoreProfileDao sp = (StoreProfileDao) context.getBean("vendorPersonalInfoServiceImpl");

    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();
    transaction.begin();
    
    int sid=2050;
    
    PersonalInfoServiceImpl pi=new PersonalInfoServiceImpl();
    pi.setStoreProfileDao(sp);
    StoreProfile sp1=pi.loadPersonInfo(sid);

    transaction.commit();
    Assert.assertTrue(sp1!=null);
  }

}

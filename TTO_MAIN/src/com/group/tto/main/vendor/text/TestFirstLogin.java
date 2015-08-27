package com.group.tto.main.vendor.text;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.group.tto.cmn.model.Store;
import com.group.tto.main.vendor.dao.AccountDao;
import com.group.tto.main.vendor.service.impl.FirstLoginServiceImpl;

public class TestFirstLogin {
  private static ApplicationContext context;

  @BeforeClass
  public static void beforeClass() {
    context = new ClassPathXmlApplicationContext("spring-beans.xml");
  }

  @Test
  public void testGetStore() {
    EntityManagerFactory factory = (EntityManagerFactory) context.getBean("entityManagerFactory");
    AccountDao a = (AccountDao) context.getBean("vendorAccountDaoImpl");

    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();
    transaction.begin();

    int uid = 52;

    FirstLoginServiceImpl fl = new FirstLoginServiceImpl();
    fl.setAccountDao(a);
    Store s=fl.getStore(uid);

    transaction.commit();
    Assert.assertTrue(s!=null);
  }

}

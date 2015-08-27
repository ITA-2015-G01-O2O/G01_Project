package com.group.tto.main.vendor.text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.group.tto.cmn.model.Configuration;
import com.group.tto.cmn.model.Store;
import com.group.tto.cmn.type.ConfigName;
import com.group.tto.main.dao.FileDao;
import com.group.tto.main.vendor.dao.ConfigurationDao;
import com.group.tto.main.vendor.dao.StoreDao;
import com.group.tto.main.vendor.service.impl.StoreInfoServiceImpl;

public class TestStoreInfo {

  private static ApplicationContext context;
  private static StoreDao storeDao;
  private static FileDao f;
  private static ConfigurationDao conDao;
  private static EntityManagerFactory factory;
  private static EntityTransaction transaction;
  private static StoreInfoServiceImpl si;

  @BeforeClass
  public static void beforeClass() {
    context = new ClassPathXmlApplicationContext("spring-beans.xml");
    factory = (EntityManagerFactory) context.getBean("entityManagerFactory");
    EntityManager manager = factory.createEntityManager();
    transaction = manager.getTransaction();

    storeDao = (StoreDao) context.getBean("vendorStoreDaoImpl");
    f = (FileDao) context.getBean("fileDaoImpl");
    conDao = (ConfigurationDao) context.getBean("vendorConfigurationDaoImpl");
    si = new StoreInfoServiceImpl();
    si.setConDao(conDao);
    si.setF(f);
    si.setStoreDao(storeDao);
  }

  @Test
  public void testLoadStoreInfo() {
    transaction.begin();
    int sid = 2050;

    Store store = si.loadStoreInfo(sid);

    transaction.commit();
    Assert.assertTrue(store != null);
  }

  @Test
  public void testUpdateStoreInfoStoreIntStringInputStream() {
    transaction.begin();

    File file = new File("d:/xx.jpg");
    InputStream is = null;
    try {
      is = new FileInputStream(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    String uuid = UUID.randomUUID().toString();
    int sid = 2050;

    Configuration con = new Configuration();
    con.setConfigId(4l);
    con.setConfigName(ConfigName.CATEGORY_NAME.name());
    con.setConfigValue("Chinese meal");

    Store store = new Store();
    store.setPhone("123456");
    store.setStoreName("abc");
    store.setTypeConfig(con);
    store.setLogoPicUrl(uuid);

    int num = si.updateStoreInfo(store, sid, uuid, is);

    transaction.commit();
    Assert.assertTrue(num != 0);
  }

  @Test
  public void testUpdateStoreInfoStoreInt() {
    transaction.begin();

    int sid = 2050;

    Configuration con = new Configuration();
    con.setConfigId(4l);
    con.setConfigName(ConfigName.CATEGORY_NAME.name());
    con.setConfigValue("Chinese meal");

    Store store = new Store();
    store.setPhone("123456");
    store.setStoreName("abc");
    store.setTypeConfig(con);

    int num = si.updateStoreInfo(store, sid);

    transaction.commit();
    Assert.assertTrue(num != 0);
  }

  @Test
  public void testGetConfiguration() {
    transaction.begin();

    String value = "Chinese meal";
    Configuration con = si.getConfiguration(value);

    transaction.commit();
    Assert.assertTrue(con != null);
  }

}

package com.group.tto.main.vendor.text;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.group.tto.cmn.model.Configuration;
import com.group.tto.cmn.model.Location;
import com.group.tto.main.dao.FileDao;
import com.group.tto.main.vendor.dao.AccountDao;
import com.group.tto.main.vendor.dao.ConfigurationDao;
import com.group.tto.main.vendor.dao.LocationDao;
import com.group.tto.main.vendor.service.impl.VendorRegisterServiceImpl;

public class TestVendorRegister {

  private static ApplicationContext context;
  private static AccountDao accountDao;
  private static FileDao f;
  private static LocationDao locationDao;
  private static ConfigurationDao conDao;
  private static EntityManagerFactory factory;
  private static EntityTransaction transaction;
  private static VendorRegisterServiceImpl vr;

  @Test
  public void testStoreRegister() {
    context = new ClassPathXmlApplicationContext("spring-beans.xml");
    factory = (EntityManagerFactory) context.getBean("entityManagerFactory");
    EntityManager manager = factory.createEntityManager();
    transaction = manager.getTransaction();

    f = (FileDao) context.getBean("fileDaoImpl");
    conDao = (ConfigurationDao) context.getBean("vendorConfigurationDaoImpl");
    accountDao = (AccountDao) context.getBean("vendorAccountDaoImpl");
    locationDao = (LocationDao) context.getBean("vendorLocationDaoImpl");

    vr.setConDao(conDao);
    vr.setF(f);
    vr.setAccountDao(accountDao);
    vr.setLocationDao(locationDao);

  }

  @Test
  public void testGetLocation() {
    transaction.begin();
    String area = "河北省";
    String city = "石家庄市";
    String place = "无极县";

    int id = vr.getLocation(area, place, city);

    transaction.commit();
    Assert.assertTrue(id != 0);
  }

  @Test
  public void testGetConfiguration() {
    transaction.begin();
    String value = "Support food";
    Configuration con = vr.getConfiguration(value);

    transaction.commit();
    Assert.assertTrue(con != null);
  }

  @Test
  public void testGetAllArea() {
    transaction.begin();

    List<String> areaList = vr.getAllArea();

    transaction.commit();
    Assert.assertTrue(areaList.size() != 0);
  }

  @Test
  public void testGetAllConfig() {
    transaction.begin();

    List<Configuration> conList = vr.getAllConfig();

    transaction.commit();
    Assert.assertTrue(conList.size() != 0);
  }

  @Test
  public void testGetCity() {
    transaction.begin();

    String area = "河北省";
    List<String> cityList = vr.getCity(area);

    transaction.commit();
    Assert.assertTrue(cityList.size() != 0);
  }

  @Test
  public void testGetPlace() {
    transaction.begin();

    String city = "石家庄市";
    List<Location> ls = vr.getPlace(city);

    transaction.commit();
    Assert.assertTrue(ls.size() != 0);
  }

}

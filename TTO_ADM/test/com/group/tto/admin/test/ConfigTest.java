package com.group.tto.admin.test;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.group.tto.admin.service.ConfigService;
import com.group.tto.cmn.model.Configuration;
import com.group.tto.cmn.type.ConfigName;

public class ConfigTest {
  private static ApplicationContext context =
      new ClassPathXmlApplicationContext("spring-beans.xml");
  private static ConfigService service;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    service = context.getBean(ConfigService.class);
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testGetAll() {
    List<Configuration> all = this.service.getAll();
    for (Configuration config : all) {
      System.out.println(config.getConfigName() + ":" + config.getConfigValue());
    }
    Assert.assertTrue(true);
  }

  @Test
  public void testGetValueByName() {
    List<Configuration> all = this.service.getAll();
    boolean flag = true;
    for (Configuration config : all) {
      if (!config.getConfigName().equals(ConfigName.CATEGORY_NAME.toString())) {
        String dbValue = this.service.getValueByName(config.getConfigName());
        if (!dbValue.equals(config.getConfigValue())) {
          System.out.println(dbValue + " " + config.getConfigValue());
          flag = false;
          break;
        }
      }
    }
    Assert.assertTrue(flag);
  }
}

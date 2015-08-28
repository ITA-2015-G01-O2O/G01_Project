package com.group.tto.admin.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.group.tto.admin.service.AdminService;
import com.group.tto.cmn.model.Admin;

public class AdminTest {

  private static ApplicationContext context =
      new ClassPathXmlApplicationContext("spring-beans.xml");
  private static AdminService service;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    service = context.getBean(AdminService.class);
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testLogin() {
    Admin trueAdmin = service.login("cd", "cd");
    Admin falseAdmin = service.login("cd", "cd1");
    Assert.assertTrue(trueAdmin != null && falseAdmin == null);
  }

  @Test
  public void testContains() {
    Boolean trueAdmin = service.contains("cd");
    Boolean falseAdmin = service.contains("cd1");
    Assert.assertTrue(trueAdmin && !falseAdmin);
  }

}

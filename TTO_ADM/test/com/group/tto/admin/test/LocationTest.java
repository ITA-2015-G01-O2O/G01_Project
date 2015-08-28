package com.group.tto.admin.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
import com.group.tto.admin.service.LocationService;
import com.group.tto.cmn.model.Location;

public class LocationTest {
  private static ApplicationContext context =
      new ClassPathXmlApplicationContext("spring-beans.xml");
  private static LocationService service;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    service = context.getBean(LocationService.class);
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testSearch() {
    List<Location> list = this.service.search("广东省", "珠海市", "", 25);
    boolean check = true;
    for (Location test : list) {
      if (!test.getArea().equals("广东省") && !test.getCity().equals("珠海市")) {
        check = false;
        break;
      }
    }
    Assert.assertTrue(list.size() <= 25);
  }

}

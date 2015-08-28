package com.group.tto.admin.test;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Comment;
import com.group.tto.cmn.model.Configuration;
import com.group.tto.cmn.model.Location;
import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.OrderItem;
import com.group.tto.cmn.model.Product;
import com.group.tto.cmn.model.ProductLabel;
import com.group.tto.cmn.model.Store;
import com.group.tto.cmn.model.UserProfile;

public class ModelRelationTest {
  private static ApplicationContext context =
      new ClassPathXmlApplicationContext("spring-beans.xml");
  private static EntityManagerFactory factory;
  private static EntityManager manager;

  private EntityTransaction transaction;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    factory = context.getBean(EntityManagerFactory.class);
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    factory.close();
  }

  @Before
  public void setUp() throws Exception {
    manager = factory.createEntityManager();
  }

  @After
  public void tearDown() throws Exception {
    manager.close();
  }

  @Test
  @Ignore
  public void register() {
    transaction = manager.getTransaction();
    transaction.begin();
    Account account = new Account();
    account.setPassword("test");
    account.setUsername("test");
    account.setIsDelete(false);
    account.setVersion(1L);

    UserProfile userProfile = new UserProfile();
    userProfile.setFund(new BigDecimal("1"));
    userProfile.setIsDelete(false);
    userProfile.setVersion(1L);

    account.setUserProfile(userProfile);

    manager.persist(account);
    transaction.commit();
  }

  @Test
  @Ignore
  public void comment() {
    Comment comment = new Comment();
    comment.setContext("test");
    comment.setDeliverTime(new BigDecimal("1"));
    comment.setPoint(new BigDecimal("1"));
    UserProfile userProfile = new UserProfile();
    userProfile.setUserProfileId(50L);
    comment.setUserProfile(userProfile);
    Order order = manager.find(Order.class, 50L);
    order.setComment(comment);
    manager.persist(order);
    transaction.commit();
  }

  @Test
  @Ignore
  public void store() {
    transaction = manager.getTransaction();
    transaction.begin();
    Store store = new Store();
    store.setAnnouncement("zxczc anno3");
    store.setAvgDeliverTime(new BigDecimal("12"));
    store.setAvgPoint(new BigDecimal("0"));
    store.setDeliverFee(new BigDecimal("1"));
    store.setDetailLocation("test detail location4");
    store.setIsDelete(false);
    store.setIsHot(false);
    store.setLocation(manager.find(Location.class, 50L));
    store.setLogoPicUrl("a9b5f8a8-a3d3-4ca8-9b43-0736c4fe3ae8");
    store.setPhone("123xxx");
    store.setServiceBeginTime(new Date());
    store.setServiceEndTime(new Date());
    store.setStartingFee(new BigDecimal("1"));
    store.setStoreName("tdddest cvbafg");
    Configuration c = new Configuration();
    c.setConfigId(new Long(4));
    store.setTypeConfig(c);
    manager.persist(store);
    transaction.commit();
  }

  @Test
  @Ignore
  public void productLabel() {
    transaction = manager.getTransaction();
    transaction.begin();
    ProductLabel label = new ProductLabel();
    label.setProductLabelName("test");
    Store store = manager.find(Store.class, 50L);
    store.getProductLabels().add(label);
    manager.merge(store);
    transaction.commit();
  }

  @Test
  @Ignore
  public void product() {
    Product product = new Product();
    product.setDelete(false);
    product.setPoint(new BigDecimal("1"));
    product.setPrice(new BigDecimal("1"));
    product.setProductLabel(manager.find(ProductLabel.class, 150L));
    product.setProductName("test");
    product.setProductPicUrl("test");
    product.setSalesVolume(new BigDecimal("1"));
    product.setVersion(1L);
    Store store = manager.find(Store.class, 50L);
    store.getProducts().add(product);
    manager.merge(store);
    transaction.commit();
  }

  @Test
  @Ignore
  public void order() {
    transaction = manager.getTransaction();
    transaction.begin();

    Order order = new Order();
    order.setContacterName("test");
    order.setContacterPhone("test");
    order.setCreateTime(new Date());
    order.setDetailLocation("test");
    order.setEndTime(new Date());
    order.setIsDelete(false);
    order.setOrderNumber("test");
    order.setPayWay("test");
    order.setRemarks("test");
    order.setStatus("test");


    order.setStoreId(50L);
    UserProfile userProfile = new UserProfile();
    userProfile.setUserProfileId(50L);
    order.setUserProfile(userProfile);
    order.setVersion(1L);

    OrderItem item = new OrderItem();
    item.setAmount(new BigDecimal("1"));
    item.setPrice(new BigDecimal("1"));
    Product product = new Product();
    product.setProductId(3050L);
    item.setProduct(product);
    item.setOrder(order);

    order.getOrderItems().add(item);

    manager.persist(order);
    transaction.commit();
  }

}

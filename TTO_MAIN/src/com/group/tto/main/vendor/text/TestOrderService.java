package com.group.tto.main.vendor.text;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManagerFactory;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.OrderItem;
import com.group.tto.cmn.model.Product;
import com.group.tto.cmn.model.Store;
import com.group.tto.cmn.model.StoreProfile;
import com.group.tto.cmn.model.UserProfile;
import com.group.tto.main.dao.OrderDao;
import com.group.tto.main.service.OrderService;
import com.group.tto.main.service.impl.OrderServiceImpl;
import com.group.tto.main.vendor.dao.StoreProfileDao;
import com.group.tto.main.vendor.service.impl.PersonalInfoServiceImpl;

public class TestOrderService {

private static ApplicationContext context;
  
  @BeforeClass
  public static void beforeClass(){
    context = new ClassPathXmlApplicationContext("spring-beans.xml");
  }

  @Test
  public void testAddOrder() {
    EntityManagerFactory factory = (EntityManagerFactory) context.getBean("entityManagerFactory");
    OrderService os=context.getBean(OrderService.class);
    
    for(int i=0;i<2;i++){
    Order order = new Order();


    order.setContacterName("test"+i);
    order.setContacterPhone("test"+i);
    order.setCreateTime(new Date());
    order.setDetailLocation("test"+i);
    order.setEndTime(new Date());
    order.setIsDelete(false);
    order.setOrderNumber("test"+i);
    order.setPayWay("test"+i);
    order.setRemarks("test"+i);
    order.setStatus("test"+i);
    Store store=new Store();
    store.setStoreId(50L);
    order.setStoreId(store.getStoreId());
    UserProfile userProfile = new UserProfile();
    userProfile.setUserProfileId(50L);
    order.setUserProfile(userProfile);
    order.setVersion(1L);

    OrderItem item = new OrderItem();
    item.setAmount(new BigDecimal("1"));
    item.setPrice(new BigDecimal("1"));
    Product product=new Product();
    product.setProductId(3050L);
    item.setProduct(product);
    item.setOrder(order);

    order.getOrderItems().add(item);
    
    os.addOrder(order);
    }
    Assert.assertTrue(true);
  }
}

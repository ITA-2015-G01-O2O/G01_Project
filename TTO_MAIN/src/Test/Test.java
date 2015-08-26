package Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Collect;
import com.group.tto.cmn.model.Comment;
import com.group.tto.cmn.model.Configuration;
import com.group.tto.cmn.model.Location;
import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.OrderItem;
import com.group.tto.cmn.model.Product;
import com.group.tto.cmn.model.ProductLabel;
import com.group.tto.cmn.model.Store;
import com.group.tto.cmn.model.StoreProfile;
import com.group.tto.cmn.model.UserProfile;
import com.group.tto.main.common.StoreSearchCriteria;
import com.group.tto.main.dao.LocationDao;
import com.group.tto.main.dao.StoreDao;
import com.group.tto.main.dao.impl.LocationDaoImpl;
import com.group.tto.main.dao.impl.StoreDaoImpl;

public class Test {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
    EntityManagerFactory factory = (EntityManagerFactory) context.getBean("entityManagerFactory");
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();
    transaction.begin();
    // Account account = new Account();
    // account.setPassword("test");
    // account.setUsername("test");
    // account.setIsDelete(false);
    // account.setVersion(1L);
    //
    // UserProfile userProfile = new UserProfile();
    // userProfile.setFund(new BigDecimal("1"));
    // userProfile.setIsDelete(false);
    // userProfile.setVersion(1L);
    //
    // account.setUserProfile(userProfile);
    //
    // manager.persist(account);

    // Location location=new Location();
    // location.setArea("testArea");
    // location.setCity("testCity");
    // location.setPlace("testPlace");
    // manager.persist(location);

    List<Order> orders = new ArrayList<Order>();
    int i=0;
    while(++i==20){
      orders.add(new Order());
    };
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
    store.setOrders(orders);
    Configuration c = new Configuration();
    c.setConfigId(new Long(4));
    store.setTypeConfig(c);
    manager.persist(store);
    //
    // StoreProfile storeProfile = new StoreProfile();
    // storeProfile.setIdCardNumber("test");
    // storeProfile.setIdCardPicUrl("test");
    // storeProfile.setIsDelete(false);
    // storeProfile.setLicensePicUrl("test");
    // storeProfile.setRealName("test");
    // storeProfile.setStatus("test");
    // storeProfile.setVersion(1L);
    //
    // store.setStoreProfile(storeProfile);
    // store.setVersion(1L);

    // Account account = manager.find(Account.class, 50L);
    // account.setStore(manager.find(Store.class, 50L));
    // manager.merge(account);

    // Account account = manager.find(Account.class, 50L);
    // System.out.println(account.getStore());

    // ProductLabel label = new ProductLabel();
    // label.setProductLabelName("test");
    // Store store = manager.find(Store.class, 50L);
    // store.getProductLabels().add(label);
    // manager.merge(store);

    // Product product = new Product();
    // product.setDelete(false);
    // product.setPoint(new BigDecimal("1"));
    // product.setPrice(new BigDecimal("1"));
    // product.setProductLabel(manager.find(ProductLabel.class, 150L));
    // product.setProductName("test");
    // product.setProductPicUrl("test");
    // product.setSalesVolume(new BigDecimal("1"));
    // product.setVersion(1L);
    // Store store = manager.find(Store.class, 50L);
    // store.getProducts().add(product);
    // manager.merge(store);

    // Store store = manager.find(Store.class, 50L);
    // System.out.println(store.getProducts().get(0).getStoreId());

    // Store store = manager.find(Store.class, 50L);
    // Collect collect = new Collect();
    // collect.setStore(store);
    //
    // Account account = manager.find(Account.class, 50L);
    //
    // account.getUserProfile().getCollects().add(collect);
    // manager.merge(account);

    // Account account = manager.find(Account.class, 50L);
    // System.out.println(account.getUserProfile().getCollects().get(0).getStore().getStoreName());

    // Account account = manager.find(Account.class, 50L);
    // Store store = manager.find(Store.class, 50L);
    //
    // Order order = new Order();
    // Comment comment = new Comment();
    // comment.setContext("test");
    // comment.setDeliverTime(new BigDecimal("1"));
    // comment.setPoint(new BigDecimal("1"));
    // comment.setUserProfile(account.getUserProfile());
    //
    // order.setComment(comment);
    // order.setContacterName("test");
    // order.setContacterPhone("test");
    // order.setCreateTime(new Date());
    // order.setDetailLocation("test");
    // order.setEndTime(new Date());
    // order.setIsDelete(false);
    // order.setOrderNumber("test");
    // order.setPayWay("test");
    // order.setRemarks("test");
    // order.setStatus("test");
    // order.setStoreId(store.getStoreId());
    // order.setUserProfile(account.getUserProfile());
    // order.setVersion(1L);
    //
    // OrderItem item = new OrderItem();
    // item.setAmount(new BigDecimal("1"));
    // item.setPrice(new BigDecimal("1"));
    // item.setProduct(store.getProducts().get(0));
    //
    // order.getOrderItems().add(item);

    // manager.persist(order);
    //
    // Store store = manager.find(Store.class, 50L);
    // System.out.println(store.getOrders().get(0).getOrderNumber());

    /*------------------------------------------------------*/
    // LocationDaoImpl locationDao = new LocationDaoImpl();
    // locationDao.setEntityManager(manager);
    // System.out.println( locationDao.getAllLocations().get(0).getArea());
    //
    // StoreDaoImpl storeDao = new StoreDaoImpl();
    // storeDao.setEntityManager(manager);
    // StoreSearchCriteria ssc = new StoreSearchCriteria();
    // System.out.println(storeDao.getStoreByCriteria(ssc).size());

    transaction.commit();
  }

}

package Test;

import java.math.BigDecimal;
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
import com.group.tto.cmn.model.Location;
import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.OrderItem;
import com.group.tto.cmn.model.Product;
import com.group.tto.cmn.model.ProductLabel;
import com.group.tto.cmn.model.Store;
import com.group.tto.cmn.model.StoreProfile;
import com.group.tto.cmn.model.UserProfile;
import com.group.tto.main.dao.OrderDao;
import com.group.tto.main.dao.impl.OrderDaoImpl;
import com.group.tto.main.dao.impl.StoreDaoImpl;
import com.group.tto.main.service.OrderService;
import com.group.tto.main.service.impl.OrderServiceImpl;

public class Test {
	
	
	
	
	
	
	

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
    EntityManagerFactory factory = (EntityManagerFactory) context.getBean("entityManagerFactory");
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();
    transaction.begin();
    
     //测试OrderDaoImpl
    OrderDaoImpl odi = new OrderDaoImpl();
    UserProfile userProfile = new UserProfile();
    userProfile.setUserProfileId(50l);
    userProfile.setFund(new BigDecimal("1"));
    odi.setEntityManager(manager);
    List<Order> o = odi.getAllOrderByUserProfile(userProfile);
    for (Order order : o) {
		System.out.println(order.getEndTime()+"      ");
	}
 	
    
    
    /*
    //测试StoreDaoImpl
    StoreDaoImpl sdi = new StoreDaoImpl();
    sdi.setEntityManager(manager);
    Store s = sdi.getStoreById(50);
    System.out.println("store name :"+s.getStoreName()+" store detail:"+s.getDetailLocation());
    */

    transaction.commit();
  }

}

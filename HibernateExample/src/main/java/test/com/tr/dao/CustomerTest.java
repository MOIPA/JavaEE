package test.com.tr.dao; 

import com.tr.dao.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

/** 
* Customer Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 7, 2019</pre> 
* @version 1.0 
*/ 
public class CustomerTest { 

@Before
public void before() throws Exception {

} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getCust_id() 
* 
*/ 
@Test
public void testGetCust_id() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setCust_id(long cust_id) 
* 
*/ 
@Test
public void testSetCust_id() throws Exception { 
//TODO: Test goes here... 
}

    /**
     * Method: getCust_name()
     */
    @Test
    public void testGetCust_name() throws Exception {

    }

/** 
* 
* Method: setCust_name(String cust_name) 
* 
*/ 
@Test
public void testSetCust_name() throws Exception {
    //保存客户
    Configuration configure = new Configuration().configure();
    SessionFactory sessionFactory = configure.buildSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    //-----------
    Customer customer = new Customer();
    customer.setCust_name("测试公司");

    session.save(customer);
    //------------
    transaction.commit();
    session.close();
    sessionFactory.close();
} 

/** 
* 
* Method: getCust_source() 
* 
*/ 
@Test
public void testGetCust_source() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setCust_source(String cust_source) 
* 
*/ 
@Test
public void testSetCust_source() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getCust_industry() 
* 
*/ 
@Test
public void testGetCust_industry() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setCust_industry(String cust_industry) 
* 
*/ 
@Test
public void testSetCust_industry() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getCust_level() 
* 
*/ 
@Test
public void testGetCust_level() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setCust_level(String cust_level) 
* 
*/ 
@Test
public void testSetCust_level() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getCust_linkman() 
* 
*/ 
@Test
public void testGetCust_linkman() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setCust_linkman(String cust_linkman) 
* 
*/ 
@Test
public void testSetCust_linkman() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getCust_phone() 
* 
*/ 
@Test
public void testGetCust_phone() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setCust_phone(String cust_phone) 
* 
*/ 
@Test
public void testSetCust_phone() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getCust_mobile() 
* 
*/ 
@Test
public void testGetCust_mobile() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setCust_mobile(String cust_mobile) 
* 
*/ 
@Test
public void testSetCust_mobile() throws Exception { 
//TODO: Test goes here... 
} 


} 

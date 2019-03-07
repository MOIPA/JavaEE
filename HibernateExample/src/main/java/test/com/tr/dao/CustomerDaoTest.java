package test.com.tr.dao; 

import com.tr.bean.Customer;
import com.tr.dao.CustomerDao;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* CustomerDao Tester. 
* 
* @author <Authors tr>
* @since <pre> 7, 2019</pre>
* @version 1.0 
*/ 
public class CustomerDaoTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: insertCustomer(Customer customer) 
* 
*/ 
    @Test
    public void testInsertCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setCust_name("baidu");
        new CustomerDao().insertCustomer(customer);
    }
    @Test
    public void testGetCustomer() throws Exception {
        new CustomerDao().getCustomer(2);
    }
    @Test
    public void testdeleteCustomer() throws Exception {
        new CustomerDao().deleteCustomer(2);
    }

    @Test
    public void testUpdateCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setCust_name("changed");
        customer.setCust_id(2);
        new CustomerDao().updateCustomer(customer,2);
    }


} 

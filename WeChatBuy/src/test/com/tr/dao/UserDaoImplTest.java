package test.com.tr.dao; 

import com.google.gson.Gson;
import com.tr.dao.OrderDaoImpl;
import com.tr.dao.UserDaoImpl;
import com.tr.domin.Order;
import com.tr.domin.User;
import com.tr.service.OrderServiceImpl;
import com.tr.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;
import java.util.Map;

/** 
* UserDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>?? 19, 2018</pre> 
* @version 1.0 
*/ 
public class UserDaoImplTest {

    private UserDaoImpl userDao = null;
    private UserServiceImpl userService = null;

    private OrderDaoImpl orderDao = null;
    private OrderServiceImpl orderServiceImpl = null;

    @Before
    public void before() throws Exception {
        userDao = new UserDaoImpl();
        userService = new UserServiceImpl();
        orderDao = new OrderDaoImpl();
        orderServiceImpl = new OrderServiceImpl();
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: getUserList()
    *
    */
    @Test
    public void testGetUserList() throws Exception {

        List<User> userList = userDao.getUserList();
        for (User user : userList) {
            System.out.println(user.getAccount());
        }

    }
    @Test
    public void testCheckUserAccount(){
        boolean b = userDao.checkUserAccount("2栋杨阿姨");
        boolean b1 = userService.checkUserAccount("2栋杨阿姨");
        Assert.assertEquals(true,b);
        Assert.assertEquals(true,b1);
    }
    @Test
    public void testGetHotOrderList(){
        List<Order> results = orderServiceImpl.getHotOrderList("测试小区");
        for (Order order : results) {
            System.out.println(order.getOrdercontent()+order.getAccount()+order.getCom()+order.getFollowers()+order.getPosttime()+order.getUiconsrc());
        }
    }
    @Test
    public void testGetNewOrderList(){
        List<Order> results = orderServiceImpl.getNewOrderList("测试小区");
        for (Order order : results) {
            System.out.println(order.getAccount()+order.getCom()+order.getFollowers()+order.getPosttime()+order.getUiconsrc());
        }
    }

    @Test
    public void testSignInAccount(){
//        String s = userDao.signInAccount("2栋杨阿姨", "123123");
//        String com = userService.signInAccount("2栋杨阿姨", "123123");
        User user = userService.signInAccount("2栋杨阿姨", "1231231");
        Assert.assertEquals(null, user);
//        Assert.assertEquals("测试小区", com);
        user = userService.signInAccount("2栋杨阿姨", "123123");
        System.out.println(user.getCname()+user.getIdentity());
    }
    @Test
    public void testGetAllCommunity(){
        List<Map<String, Object>> allCommunity = userDao.getAllCommunity();
        Gson gson = new Gson();
        String s = gson.toJson(allCommunity);
        System.out.println(s);
        String allCommunity1 = userService.getAllCommunity();
        System.out.println(allCommunity1);

    }


} 

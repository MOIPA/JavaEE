package test.com.tr.service; 

import com.tr.dao.OrderDaoImpl;
import com.tr.dao.UserDaoImpl;
import com.tr.service.OrderServiceImpl;
import com.tr.service.UserServiceImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* OrderServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>五月 5, 2018</pre> 
* @version 1.0 
*/ 
public class OrderServiceImplTest {



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
* Method: getHotOrderList(String com) 
* 
*/ 
@Test
public void testGetHotOrderList() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getNewOrderList(String com) 
* 
*/ 
@Test
public void testGetNewOrderList() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: savePic(String savePath, List<FileItem> list) 
* 
*/ 
@Test
public void testSavePic() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: uploadActivityInfo(PostOrderInfo postOrderInfo) 
* 
*/ 
@Test
public void testUploadActivityInfo() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: uploadOrderInfo(PostOrderInfo postOrderInfo) 
* 
*/ 
@Test
public void testUploadOrderInfo() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getDetailInfoById(String orderid) 
* 
*/ 
@Test
public void testGetDetailInfoById() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getPicUrls(String orderid) 
* 
*/ 
@Test
public void testGetPicUrls() throws Exception {
    List<String> urls = orderServiceImpl.getPicUrls("2");
    for (String item : urls) {
        System.out.println(item);
    }
} 


} 

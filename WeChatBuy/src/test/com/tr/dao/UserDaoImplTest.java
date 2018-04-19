package test.com.tr.dao; 

import com.tr.dao.UserDaoImpl;
import com.tr.domin.User;
import com.tr.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

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

    @Before
    public void before() throws Exception {
        userDao = new UserDaoImpl();
        userService = new UserServiceImpl();
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


} 

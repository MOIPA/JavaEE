package test.com.tr.dao; 

import com.tr.dao.UserDaoImpl;
import com.tr.domin.User;
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

@Before
public void before() throws Exception { 
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

    UserDaoImpl userDao = new UserDaoImpl();
    List<User> userList = userDao.getUserList();
    for (User user : userList) {
        System.out.println(user.getAccount());
    }

} 


} 

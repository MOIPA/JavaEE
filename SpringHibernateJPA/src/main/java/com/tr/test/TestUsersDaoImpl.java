package com.tr.test;

import com.tr.dao.UsersDao;
import com.tr.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUsersDaoImpl {

        @Resource(name = "userDaoImpl")
//    @Autowired
    private UsersDao usersDao;

    @Test
    @Transactional(rollbackOn = Exception.class) //再测试中，对于事务提交方式默认是回滚
//    @Rollback(false)  //取消自动回滚
    public void testInsertUsers() {
        Users users = new Users();
        users.setCust_level("1");
        users.setCust_linkman("com/tr");
        users.setCust_mobile("111");
        users.setCust_name("tr");
        users.setCust_source("source");
        users.setIndustry("indus");
        this.usersDao.insertUsers(users);
    }

    @Test
    @Transactional(rollbackOn = Exception.class) //再测试中，对于事务提交方式默认是回滚
    @Rollback(false)
    public void testUpdateUsers() {
        Users users = new Users();
        users.setCust_id(1);
        users.setCust_name("debuged");
        this.usersDao.updateUsers(users);
    }

    @Test
    public void testGetUsers() {
        Users users = this.usersDao.selectUserById(1);
        System.out.println(users);
//        users.setCust_name("changed name 说明一级缓存成功"); //看来没有一级缓存
    }

    @Test
    @Transactional
    public void testGetUsersByNameWithSql() {
        List<Users> list = this.usersDao.selectUserByNameWithSql("tzq");
        System.out.println(list.get(0));
    }

    @Test
    @Transactional
    public void testGetUsersByNameWithHql() {
        List<Users> list = this.usersDao.selectUserByNameWithHql("tzq");
        System.out.println(list.get(0));
    }
    @Test
    @Transactional
    public void testSelectUserByNameWithCriteria() {
        List<Users> list = this.usersDao.selectUserByNameWithCriteria("tzq");
        System.out.println(list.get(0));
    }


}

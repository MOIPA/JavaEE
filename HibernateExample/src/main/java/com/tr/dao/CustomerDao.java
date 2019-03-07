package com.tr.dao;

import com.tr.bean.Customer;
import com.tr.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * sessionFactory: 1. 是线程安全的 消耗很多资源
 * 2. 要保证每个web项目生成一个Factory
 * 3. 工厂模式，用于读取文件配置，生成相应的session
 * session: 1. hibernate的核心对象 负责与数据库和hibernate的链接
 * 2. 可以对数据库做crud
 */
public class CustomerDao {
    //1.增
    public void insertCustomer(Customer customer) {
        //保存客户
        Configuration configure = new Configuration().configure(); //加载src下的主要配置文件
        SessionFactory sessionFactory = configure.buildSessionFactory(); //根据配置信息，创建sessionFactory
        Session session = sessionFactory.openSession(); //获得新的session
//    Session session = sessionFactory.getCurrentSession(); //获得与线程绑定的session

        //session获得事务操作的Transaction对象
//    Transaction transaction = session.getTransaction(); //只获得
        Transaction transaction = session.beginTransaction(); //不仅获得还开始事务操作
        //-----------
//        Customer customer = new Customer();
//        customer.setCust_name("测试公司");

        session.save(customer);
        //------------
        transaction.commit(); //提交事务
//    transaction.rollback();//回滚事务
        session.close();
        sessionFactory.close();
    }

    //2.查
    public void getCustomer(int id) {
        //保存客户
        Configuration configure = new Configuration().configure(); //加载src下的主要配置文件
        SessionFactory sessionFactory = configure.buildSessionFactory(); //根据配置信息，创建sessionFactory
        Session session = sessionFactory.openSession(); //获得新的session
//    Session session = sessionFactory.getCurrentSession(); //获得与线程绑定的session

        //session获得事务操作的Transaction对象
//    Transaction transaction = session.getTransaction(); //只获得
        Transaction transaction = session.beginTransaction(); //不仅获得还开始事务操作
        //-----------
//        Customer customer = new Customer();
//        customer.setCust_name("测试公司");

        Customer customer = session.get(Customer.class, (long) id);
        System.out.println(customer.getCust_name());
        //------------
        transaction.commit(); //提交事务
//    transaction.rollback();//回滚事务
        session.close();
        sessionFactory.close();
    }
//    3.改
public void updateCustomer(Customer customer,int id) {
        //保存客户
//        Configuration configure = new Configuration().configure(); //加载src下的主要配置文件
//        SessionFactory sessionFactory = configure.buildSessionFactory(); //根据配置信息，创建sessionFactory
//        Session session = sessionFactory.openSession(); //获得新的session
//    Session session = sessionFactory.getCurrentSession(); //获得与线程绑定的session

        //session获得事务操作的Transaction对象
//    Transaction transaction = session.getTransaction(); //只获得
    Session session = HibernateUtils.openSession();
    Transaction transaction = session.beginTransaction(); //不仅获得还开始事务操作
        //-----------
//        Customer customer = new Customer();
//        customer.setCust_name("测试公司");

//    Customer customerToChange = session.get(Customer.class, (long) id);
        session.update(customer);
//    System.out.println(customer.getCust_name());
        //------------
        transaction.commit(); //提交事务
//    transaction.rollback();//回滚事务
        session.close();
//        sessionFactory.close();
    }

    public void deleteCustomer(int id) {
        //保存客户
        Configuration configure = new Configuration().configure(); //加载src下的主要配置文件
        SessionFactory sessionFactory = configure.buildSessionFactory(); //根据配置信息，创建sessionFactory
        Session session = sessionFactory.openSession(); //获得新的session
//    Session session = sessionFactory.getCurrentSession(); //获得与线程绑定的session

        //session获得事务操作的Transaction对象
//    Transaction transaction = session.getTransaction(); //只获得
        Transaction transaction = session.beginTransaction(); //不仅获得还开始事务操作
        //-----------
        Customer customer = session.get(Customer.class, (long) id);
        session.delete(customer);
        //------------
        transaction.commit(); //提交事务
//    transaction.rollback();//回滚事务
        session.close();
        sessionFactory.close();
    }
}

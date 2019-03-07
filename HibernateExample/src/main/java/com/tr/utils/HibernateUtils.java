package com.tr.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    static{
        Configuration configure = new Configuration().configure(); //加载src下的主要配置文件
        sessionFactory = configure.buildSessionFactory(); //根据配置信息，创建sessionFactory
    }


    //获得session 1.全新  2.与线程绑定的
    public static Session openSession() {
        Session session = sessionFactory.openSession(); //获得新的session
        return session;
    }
    public static Session getCUrrentSession() {
        Session session = sessionFactory.getCurrentSession(); //获得新的session
        return session;
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
    }
}

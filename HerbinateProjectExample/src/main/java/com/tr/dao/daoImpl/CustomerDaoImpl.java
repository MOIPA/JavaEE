package com.tr.dao.daoImpl;

import com.tr.dao.CustomerDao;
import com.tr.domain.Customer;
import com.tr.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void save(Customer customer) {
        //获得session
        Session session = HibernateUtils.openSession();
        //执行事务
        Transaction transaction = session.beginTransaction();
        //保存
        session.save(customer);
        //提交事务
        transaction.commit();
        session.close();
    }
}

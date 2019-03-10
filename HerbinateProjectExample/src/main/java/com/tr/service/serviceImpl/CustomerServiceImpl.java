package com.tr.service.serviceImpl;

import com.tr.dao.CustomerDao;
import com.tr.dao.daoImpl.CustomerDaoImpl;
import com.tr.domain.Customer;
import com.tr.service.IAddCustomerService;
import com.tr.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;




public class CustomerServiceImpl implements IAddCustomerService {

    private CustomerDao dao = new CustomerDaoImpl();

    public void save(Customer customer) {

        //获得session   这时候customer没有id，不和session关联  瞬时状态
        Session session = HibernateUtils.getCUrrentSession();
        //执行事务
        Transaction transaction = session.beginTransaction();
        try {
            dao.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        //提交事务
        transaction.commit();
        session.close(); //有id 无session 游离状态

    }
}

package com.tr.dao.daoImpl;

import com.tr.dao.CustomerDao;
import com.tr.domain.Customer;
import com.tr.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;


/**
 * 使用criterial
 *
 * 条件查询
 *
 */

public class CustomerDaoInCriteriaImpl implements CustomerDao {
    @Override
    public void save(Customer customer) {
        Session session = HibernateUtils.getCUrrentSession();
        Criteria criteria = session.createCriteria(Customer.class);
        List list = criteria.list();

    }
}

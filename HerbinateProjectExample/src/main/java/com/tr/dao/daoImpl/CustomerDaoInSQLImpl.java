package com.tr.dao.daoImpl;

import com.tr.dao.CustomerDao;
import com.tr.domain.Customer;
import com.tr.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;


/**
 * sql
 */

public class CustomerDaoInSQLImpl implements CustomerDao {
    @Override
    public void save(Customer customer) {
        Session session = HibernateUtils.getCUrrentSession();
        String sql = "select * from cst_custromer";
        Query query = session.createSQLQuery(sql);
//        List<Object[]> list = query.list(); //返回的是每一行
//        for (Object[] objs :
//                list) {
//            System.out.println(Arrays.toString(objs));
//        }

        NativeQuery nativeQuery = ((NativeQuery) query).addEntity(Customer.class);

    }
}

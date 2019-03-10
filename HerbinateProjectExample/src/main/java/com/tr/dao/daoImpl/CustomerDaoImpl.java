package com.tr.dao.daoImpl;

import com.tr.dao.CustomerDao;
import com.tr.domain.Customer;
import com.tr.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * save方法其实是为了生成oid值 所以需要执行insert语句
 * 持久化状态会自动将任何变化同步到数据库，
 */

/**
 * 书写HQL
 * String hql = "from com.tr.domain.Customer where cust_id = 1";  //如果类名不重复 可以不用写包名
 * Query query = session.createQuery(hql);
 *List<Custromer> list =  query.list(); //查询所有结果
 *  query.uniqueResult() ; //查询唯一结果
 *
 * 带参数？的
 *
 * String hql = "from Custromer where cust_id=?"
 * //创建查询对象
 * Query query = session.createQuery(hql);
 *  //设置参数  第一个是参数的位置
 *  query.setLong(0,12") //可以换成setParameter就不用写类型
 *  Customer c  =query.uniqueResult();
 *
 * 命名占位符
 *  String hql = "from Custromer where cust_id = :cust_id"
 *  Query query = session.createQuery(hql);
 *  query.setParameter("cust_id",12);
 *
 * 分页
 *  String hql = "from Custromer"
 *  Query query = session.createQuery(hql);
 *   //设置分页信息
 *   query.setFirstResult(0);  //从哪开始抓
 *   query.setMaxResults(10);   //抓多少
 *  query.list();
 *
 *
 *  hql语句中 不可以出现数据库相关信息
 */
public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void save(Customer customer) {
        //获得session   这时候customer没有id，不和session关联  瞬时状态
        Session session = HibernateUtils.getCUrrentSession();
        //保存
        session.save(customer); //持久化状态
    }
}

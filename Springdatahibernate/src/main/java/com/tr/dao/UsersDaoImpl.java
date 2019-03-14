package com.tr.dao;

import com.tr.pojo.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("userDaoImpl")
public class UsersDaoImpl implements UsersDao {

    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    @Override
    public void insertUsers(Users users) {
        this.hibernateTemplate.save(users);
    }

    @Override
    public void updateUsers(Users users) {
        this.hibernateTemplate.update(users);
    }

    @Override
    public void deleteUsers(Users users) {
        this.hibernateTemplate.delete(users);
    }

    @Override
    public Users selectUserById(int id) {
        Users users = this.hibernateTemplate.get(Users.class, id);  //get方法自动根据主键寻找
        return users;
    }

    //Hql查询
    @Override
    public List<Users> selectUserByNameWithHql(String name) {  //非主键查找 用hql
        Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
        String hql = "from Users where cust_name =:name";
        Query query = session.createQuery(hql).setParameter("name", name);
        return query.list();
    }

    //Sql查询
    @Override
    public List<Users> selectUserByNameWithSql(String name) {  //非主键查找 用sql
        Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
        String sql = "select * from cst_customer where cust_name=?";
        Query query = session.createSQLQuery(sql).addEntity(Users.class);
        query.setParameter(0, name);
        List list = query.list();
        return list;
    }


    //Qbc查询 query by criteria
    @Override
    public List<Users> selectUserByNameWithCriteria(String name) {
        Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Users.class);
        criteria.add(Restrictions.eq("cust_name", name));
        List list = criteria.list();
        return list;
    }

}

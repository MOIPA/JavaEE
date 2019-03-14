package com.tr.dao;

import com.tr.pojo.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("userDaoImpl")
public class UsersDaoImpl implements UsersDao {

//    @Autowired  不可以自动注入
    @PersistenceContext(name = "entityManagerFactory") //从工厂中去一个entityManager给下面
    private EntityManager entityManager;

    @Override
    public void insertUsers(Users users) {
        this.entityManager.persist(users);  //jpa标准 insert是persist方法
    }

    @Override
    public void updateUsers(Users users) {
        this.entityManager.merge(users); //update
    }

    @Override
    public void deleteUsers(Users users) {  //delete
        Users users1 = selectUserById(users.getCust_id());
        this.entityManager.remove(users1);
    }

    @Override
    public Users selectUserById(int id) { //search
        return this.entityManager.find(Users.class,id);
    }

    @Override
    public List<Users> selectUserByNameWithHql(String name) {
        Query query = this.entityManager.createQuery("from Users Where cust_name=:name");
        Query queryTemp = query.setParameter("name", name);
        return queryTemp.getResultList();
    }

    @Override
    public List<Users> selectUserByNameWithSql(String name) {
        //需要注意的是 JPA中下标从1开始
        Query nativeQuery = this.entityManager.createNativeQuery("select * from cst_customer where cust_name=?", Users.class);
        Query query = nativeQuery.setParameter(1, name);
        List resultList = query.getResultList();
        return resultList;
    }

    @Override
    public List<Users> selectUserByNameWithCriteria(String name) {
        //创建criteriaBuilder对象 用于创建criteriaQuery，定义一些查询条件
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
//        criteriaQuery对象
        CriteriaQuery<Users> query = criteriaBuilder.createQuery(Users.class);
        //获取要查询的实体类对象
        Root<Users> root = query.from(Users.class);
        //封装查询条件
        Predicate cate = criteriaBuilder.equal(root.get("cust_name"), name);
        query.where(cate);
        //开始查询
        TypedQuery<Users> typedQuery = this.entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}

package com.tr.serviceImpl;

import com.tr.dao.CustomerDao;
import com.tr.daoImpl.CustomerDaoImpl;
import com.tr.domain.Customer;
import com.tr.service.IAddCustomerService;

public class CustomerServiceImpl implements IAddCustomerService {

    private CustomerDao dao = new CustomerDaoImpl();

    public void save(Customer customer) {
        dao.save(customer);
    }
}

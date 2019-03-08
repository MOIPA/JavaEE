package com.tr.servlet;

import com.tr.domain.Customer;
import com.tr.service.IAddCustomerService;
import com.tr.serviceImpl.CustomerServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class AddCustomerServlet extends HttpServlet {
    private IAddCustomerService customerService = new CustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = new Customer();
        try {
            //        获得参数封装为Customer
            BeanUtils.populate(customer, req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 调用service保存客户
        customerService.save(customer);
        //重定向到客户列表
        resp.sendRedirect(req.getContextPath()+"/ListCustomerServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}

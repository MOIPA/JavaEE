package com.tr.web.servlet;

import com.tr.domin.Order;
import com.tr.service.OrderService;
import com.tr.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderDetailServlet",urlPatterns = "/orderDetail")
public class OrderDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderid = request.getParameter("orderid");
        OrderService orderService = new OrderServiceImpl();
        Order order =  orderService.getDetailInfoById(orderid);
        request.setAttribute("detailInfo", order);
        request.getRequestDispatcher("/order/orderDetail.jsp").forward(request, response);
    }
}

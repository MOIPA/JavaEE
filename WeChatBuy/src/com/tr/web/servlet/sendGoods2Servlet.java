package com.tr.web.servlet;

import com.tr.service.OrderService;
import com.tr.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "sendGoods2Servlet",urlPatterns = "/test222")
public class sendGoods2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do post send goods");
        String orderid = request.getParameter("orderid");
        System.out.println("do send goods");
        OrderService orderService = new OrderServiceImpl();
        boolean isSuc = orderService.sendGoods(orderid);
        if (isSuc == true) {
            response.getWriter().write("{\"data\":\"success\"}");
        }else {
            response.getWriter().write("{\"data\":\"error\"}");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do get send goods");
        doPost(request,response);
    }
}

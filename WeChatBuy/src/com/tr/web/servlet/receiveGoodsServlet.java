package com.tr.web.servlet;

import com.tr.service.OrderService;
import com.tr.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SendGoodsServlet",urlPatterns = "/receiveGoods")
public class receiveGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderid = request.getParameter("orderid");
        System.out.println("do receive goods");
        OrderService orderService = new OrderServiceImpl();
        boolean isSuc = orderService.receiveGoods(orderid);
        if (isSuc == true) {
            response.getWriter().write("{\"data\":\"success\"}");
        }else {
            response.getWriter().write("{\"data\":\"error\"}");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

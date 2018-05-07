package com.tr.web.servlet;

import com.tr.service.OrderService;
import com.tr.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PassOrderServlet",urlPatterns = "/pass")
public class PassOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderid = request.getParameter("orderid");
        OrderService orderService = new OrderServiceImpl();
        boolean isSucceed = orderService.passBehaviour(orderid);
        response.setCharacterEncoding("utf-8");
        if(!isSucceed)response.getWriter().write("{\"data\":\"失败\"}");
        else response.getWriter().write("{\"data\":\"成功\"}");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

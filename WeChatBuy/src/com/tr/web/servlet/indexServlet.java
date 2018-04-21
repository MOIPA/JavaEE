package com.tr.web.servlet;

import com.tr.domin.Order;
import com.tr.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "index",urlPatterns = "/index")
public class indexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String com = req.getParameter("com");
        OrderService service = new OrderService();
        //最热订单
        List<Order>hotList =  service.getHotOrderList(com);
        //最新订单
        List<Order>newList =  service.getNewOrderList(com);
        req.setAttribute("hotOrderList",hotList);
        req.setAttribute("newOrderList",newList);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}

package com.tr.web.servlet;

import com.tr.domin.Follower;
import com.tr.domin.Order;
import com.tr.service.OrderService;
import com.tr.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderDetailServlet",urlPatterns = "/orderDetail")
public class OrderDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderid = request.getParameter("orderid");
        OrderService orderService = new OrderServiceImpl();
        List<String> urlLists = orderService.getPicUrls(orderid);
        Order order =  orderService.getDetailInfoById(orderid);
        List<Follower> followerList = orderService.getFollower(orderid);
        request.setAttribute("detailInfo", order);
        request.setAttribute("urlLists",urlLists);
        request.setAttribute("followerList",followerList);
        request.getRequestDispatcher("/order/orderDetail.jsp").forward(request, response);
    }
}

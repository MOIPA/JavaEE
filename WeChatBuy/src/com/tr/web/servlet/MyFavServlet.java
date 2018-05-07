package com.tr.web.servlet;

import com.tr.domin.Order;
import com.tr.domin.User;
import com.tr.service.OrderService;
import com.tr.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MyFavServlet",urlPatterns = "/myfav")
public class MyFavServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User userInfo = (User) session.getAttribute("userInfo");
        String aid = userInfo.getAid();
//
        OrderService orderService = new OrderServiceImpl();
        List<Order> followedList =  orderService.getMyFollowedOrder(aid);
        List<Order> postedList =  orderService.getMyPostedOrder(aid);
        request.setAttribute("followedList", followedList);
        request.setAttribute("postedList", postedList);
        request.getRequestDispatcher("/my-fav.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

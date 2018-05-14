package com.tr.web.servlet;

import com.tr.domin.UserPay;
import com.tr.service.OrderService;
import com.tr.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CheckByerPayPicServlet",urlPatterns = "/checkbyer")
public class CheckByerPayPicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderid = request.getParameter("orderid");
        OrderService orderService = new OrderServiceImpl();
        List<UserPay> userPayList = orderService.getPayedOrder(orderid);
        request.setAttribute("userPayList", userPayList);
        request.getRequestDispatcher("/order/checkPay.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

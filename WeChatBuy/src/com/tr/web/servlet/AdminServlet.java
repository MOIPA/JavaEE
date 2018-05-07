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

@WebServlet(name = "AdminServlet",urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.getWriter().print("admin");
        HttpSession session = request.getSession();
        User admin = (User) session.getAttribute("userInfo");
        String cname = admin.getCname();
        OrderService orderService = new OrderServiceImpl();
        List<Order> unPassedList = orderService.getUnPassedOrderListByCname(cname);
//        System.out.println(cname);
        List<Order> passedList = orderService.getPassedOrderListByCname(cname);
        request.setAttribute("unPassedList", unPassedList);
        request.setAttribute("passedList", passedList);
        request.getRequestDispatcher("/admin.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

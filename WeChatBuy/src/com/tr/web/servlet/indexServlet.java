package com.tr.web.servlet;

import com.tr.domin.Order;
import com.tr.domin.User;
import com.tr.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "index",urlPatterns = "/index")
public class indexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        User userInfo = (User) session.getAttribute("userInfo");
//        String com = req.getParameter("com");
        String com = userInfo.getCname();
        OrderServiceImpl service = new OrderServiceImpl();
        //最热订单
        List<Order>orderList =  service.getHotOrderList(com);
        //最新订单
        List<Order>activityList =  service.getNewOrderList(com);
        req.setAttribute("orderList",orderList);
        req.setAttribute("activityList",activityList);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}

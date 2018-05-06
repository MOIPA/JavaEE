package com.tr.web.servlet;

import com.tr.domin.User;
import com.tr.service.OrderService;
import com.tr.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "FollowServlet",urlPatterns = "/follow")
public class FollowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String orderid = "";
        for (Cookie c :
                cookies) {
            if (c.getName().equals("orderid")) {
                orderid = c.getValue();
            }
        }
        String remark = request.getParameter("remark");
        HttpSession session = request.getSession();
        User userinfo = (User) session.getAttribute("userInfo");
        String aid = userinfo.getAid();
        Logger logger = Logger.getLogger("follow");
        logger.setLevel(Level.ALL);
        logger.info("跟单逻辑 orderid:" + orderid + " aid:" + aid + " remark:" + remark);

        OrderService orderService = new OrderServiceImpl();
        boolean isSucceed = orderService.followBehaviour(remark, aid, orderid);
        response.setContentType("text/html;charset=utf-8");
        if (isSucceed) {
            response.getWriter().print("跟单成功");
        }else{
            response.getWriter().print("请设置您的收货地址");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

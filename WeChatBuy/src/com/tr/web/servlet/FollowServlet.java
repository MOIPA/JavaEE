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

@WebServlet(name = "FollowServlet", urlPatterns = "/follow")
public class FollowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        Cookie[] cookies = request.getCookies();
        String ByerPayUrl = "";
        String orderid = "";
        String remark = "";
        for (Cookie c :
                cookies) {
            if (c.getName().equals("orderid")) {
                orderid = c.getValue();
            }
            if (c.getName().equals("ByerPayUrl")) {
                ByerPayUrl = c.getValue();
            }
            if (c.getName().equals("remark")) {
                remark = c.getValue();
            }
        }

        HttpSession session = request.getSession();
        User userinfo = (User) session.getAttribute("userInfo");
        String aid = userinfo.getAid();
        Logger logger = Logger.getLogger("follow");
        logger.setLevel(Level.ALL);
        logger.info("跟单逻辑 orderid:" + orderid + " aid:" + aid + " remark:" + remark + " byerPayUrl" + ByerPayUrl);

        OrderService orderService = new OrderServiceImpl();
        int statuCode = orderService.followBehaviour(remark, aid, orderid,ByerPayUrl);
        if (0 == statuCode) {
            response.sendRedirect(request.getContextPath()+"/waitAndJump2Index.jsp?data="+java.net.URLEncoder.encode("跟单成功".toString(),"utf-8"));
//            response.getWriter().write("跟单成功");
        } else if (1 == statuCode) {
            response.sendRedirect(request.getContextPath()+"/waitAndJump2Index.jsp?data="+java.net.URLEncoder.encode("参与活动成功".toString(),"utf-8"));
//            response.getWriter().write("参与活动成功");
        } else if (-1 == statuCode) {
            response.sendRedirect(request.getContextPath()+"/waitAndJump2Index.jsp?data="+java.net.URLEncoder.encode("未设置订单地址".toString(),"utf-8"));
//            response.getWriter().write("未设置订单地址");
        } else if (-2 == statuCode) {
            response.sendRedirect(request.getContextPath()+"/waitAndJump2Index.jsp?data="+java.net.URLEncoder.encode("已经参与过".toString(),"utf-8"));
//            response.getWriter().write("已经参与过");
        } else if (-3 == statuCode) {
            response.sendRedirect(request.getContextPath()+"/waitAndJump2Index.jsp?data="+java.net.URLEncoder.encode("活动人数已满".toString(),"utf-8"));
//            response.getWriter().write("活动人数已满");
        } else if (-11 == statuCode) {
            response.sendRedirect(request.getContextPath()+"/waitAndJump2Index.jsp?data="+java.net.URLEncoder.encode("服务器繁忙".toString(),"utf-8"));
//            response.getWriter().write("服务器繁忙");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

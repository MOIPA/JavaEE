package com.tr.web.servlet;

import com.tr.domin.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "MyInfoServlet",urlPatterns = "/myinfo")
public class MyInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User userInfo = (User) session.getAttribute("userInfo");
        String account = userInfo.getAccount();
        String cname = userInfo.getCname();
        String uiconsrc = userInfo.getUiconsrc();
        String identity = userInfo.getIdentity();
        String aid = userInfo.getAid();
        request.setAttribute("account",account);
        request.setAttribute("cname",cname);
        request.setAttribute("uiconsrc",uiconsrc);
        request.setAttribute("identity",identity);
        request.setAttribute("aid",aid);
        request.getRequestDispatcher("/FAKE-me.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

package com.tr.web.servlet;

import com.tr.domin.User;
import com.tr.service.UserService;
import com.tr.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "SignInServlet",urlPatterns = "/signIn")
public class SinInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger = Logger.getLogger("signIn");
        logger.setLevel(Level.ALL);
        request.setCharacterEncoding("utf-8");
        //1 . 获取数据
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        //2.封装数据 处理数据
        UserService userService = new UserServiceImpl();
        User userInfo = userService.signInAccount(account, password);

        if (userInfo != null) {
            //得到用户的信息
            logger.info("登陆者身份："+userInfo.getIdentity());
            HttpSession session = request.getSession();
            logger.info("sign in com : "+userInfo.getCname());
            session.setAttribute("userInfo", userInfo);
            if(userInfo.getIdentity().trim().equals("admin")||userInfo.getIdentity().trim().equals("管理员"))
                response.sendRedirect(request.getContextPath() + "/admin");
            else response.sendRedirect(request.getContextPath() + "/index");
        } else {
            response.sendRedirect(request.getContextPath() + "/signin.jsp");
            
        }
//        if (isSign) response.sendRedirect(request.getContextPath() + "/index.jsp");
//        else response.sendRedirect(request.getContextPath() + "/signin.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

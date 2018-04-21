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

@WebServlet(name = "SignInServlet",urlPatterns = "/signIn")
public class SinInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        UserService userService = new UserServiceImpl();
        User userInfo = userService.signInAccount(account, password);
        if(userInfo!=null){
            //得到用户的信息
            HttpSession session = request.getSession();
            session.setAttribute("userInfo", userInfo);
            response.sendRedirect(request.getContextPath()+"/index");
        }else{
            response.sendRedirect(request.getContextPath() + "/signin.jsp");
        }
//        if (isSign) response.sendRedirect(request.getContextPath() + "/index.jsp");
//        else response.sendRedirect(request.getContextPath() + "/signin.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

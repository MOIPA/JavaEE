package com.tr.web.servlet;

import com.tr.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CheckUserName",urlPatterns = "/CheckUserName")
public class CheckUserAccountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        UserServiceImpl userService = new UserServiceImpl();
        boolean checkUserAccount = userService.checkUserAccount(username);
        resp.getWriter().write("{\"isAccountExist\":"+checkUserAccount+"}");
    }

}

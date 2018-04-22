package com.tr.web.servlet;

import com.tr.service.UserService;
import com.tr.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetCommunityServlet",urlPatterns = "/GetCommunity")
public class GetCommunityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
//        List<String> allCommunity = userService.getAllCommunity();
        String allCommunity = userService.getAllCommunity();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(allCommunity);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

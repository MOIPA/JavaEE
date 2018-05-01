package com.tr.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PostActivityServlet",urlPatterns = "/postactivity")
public class PostActivityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String theme = request.getParameter("theme");
        String endtime = request.getParameter("endtime");
        String desc = request.getParameter("desc");
        String savedPicSrc = request.getParameter("savedPicSrc");
        System.out.println( " : " + theme+" : " + endtime+" : " + desc+" : " + savedPicSrc);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

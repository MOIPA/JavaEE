package com.tr.web.servlet;

import com.tr.domin.User;
import com.tr.service.UserService;
import com.tr.service.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "signup",urlPatterns = "/signUp")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        boolean isSign = false;
        UserService userService = new UserServiceImpl();
        Map<String, String[]> reqParameterMap = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, reqParameterMap);
            isSign = userService.signUpAcocunt(user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        resp.setCharacterEncoding("utf-8");
        //成功回到头像上传页面
        if(isSign){ resp.sendRedirect(req.getContextPath() + "/uploadAvatar.jsp?aid="+user.getAid());}
        //失败返回注册
        else { resp.sendRedirect(req.getContextPath() + "/signup.jsp");}

    }
}

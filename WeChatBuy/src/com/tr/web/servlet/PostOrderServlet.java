package com.tr.web.servlet;

import com.tr.domin.PostOrderInfo;
import com.tr.domin.User;
import com.tr.service.OrderService;
import com.tr.service.OrderServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static com.tr.utils.CommonUtil.editCookie;

@WebServlet(name = "PostOrderServlet",urlPatterns = "/postorder")
public class PostOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        String theme = request.getParameter("theme");
//        String endtime = request.getParameter("endtime");
//        String desc = request.getParameter("desc");
//        String savedPicSrc = request.getParameter("savedPicSrc");
//        System.out.println( " : " + theme+" : " + endtime+" : " + desc+" : " + savedPicSrc);
        Map<String, String[]> map = request.getParameterMap();
        PostOrderInfo postOrderInfo = new PostOrderInfo();
        HttpSession session = request.getSession();
        User userInfo = (User) session.getAttribute("userInfo");

        try {
            BeanUtils.populate(postOrderInfo, map);
            String aid = userInfo.getAid();
            String com = userInfo.getCname();
            postOrderInfo.setCom(com);
            postOrderInfo.setPromulgatorid(aid);
            Date date = new Date();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String formatTime = sf.format(date);
            postOrderInfo.setPostTime(formatTime);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(postOrderInfo.getSavedPicSrc());

        OrderService orderServiceImpl = new OrderServiceImpl();
        int orderId = orderServiceImpl.uploadOrderInfo(postOrderInfo);
        editCookie(request,response,"orderId",orderId+"");
        response.sendRedirect(request.getContextPath()+"/order/uploadPayCode.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }


}

package com.tr.web.servlet;

import com.tr.service.OrderServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UploadPayCodeServlet",urlPatterns = "/uplodaPayCode")
public class UploadPayCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String account = "";
        String orderId = "";
        Cookie[] cookies = request.getCookies();
        if(cookies!=null&&cookies.length>0)
        for (Cookie c :
                cookies) {
            if (c.getName().equals("account")) {
                account = c.getValue();
            }
            if (c.getName().equals("orderId")) {
                orderId = c.getValue();
            }
        }


        OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
        String savePath = this.getServletContext().getRealPath("/PayCode");
        try {
            //处理request里面的文件上传流 封装为List<item>传递给service
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");
            //判断是否为表单数据
            if (!ServletFileUpload.isMultipartContent(request)) {
                //按照传统方式获取数据  这些数据不做处理
            }
            List<FileItem> list = upload.parseRequest(request);

            boolean isSucceed = orderServiceImpl.saveUserPayCode(savePath, list, orderId);
            if (isSucceed) {
                response.sendRedirect(request.getContextPath()+"/order/postSucceed.jsp");
            }else{
                response.getWriter().write("alert('无法上传，请重试！')");
                response.sendRedirect(request.getContextPath()+"/order/uploadPayCode.jsp");
            }
        } catch (Exception e) {
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

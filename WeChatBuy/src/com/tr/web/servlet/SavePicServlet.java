package com.tr.web.servlet;

import com.tr.service.OrderServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SavePicServlet", urlPatterns = "/savepic")
public class SavePicServlet extends HttpServlet {

    /**
     * 此servlet用于接收用户上传的图片，返回存储地址的json串
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
        PrintWriter writer = response.getWriter();
        String savePath = this.getServletContext().getRealPath("/postedPic");
        String picUrlList = "";
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

            picUrlList = orderServiceImpl.savePic(savePath, list);
        } catch (Exception e) {
        }
        writer.print(picUrlList);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

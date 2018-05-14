package com.tr.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommonUtil {

    /**
     * 解析url 分离
     * @param parseString
     * @return 返回url列表
     */
    public static List<String> splitUrl(String parseString){

        List<String> urlList = new ArrayList<String>();
        //去掉PicUrl:||
        String leftString = parseString.substring(parseString.indexOf("||")+2);
        //存在分离符号||
        int posi = 0;
        while ((posi = leftString.indexOf("||")) > 0) {  //PicUrl:||test.jpg||test.jpg||test.jpg
            urlList.add(leftString.substring(0, posi));
            leftString = leftString.substring(posi + 2);
        }
        urlList.add(leftString);

//        String check = "url list check ==>";
//        for(int i=0;i<urlList.size();i++) {
//            check += urlList.get(i)+"-->";
//        }
//        Logger checkUrlList = Logger.getLogger("checkUrlList");
//        checkUrlList.setLevel(Level.ALL);
//        checkUrlList.info(check);
        return urlList;
    }

    public static void editCookie(HttpServletRequest request, HttpServletResponse response, String name, String value){
        Cookie[] cookies = request.getCookies();
        if (null==cookies) {
            System.out.println("没有cookie==============");
        } else {
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(name)){
                    System.out.println("原值为:"+cookie.getValue());
                    cookie.setValue(value);
                    cookie.setPath("/");
                    cookie.setMaxAge(30 * 60);// 设置为30min
                    System.out.println("被修改的cookie名字为:"+cookie.getName()+",新值为:"+cookie.getValue());
                    response.addCookie(cookie);
                    return;
                }
            }
            response.addCookie(new Cookie(name,value));
        }

    }

}

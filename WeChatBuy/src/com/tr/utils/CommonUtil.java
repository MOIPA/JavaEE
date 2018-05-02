package com.tr.utils;

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

}

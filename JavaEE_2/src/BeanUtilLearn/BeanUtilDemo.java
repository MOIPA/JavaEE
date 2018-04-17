package BeanUtilLearn;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class BeanUtilDemo {

    public static void main(String args[]){

        Map<String,String> properties = new HashMap<>();
        properties.put("name","tr");
        properties.put("pwd", "123");
        properties.put("date", "1991-11-11");

        User user = new User();
        //测试数据转化  date属性需要指定转换器
        try {
            ConvertUtils.register(new Converter() {
                @Override
                public Object convert(Class aClass, Object o) {
                    //string to date
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date parse = null;
                    try {
                        parse = format.parse((String) o);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return parse;
                }
            }, Date.class);
            BeanUtils.populate(user, properties);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.getName() + ":" + user.getPwd()+":"+user.getDate());

    }

}

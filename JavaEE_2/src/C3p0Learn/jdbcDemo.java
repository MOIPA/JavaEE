package C3p0Learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//注册驱动程序常量

public class jdbcDemo {

    public static void main(String[] args) {

        try { //加载MySql的驱动类
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace();
        }
        String url = "jdbc:mysql://192.168.52.131:3306/javaee" ;
        String username = "tr" ;
        String password = "0800" ;
        try{
            Connection con = DriverManager.getConnection(url , username , password ) ;
        }catch(SQLException se){
            System.out.println("数据库连接失败！");
            se.printStackTrace() ;
        }
    }

}

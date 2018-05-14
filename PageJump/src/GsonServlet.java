import bean.UserBean;
import com.google.gson.Gson;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GsonServlet",urlPatterns = "/gson")
public class GsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        Gson gson = new Gson();
        //获取数据
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        //获取Json并且解析
        String json_t = request.getParameter("json_t");

        //解析json转为bean
        System.out.println("接收的json串" + json_t);
        UserBean toUserBean = gson.fromJson(json_t, UserBean.class);
        System.out.println("转为实体类的数据：name==>"+toUserBean.getName()+"\n转为实体类的数据：age==>"+toUserBean.getAge());

        //转为json
        UserBean fromUserBean = new UserBean();
        fromUserBean.setAge(age);
        fromUserBean.setName(name);
        String s = gson.toJson(fromUserBean);

        response.getWriter().write(s);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

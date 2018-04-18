import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "checkUserName",urlPatterns = "/checkUserName")
public class checkUserNameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得用户名
        String username = req.getParameter("username");

        //通过services层获得是否存在的bool值
        String json="{\"isNameExist\":false}";
        System.out.println(json);
        resp.getWriter().write(json);
    }
}

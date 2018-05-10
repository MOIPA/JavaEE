import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "SenderServlet",urlPatterns = "/sender")
public class SenderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = "the name";

        //cookie
        Cookie cookie = new Cookie("cookieInfo", "theSookie");
        response.addCookie(cookie);


        //session
        HttpSession session = request.getSession();
        session.setAttribute("sessionInfo","theSession");

        response.sendRedirect(request.getContextPath()+"/receiver.jsp?name="+name);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

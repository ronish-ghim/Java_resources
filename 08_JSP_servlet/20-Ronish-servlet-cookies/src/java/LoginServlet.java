import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");

        Cookie c1 = new Cookie("userName", userName);
        Cookie c2 = new Cookie("userPassword", userPassword);
        res.addCookie(c1);
        res.addCookie(c2);

        out.println("<h2>Cookies set successfully</h2>");
        out.println("<a href='view'>View Cookies</a>");
    }
}

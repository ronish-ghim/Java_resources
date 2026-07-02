import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyServlet2 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        HttpSession session = req.getSession(false);
        if (session != null) {
            String college = (String) session.getAttribute("college");
            out.println("<h2>College: " + college + "</h2>");
        } else {
            out.println("<h2>No session found</h2>");
        }
    }
}

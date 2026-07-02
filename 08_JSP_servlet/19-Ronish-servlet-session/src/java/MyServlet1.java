import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyServlet1 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        HttpSession session = req.getSession();
        session.setAttribute("college", "Samriddhi College");
                
        out.println("<h2>Session attribute set</h2>");
        out.println("<a href='view'>View Session</a>");
    }
}

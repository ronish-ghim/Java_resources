import javax.servlet.*;
import java.io.*;

public class LifeCycleServlet implements Servlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        System.out.println("in init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException {
        System.out.println("in service");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h2>Hello from LifeCycleServlet</h2>");
    }

    @Override
    public String getServletInfo() {
        return "LifeCycleServlet";
    }

    @Override
    public void destroy() {
        System.out.println("in destroy");
    }
}

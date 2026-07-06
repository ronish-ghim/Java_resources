# Lab 18: Ronish servlet lifecycle

## Source Code

### LifeCycleServlet.java

```java
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LifeCycleServlet implements Servlet {
    private ServletConfig config;

    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        System.out.println("in init");
    }

    public ServletConfig getServletConfig() {
        return config;
    }

    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException {
        System.out.println("in service");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h2>Hello from LifeCycleServlet</h2>");
    }

    public String getServletInfo() {
        return "LifeCycleServlet";
    }

    public void destroy() {
        System.out.println("in destroy");
    }
}
```

### index.html

```html
<html>
<body>
    <form action="lifecycle">
        <input type="submit" value="Call LifeCycleServlet">
    </form>
</body>
</html>
```
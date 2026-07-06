# Lab 19: Ronish servlet session

## Source Code

### MyServlet1.java

```java
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
```

### MyServlet2.java

```java
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyServlet2 extends HttpServlet {
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
```

### index.html

```html
<html>
<body>
    <a href="store">Store Session Attribute</a>
</body>
</html>
```
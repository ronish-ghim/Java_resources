# Lab 19: Servlet Session

## Objective
Demonstrate HttpSession by setting an attribute in one servlet and reading it in another.

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

### web.xml
```xml
<web-app>
    <servlet>
        <servlet-name>Servlet1</servlet-name>
        <servlet-class>MyServlet1</servlet-class>
    </servlet>
    <servlet>
        <servlet-name>Servlet2</servlet-name>
        <servlet-class>MyServlet2</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>Servlet1</servlet-name>
        <url-pattern>/store</url-pattern>
    </servlet-mapping>
    <servlet-mapping>
        <servlet-name>Servlet2</servlet-name>
        <url-pattern>/view</url-pattern>
    </servlet-mapping>
</web-app>
```

## Output
Clicking "store" sets session attribute and shows a link to "view". Clicking "view" displays "College: Samriddhi College".

## Conclusion
Learned to use HttpSession to share data across multiple servlets for the same user session.

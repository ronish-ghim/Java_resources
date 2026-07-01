# Lab 20: Servlet Cookies

## Objective
Demonstrate cookies by storing username/password in LoginServlet and reading them in ViewCookiesServlet.

## Source Code

### LoginServlet.java
```java
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
```

### ViewCookiesServlet.java
```java
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ViewCookiesServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("<p>" + c.getName() + ": " + c.getValue() + "</p>");
            }
        } else {
            out.println("<p>No cookies found</p>");
        }
    }
}
```

### index.html
```html
<html>
<body>
    <form action="login" method="post">
        Username: <input type="text" name="userName"><br>
        Password: <input type="password" name="userPassword"><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
```

### web.xml
```xml
<web-app>
    <servlet>
        <servlet-name>Login</servlet-name>
        <servlet-class>LoginServlet</servlet-class>
    </servlet>
    <servlet>
        <servlet-name>ViewCookies</servlet-name>
        <servlet-class>ViewCookiesServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>Login</servlet-name>
        <url-pattern>/login</url-pattern>
    </servlet-mapping>
    <servlet-mapping>
        <servlet-name>ViewCookies</servlet-name>
        <url-pattern>/view</url-pattern>
    </servlet-mapping>
</web-app>
```

## Output
Login form submits to /login, sets cookies, then clicking "View Cookies" shows userName and userPassword.

## Conclusion
Learned to create and read cookies in servlets for client-side data storage.

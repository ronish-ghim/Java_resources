# Module 08 — Servlet / JSP

## Sub-programs

### 1. Servlet Lifecycle
**Path:** `18-Ronish-servlet-lifecycle/src/java/LifeCycleServlet.java`
**Path:** `18-Ronish-servlet-lifecycle/web/index.html`

```java
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
```
```html
<html>
<body>
    <form action="lifecycle">
        <input type="submit" value="Call LifeCycleServlet">
    </form>
</body>
</html>
```

### 2. Servlet Session
**Path:** `19-Ronish-servlet-session/src/java/MyServlet1.java`
**Path:** `19-Ronish-servlet-session/src/java/MyServlet2.java`
**Path:** `19-Ronish-servlet-session/web/index.html`

```java
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyServlet1 extends HttpServlet {
    @Override
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
```java
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
```
```html
<html>
<body>
    <a href="store">Store Session Attribute</a>
</body>
</html>
```

### 3. Servlet Cookies
**Path:** `20-Ronish-servlet-cookies/src/java/LoginServlet.java`
**Path:** `20-Ronish-servlet-cookies/src/java/ViewCookiesServlet.java`
**Path:** `20-Ronish-servlet-cookies/web/index.html`

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
```java
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ViewCookiesServlet extends HttpServlet {
    @Override
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

### 4. JSP Cookies
**Path:** `21-Ronish-jsp-cookies/web/index.jsp`
**Path:** `21-Ronish-jsp-cookies/web/welcome.jsp`
**Path:** `21-Ronish-jsp-cookies/web/display.jsp`

```jsp
<html>
<body>
    <form action="welcome.jsp" method="post">
        Username: <input type="text" name="userName"><br>
        Password: <input type="password" name="userPassword"><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
```
```jsp
<html>
<body>
<%
    String userName = request.getParameter("userName");
    String userPassword = request.getParameter("userPassword");

    Cookie c1 = new Cookie("userName", userName);
    Cookie c2 = new Cookie("userPassword", userPassword);
    response.addCookie(c1);
    response.addCookie(c2); 
%>
<h2>Cookies set successfully</h2>
<a href="display.jsp">View Cookies</a>
</body>
</html>
```
```jsp
<html>
<body>
<h2>All Cookies:</h2>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            out.println("<p>" + c.getName() + ": " + c.getValue() + "</p>");
        }
    } else {
        out.println("<p>No cookies found</p>");
    }
%>
</body>
</html>
```

### 5. JSP Form Display
**Path:** `22-Ronish-jsp-form-display/web/index.jsp`
**Path:** `22-Ronish-jsp-form-display/web/displayStudent.jsp`

```jsp
<html>
<body>
<h2>Student Form</h2>
<form action="displayStudent.jsp" method="post">
    Name: <input type="text" name="name"><br>
    Roll No: <input type="text" name="rollNo"><br>
    Class: <input type="text" name="className"><br>
    Address: <input type="text" name="address"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
```
```jsp
<html>
<body>
<h2>Student Details</h2>
<table border="1">
    <tr><th>Field</th><th>Value</th></tr>
    <tr><td>Name</td><td><%= request.getParameter("name") %></td></tr>
    <tr><td>Roll No</td><td><%= request.getParameter("rollNo") %></td></tr>
    <tr><td>Class</td><td><%= request.getParameter("className") %></td></tr>
    <tr><td>Address</td><td><%= request.getParameter("address") %></td></tr>
</table>
</body>
</html>
```

### 6. JSP Simple Interest
**Path:** `23-Ronish-jsp-simple-interest/web/index.html`
**Path:** `23-Ronish-jsp-simple-interest/web/calculateSI.jsp`

```html
<html>
<body>
<h2>Simple Interest Calculator</h2>
<form action="calculateSI.jsp" method="post">
    Principal: <input type="text" name="principal"><br>
    Time (years): <input type="text" name="time"><br>
    Rate (%): <input type="text" name="rate"><br>
    <input type="submit" value="Calculate">
</form>
</body>
</html>
```
```jsp
<html>
<body>
<%
    double p = Double.parseDouble(request.getParameter("principal"));
    double t = Double.parseDouble(request.getParameter("time"));
    double r = Double.parseDouble(request.getParameter("rate"));
    double si = (p * t * r) / 100;
%>
<h2>Simple Interest Result</h2>
<table border="1">
    <tr><th>Field</th><th>Value</th></tr>
    <tr><td>Principal</td><td><%= p %></td></tr>
    <tr><td>Time (years)</td><td><%= t %></td></tr>
    <tr><td>Rate (%)</td><td><%= r %></td></tr>
    <tr><td>Simple Interest</td><td><%= si %></td></tr>
</table>
</body>
</html>
```

### 7. Test
**Path:** `test/web/index.html`

```html
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>TODO write content</div>
    </body>
</html>
```

# Lab 21: JSP Cookies

## Objective
Create cookies in JSP from form parameters and display them on another JSP page.

## Source Code

### index.jsp
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

### welcome.jsp
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

### display.jsp
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

## Output
Form → welcome.jsp creates cookies → display.jsp shows "userName: value" and "userPassword: value".

## Conclusion
Learned to work with cookies in JSP using scriptlets and the request/response implicit objects.

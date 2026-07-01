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

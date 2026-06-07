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

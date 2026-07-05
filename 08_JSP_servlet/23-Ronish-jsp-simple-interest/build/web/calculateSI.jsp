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

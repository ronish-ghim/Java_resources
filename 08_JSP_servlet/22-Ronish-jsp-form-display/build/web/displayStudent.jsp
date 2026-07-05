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

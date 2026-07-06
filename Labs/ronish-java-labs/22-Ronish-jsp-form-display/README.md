# Lab 22: Ronish jsp form display

## Source Code

### displayStudent.jsp

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

### studentForm.jsp

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
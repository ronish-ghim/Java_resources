# Lab 22: JSP Form Display

## Objective
Create a student form and display the submitted data in an HTML table using JSP.

## Source Code

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

## Output
Student form submits to displayStudent.jsp which shows a bordered HTML table with the submitted field values.

## Conclusion
Learned to use JSP expressions and request.getParameter to process and display form data.

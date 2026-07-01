# Lab 23: JSP Simple Interest

## Objective
Calculate simple interest using JSP. Input principal, time, and rate; display inputs and result in a table.

## Source Code

### simpleInterestForm.jsp
```jsp
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

### calculateSI.jsp
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

## Output
Form for principal, time, rate. Submitting shows a table with inputs and the calculated simple interest.

## Conclusion
Learned to perform arithmetic calculations in JSP scriptlets and display results using expressions.

<%@ page import="java.util.List"  %>
<%@ page import="ru.geekbrains.model.Cat"  %>
<%@ page contentType="text/html; character=utf-8" language="java" %>


<html>
    <head>
    <title>Animal</title>
    </head>
<body>
<h1>Animal</h1>
<p>Name: ${cat.name}</p>
<p>Age: ${cat.age}</p>
<p>Children</p>
<hr>
<ul>
<% if (((Cat)request.getAttribute("cat")).getChildren() != null) %>
<% for(Cat value : (List<Cat>) ((Cat)request.getAttribute("cat")).getChildren()) { %>
    <li>name: <%=value.getName()%>; age <%=value.getAge()%></li>
<% } %>
</ul>
<hr>
</body>
</html>
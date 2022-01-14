<%@ page import="java.util.List"  %>
<%@ page import="ru.geekbrains.model.Product"  %>
<%@ page contentType="text/html; character=utf-8" language="java" %>

<html>
    <head>
    <title>Products</title>
    </head>
<body>
<h2>Products</h2>
<ul>
<% for(Product value : (List<Product>)request.getAttribute("product") ){ %>
    <li><%=value.getId()%>: <%=value.getTitle()%> - <%=value.getCost()%></li>
<% } %>
</ul>
</body>
</html>
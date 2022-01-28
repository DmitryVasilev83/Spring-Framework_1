<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message list</title>
</head>
<body>
<h1>Message list:</h1>
<ul>
    <c:forEach var="messages" items="${messages}">
        <c:url var="viewUrl" value="/message/ + ${message.id}">
        <li>
            <a href="${viewUrl}">View</a>
            Message from: ${message.from}
            <br>
            Message to: ${message.to}
            <br>
            Message: ${message.body}
            <br>
        </li>

    </c:forEach>
</ul>
<br>
<c:url var="createUrl" value="/message/create"/>
<a href="${createUrl}">EDIT</a>

</body>
</html>
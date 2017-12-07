<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: VLADIMIR
  Date: 07.12.2017
  Time: 8:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>JSTL Page</title>
</head>
<body>

<%-- таблица --%>
<table border='1'>
    <%-- заголовки таблицы --%>
    <tr>
        <th>Name</th>
        <th>Login</th>
        <th>Email</th>
    </tr>
    <%-- тело таблицы --%>
    <%--<% for (User user : this.users.get()) { %>--%>
    <c:forEach items="${users}" var="user">
        <tr>
                <%-- Name --%>
            <td>
                <c:out value="${user.name}"></c:out>
            </td>
                <%-- Login --%>
            <td>
                <c:out value="${user.login}"></c:out>
            </td>
                <%-- Email --%>
            <td>
                <c:out value="${user.email}"></c:out>
            </td>
                <%-- кнопка UPDATE --%>
            <td>
                <form action='${pageContext.request.contextPath}/update' method='get'>
                    <button value='${user.name}' name='userName' type='submit'>Update</button>
                </form>
            </td>
                <%-- кнопка DELETE --%>
            <td>
                <form action='${pageContext.request.contextPath}/delete' method='get'>
                    <button value='${user.name}' name='userName' type='submit'>Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br/>

<%-- кнопка ADD --%>
<form action='${pageContext.request.contextPath}/add' method='get'>
    <button type='submit'>Add</button>
</form>

</body>

</html>
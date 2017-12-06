<%@ page import="ru.job4j.store.UserStore" %>
<%@ page import="ru.job4j.models.User" %>

<%--
  Created by IntelliJ IDEA.
  User: VLADIMIR
  Date: 05.12.2017
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- SCRIPLET IN CLASS --%>
<%! private final UserStore users = UserStore.getInstance(); %>


<html>
<head>
    <title>JSP Page</title>
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
    <% for (User user : this.users.get()) { %>
    <tr>
        <%-- Name --%>
        <td>
            <%= user.getName() %>
        </td>
        <%-- Login --%>
        <td>
            <%= user.getLogin() %>
        </td>
        <%-- Email --%>
        <td>
            <%= user.getEmail() %>
        </td>
        <%-- кнопка UPDATE --%>
        <td>
            <form action='<%= request.getContextPath() %>/update.jsp' method='get'>
                <button value='<%= user.getName() %>' name='userName' type='submit'>Update</button>
            </form>
        </td>
        <%-- кнопка DELETE --%>
        <td>
            <form action='<%= request.getContextPath() %>/delete.jsp' method='get'>
                <button value='<%= user.getName() %>' name='userName' type='submit'>Delete</button>
            </form>
        </td>
    </tr>
    <% } %>
</table>
<br/>

<%-- кнопка ADD --%>
<form action='<%= request.getContextPath() %>/add.jsp' method='get'>
    <button type='submit'>Add</button>
</form>

</body>

</html>

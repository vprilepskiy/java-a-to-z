<%@ page import="ru.job4j.models.User" %>
<%@ page import="ru.job4j.store.UserStore" %><%--
  Created by IntelliJ IDEA.
  User: VLADIMIR
  Date: 05.12.2017
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%! private final UserStore users = UserStore.getInstance(); %>

<html>
<head>
    <title>JSP Page</title>
</head>
<body>

<%--кнопка назад--%>
<form action='<%= request.getContextPath() %>/index.jsp' method='get'>
    <button type='submit'>Back</button>
</form>
<br/>

<%--получить редактируемого пользователя--%>
<% final String userName = request.getParameter("userName"); %>
<% final User user = this.users.getByName(new User(userName)); %>

<%--редактрирование пользователя--%>
<form action='<%= request.getContextPath() %>/JSP/update' method='post'>
    Name : <input value='<%= user.getName() %>' type='text' name='name' readonly/><br/>
    Login : <input value='<%= user.getLogin() %>' type='text' name='login'/><br/>
    Email : <input value='<%= user.getEmail() %>' type='text' name='email'/><br/><br/>
    <input type='submit' value='Update'><br/>
</form>
<br/>


<%--обновлено записей--%>
<% final String rows = request.getParameter("rows"); %>

<% if (rows != null) { %>
Updated users: <%= rows %>
<% } %>

</body>
</html>

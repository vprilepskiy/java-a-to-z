<%--
  Created by IntelliJ IDEA.
  User: VLADIMIR
  Date: 05.12.2017
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<%--ввод нового пользователя--%>
<form action='<%= request.getContextPath() %>/JSP/add' method='post'>
    Name : <input type='text' name='name'/><br/>
    Login : <input type='text' name='login'/><br/>
    Email : <input type='text' name='email'/><br/><br/>
    <input type='submit' value='Add'><br/>
</form>
<br/>


<%--добавлено кол-во записей--%>
<% final String rows = request.getParameter("rows"); %>

<% if (rows != null) { %>
Added users: <%= rows %>
<% } %>
</body>
</html>

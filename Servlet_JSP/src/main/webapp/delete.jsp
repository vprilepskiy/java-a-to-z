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
    </form><br/>

    <% final String userName = request.getParameter("userName"); %>

    <%--уверен?--%>
    <h3>Delete user: '<%= userName %>' ?</h3><br/>

    <%--кнопка Да--%>
    <form action='<%= request.getContextPath() %>/JSP/delete' method='post'>
        <button value='<%= userName %>' name='userName' type='submit'>Yes</button>
    </form>

</body>
</html>

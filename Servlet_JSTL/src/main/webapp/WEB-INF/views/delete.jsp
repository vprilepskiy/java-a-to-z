<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>JSTL Page</title>
</head>
<body>

<%--кнопка назад--%>
<form action='${pageContext.request.contextPath}/' method='get'>
    <button type='submit'>Back</button>
</form>
<br/>

    <%--уверен?--%>
    <h3>
        <c:out value="Delete user: '${userName}' ?"></c:out>
    </h3><br/>

    <%--кнопка Да--%>
    <form action='${pageContext.request.contextPath}/delete' method='post'>
        <button value='${userName}' name='userName' type='submit'>Yes</button>
    </form>

</body>
</html>

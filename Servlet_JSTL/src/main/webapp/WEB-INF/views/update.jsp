<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: VLADIMIR
  Date: 05.12.2017
  Time: 12:37
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

<%--редактрирование пользователя--%>
<form action='${pageContext.request.contextPath}/update' method='post'>
    Name : <input value='${user.name}' type='text' name='name' readonly/><br/>
    Login : <input value='${user.login}' type='text' name='login'/><br/>
    Password : <input value='${user.password}' type='password' name='password'/><br/>
    Email : <input value='${user.email}' type='text' name='email'/><br/><br/>
    Role : <select name="role">
    <%--Роль по умолчанию--%>
    <option value='${user.role.description}' selected disabled hidden>
        <c:out value="${user.role.description}"></c:out>
    </option>
        <%--выбор роли--%>
    <c:forEach items="${roles}" var="getRole">
        <option value='${getRole.description}'>
            <c:out value="${getRole.description}"></c:out>
        </option>
    </c:forEach>
</select>
    <input type='submit' value='Update'><br/>
</form>
<br/>


<%--добавлено кол-во записей--%>
<c:if test="${rows != null}">
    <c:out value="Updated users: ${rows}"></c:out>
</c:if>

</body>
</html>

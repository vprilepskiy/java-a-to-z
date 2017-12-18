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
<br>

<%--кнопка назад--%>
<form action='${pageContext.request.contextPath}/' method='get'>
    <button type='submit'>Back</button>
</form>
<br/>

<%--ввод нового пользователя--%>
<form action='${pageContext.request.contextPath}/add' method='post'>
    Name : <input type='text' name='name'/><br/>
    Login : <input type='text' name='login'/><br/>
    Password : <input type='password' name='password'/><br/>
    Email : <input type='text' name='email'/><br/>
    Role : <select name="role">
    <c:forEach items="${roles}" var="getRole">
        <option value='${getRole.description}'>
            <c:out value="${getRole.description}"></c:out>
        </option>
    </c:forEach>
</select>
    <br/>
    <input type='submit' value='Add'><br/>
</form>
<br/>


<%--добавлено кол-во записей--%>
<c:if test="${rows != null}">
    <c:out value="Added users: ${rows}"></c:out>
</c:if>


</body>
</html>

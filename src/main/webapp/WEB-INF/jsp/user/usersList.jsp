<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/2/21
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userList</title>
</head>
<body>
<table width="100%" border=1>
    <tr>
        <td>用户id</td>
        <td>用户名称</td>
        <td>用户生日</td>
        <td>用户的性别</td>
        <td>地址</td>
    </tr>
    <c:forEach items="${usersList }" var="usersList">
        <tr>
            <td>${itemsCustom.id }</td>
            <td>${itemsCustom.username }</td>
            <td><fmt:formatDate value="${itemsCustom.birthday}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>${itemsCustom.sex }</td>
            <td>${itemsCustom.address }</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>

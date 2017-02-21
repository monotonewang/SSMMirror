<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/2/21
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--http://blog.csdn.net/lzblog/article/details/22076893--%>

<%--原理（摘抄）：应用部署运行的时候出现JSP异常, 发生在使用JSTL库的时候:
 According to TLD or attribute directive in tag file,
  attribute value does not accept any expressions,
  可能是因为使用了JSP2.0版本, 同时又没有使用JSTL core库的备用版本(RT库)。--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>userList</title>
</head>
<body>
<table width="100%" border=1>
    <tr>
        <td>用户id</td>
        <td>用户名称</td>
        <td>用户img</td>
        <td>用户生日</td>
        <td>用户的性别</td>
        <td>地址</td>
    </tr>
    <c:forEach items="${usersList }" var="users">
        <tr>
            <td>${users.id }</td>
            <td>${users.username }</td>
            <td>${users.pic }</td>

            <td><fmt:formatDate value="${users.birthday}" pattern="yyyy-MM-dd "/></td>
            <%--<td><fmt:formatDate value="${users.birthday}" pattern="yyyy-MM-dd HH:mm:ss"/></td>--%>

            <td>${users.sex }</td>
            <td>${users.address }</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>

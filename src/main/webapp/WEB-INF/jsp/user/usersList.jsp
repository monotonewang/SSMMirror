<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/2/21
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--http://blog.csdn.net/lzblog/article/details/22076893--%>

<%--原理（摘抄）：应用部署运行的时候出现JSP异常, 发生在使用JSTL库的时候:
 According to TLD or attribute directive in tag file,
  attribute value does not accept any expressions,
  可能是因为使用了JSP2.0版本, 同时又没有使用JSTL core库的备用版本(RT库)。--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>--%>
<html xmlns="http://www.w3.org/1999/xhtml">
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
            <td><fmt:formatDate value="${users.birthday}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>
                <c:if test="${users.sex=='1'}">男</c:if>
                <c:if test="${users.sex=='0'}">女</c:if>
            </td>
            <td>${users.address }</td>
        </tr>
    </c:forEach>
        <input type="text" class="sang_Calender"/>
</table>

<script type="text/javascript" src="datetime.js"></script>

</body>
</html>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%--
  Created by IntelliJ IDEA.
  ListenerUser: WangTest
  Date: 2016/12/6
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>遍历数组</h4>
<%
    String[] arrs = {"美美", "小凤", "芙蓉", "小苍"};
    request.setAttribute("arrs", arrs);
%>
<!-- for(String s : arrs){ }  -->
<c:forEach var="s" items="${ arrs }">
    ${ s }
</c:forEach>

<h4>遍历集合</h4>
<%
    List<String> list = new ArrayList<String>();
    list.add("美美");
    list.add("小凤");
    list.add("芙蓉");
    list.add("小泽");
    request.setAttribute("list", list);
%>
<c:forEach var="s" items="${ list }">
    ${ s }
</c:forEach>
<h4>遍历Map集合</h4>
<%
    Map<String, String> map = new HashMap<>();
    map.put("aa","美美");
    map.put("bb","小强");
    map.put("cc","小明");
    request.setAttribute("map",map);
%>
<c:forEach var="entity" items="${map}">
    ${ user.username } -- ${ user.password }
</c:forEach>



<h4>迭代数据</h4>
<h4>迭代从1到10</h4>
<c:forEach var="i" begin="1" end="10" step="2">
    ${ i }
</c:forEach>


<h4>计算从1加到100的和</h4>
<c:set var="sum" value="0" scope="page"></c:set>
<c:forEach var="i" begin="1" end="100" step="1" varStatus="status">
    <c:set var="sum" value="${ sum + i }"></c:set>
</c:forEach>
${ sum }


<h4>遍历10到100的偶数，每到第3个数，显示红色</h4>
<c:forEach var="i" begin="10" end="100" step="2" varStatus="status">
    <c:choose>
        <c:when test="${ status.first }">
            <font color="blue">${ i }</font>
        </c:when>
        <c:when test="${ status.count % 3 eq 0 }">
            <font color="red">${ i }</font>
        </c:when>
        <c:otherwise>
            ${ i }
        </c:otherwise>
    </c:choose>
</c:forEach>
</body>
</html>

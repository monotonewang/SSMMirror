<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询商品列表</title>
</head>
<body>
<h1>Test Interceptor</h1>
当前用户：${username }
<c:if test="${username!=null }">
    <a href="${pageContext.request.contextPath }/logout.action">退出</a>
</c:if>

<form name="itemForms" action="${pageContext.request.contextPath }/item/queryItem.action" method="post">
    查询条件：
    <table width="100%" border=1>
        <tr>
            <td><input type="submit" value="查询"/></td>
            <td><input type="button" value="删除" onclick="deleteItems()"/></td>
            <td><input type="button" value="添加商品" onclick="addItems()"/></td>
            <td><input type="text" id="test" value="test"/></td>
            <td>
                <select>
                    <%--通过el取地址符--%>
                    <c:forEach items="${itemsType}" var="item">
                        <option value="${item.key}">${item.value}</option>
                    </c:forEach>
                </select>
            </td>

        </tr>
    </table>
    商品列表：<br/>
    全选：<input type="checkbox" id="getAll" onclick="selectAll()" />
    <table width="100%" border=1>
        <tr>
            <td>选择</td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品图片</td>
            <td>商品描述</td>
            <td>操作</td>
            <td>商品修改</td>
            <td>rest连接</td>
        </tr>
        <c:forEach items="${itemsList }" var="item">
            <tr>

                <td><input type="checkbox" name="delete_id" value="${item.id}"></td>
                <td>${item.id }</td>
                <td>${item.name }</td>
                <td>${item.price }</td>
                <td>${item.pic }</td>
                <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${item.detail }</td>

                <td><a href="${pageContext.request.contextPath }/item/editItem.action?id=${item.id}">修改</a></td>
                <td><a href="${pageContext.request.contextPath }/item/viewItems/${item.id}">商品查看</a></td>

            </tr>
        </c:forEach>

    </table>
</form>
</body>
<script type="text/javascript">
    function deleteItems() {
        //将form的action指向删除商品的地址
        document.itemForms.action = "${pageContext.request.contextPath}/item/delItemsListSubmit.action";
        document.itemForms.submit();
//            $(":checkbox:checked").remove()
    }
    function addItems() {
        //            测试查看contextPath的值
        <%--${pageContext.request.contextPath} equals "/SSMMirror"--%>
        var test = document.getElementById("test");
        test.value = "${pageContext.request.contextPath}";

        document.itemForms.action = "${pageContext.request.contextPath}/item/addItem.action";
        document.itemForms.submit();
//            window.location.href="addItem.jsp";
    }

    function selectAll(){
        //1.得到id为main的这个checkbox
        var checkbox=  document.getElementById("getAll");
        var flag=checkbox.checked;
        //2.得到所有name=ck的checkbox
        var ck=document.getElementsByName("delete_id");

        //3.将cks中所有的checkbox的checked值设置为flag
        for(var i=0;i<ck.length;i++){
            ck[i].checked=flag;
        }
    }
</script>
</html>
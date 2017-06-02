<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询商品列表</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">

    function myClick() {
        //            测试查看contextPath的值
        <%--${pageContext.request.contextPath} equals "/SSMMirror"--%>
        <%--var test = document.getElementById("test");--%>
        <%--test.value = "${pageContext.request.contextPath}";--%>
        console.log("调用了 myClick")
        document.itemForms.action = "${pageContext.request.contextPath}/item/addItem.action";
        document.itemForms.submit();
        //            window.location.href="addItem.jsp";
    }

</script>
<script type="text/javascript">

</script>
<script type="text/javascript">
    $(function () {
        //3.当点击全选按钮的时候所有delete_id被选中
        $('#getAll').click(function () {
            console.log("click")
            $(':checkbox[name="delete_id"]').prop('checked', true);
        });
        console.log("hello");
        //
        //        选中全选以后，再次点击，则下面的delete_id都不选中
        $('#getAll').click(function () {
            console.log("click again")
            var checked = this.checked;
            $(':checkbox[name="delete_id"]').prop('checked', checked);

            //        当选中delete_id时候，全部选中时更新全选按钮
            $(':checkbox[name="delete_id"]').click(function () {
                var checked = $(':checkbox[name=delete_id]:not(:checked)').length === 0;
                $('#getAll').prop('checked', checked);
            });

        });
    })
</script>

<%--<script type="text/javascript">--%>


<%--function selectAll() {--%>
<%--console.log("select all");--%>
<%--//1.得到id为main的这个checkbox--%>
<%--var checkbox = document.getElementById("getAll");--%>
<%--var flag = checkbox.checked;--%>
<%--//2.得到所有name=ck的checkbox--%>
<%--var ck = document.getElementsByName("delete_id");--%>

<%--//3.将cks中所有的checkbox的checked值设置为flag--%>
<%--for (var i = 0; i < ck.length; i++) {--%>
<%--ck[i].checked = flag;--%>
<%--}--%>
<%--}--%>

<%--//    var list = new Array();--%>
<%--//--%>
<%--//    /**--%>
<%--//     * 移除此列表中指定位置上的元素。--%>
<%--//     * @param index 指定位置--%>
<%--//     * @return 此位置的元素--%>
<%--//     */--%>
<%--//    function removeIndex(index) {--%>
<%--//        var object = this.list[index];--%>
<%--//        this.list.splice(index, 1);--%>
<%--//        return object;--%>
<%--//    }--%>

<%--</script>--%>
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

            <td><input type="button" value="添加商品" onclick="myClick()"/></td>
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
    全选：<input type="checkbox" id="getAll"/>
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
        <c:forEach items="${itemsList }" var="itemsCustom">
            <tr>
                <td><input type="checkbox" name="delete_id" value="${itemsCustom.id}"></td>
                <td>${itemsCustom.id }</td>
                <td>${itemsCustom.name }</td>
                <td>${itemsCustom.price }</td>
                <td>${itemsCustom.pic }</td>
                <td><fmt:formatDate value="${itemsCustom.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${itemsCustom.detail }</td>
                <td><a href="${pageContext.request.contextPath }/item/editItem.action?id=${itemsCustom.id}">修改</a></td>
                <td><a href="${pageContext.request.contextPath }/item/viewItems/${itemsCustom.id}">商品查看</a></td>
                <td><a href="${pageContext.request.contextPath }/item/delItemsListSubmit.action?id=${itemsCustom.id}">删除带id</a>
                </td>
                <td><input type="button" value="删除" onclick="function myDeletes() {
                        //获取所有选中的checkbox
                        var ck = document.getElementsByName('delete_id');
                        for (var i = 0; i < ck.length; i++) {
                        if (ck[i].checked) {

                        } else {
                    <%--${itemsList}.removeIndex(j);--%>
                        }
                        }
                        var itemsList = new Array();
                        itemsList.push('1');
                        itemsList.push('2');
                        itemsList.push('3');
                        itemsList.push('4');

                        $.ajax({
                        url: "${pageContext.request.contextPath }/item/delItemsListSubmit.action",
                    type: "post",
                    contentType: "application/json;charset=utf-8",
                    //请求key/value数据

                    data: {
                    "itemsList":${itemsList}

                    }
                    ,
                    success: function (data) {
                    console.log(data.name);
                    // alert(data.name);
                    }
                    })
                    ;
                    }
                    myDeletes()"/>
                </td>
            </tr>
        </c:forEach>

    </table>
</form>
</body>

</html>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/2/20
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>addItem</title>
</head>
<body>
<script language="javascript" type="text/javascript"
        src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script type="application/javascript">
</script>
<%--<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/MyDate/yui-min.js"></script>--%>
<%--enctype支持上传图片--%>
<form id="itemForm" action="${pageContext.request.contextPath }/item/addItemSubmit.action" method="post"
      enctype="multipart/form-data">
    <input type="text" name="id" value="${id }" placeholder="请在这里是商品id" readonly="true"/>
    <%--<input type="hidden" name="id" value="${item.id }"/>--%>
    <%--修改商品信息：--%>
    <table width="100%" border=1>
        <tr>
            <td>商品名称</td>
            <td><input type="text" name="name" value="" placeholder="请在这里输入用户名"/></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><input type="text" name="price" value="${itemCustom.price }" placeholder="请在这里输入价格"/></td>
        </tr>
        <tr>
            <td>商品生产日期</td>
            <td><input type="text" name="createtime" class="Wdate" onclick="WdatePicker()" readonly="readonly"
                       value="<fmt:formatDate value="${itemCustom.createtime }"  pattern="yyyy-MM-dd HH-mm-ss"/>"/></td>
        </tr>
        <tr>
            <td>商品图片</td>
            <td>
                <input type="file" name="pictureFile"/>
            </td>
        </tr>
        <tr>
            <td>商品简介</td>
            <td>
                <textarea rows="3" cols="30" name="detail">${itemCustom.detail } placeholder="请在这里输入商品详情"</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"/>
            </td>
        </tr>
    </table>

</form>
</body>
</html>

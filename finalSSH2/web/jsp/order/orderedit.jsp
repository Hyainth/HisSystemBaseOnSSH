<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link href="${pageContext.request.contextPath }/bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1 align="center">
    修改订单信息

</h1>
<form action="order_update.action" method="post">
    <table align="center">

        <tr>
            <td>订单编号</td><td> <s:textfield name="order.orderID" readonly="true" style="color:#CCCCCC"></s:textfield></td>
        </tr>

        <tr>
            <td>会员</td>
            <td>
                <s:select name="order.mebID" list="members" listKey="mebID" listValue="mebID+'|'+mebName"></s:select></td>
        </tr>

        <tr>
            <td>项目</td>
            <td>
                <s:select name="order.projID" list="projects" listKey="projID" listValue="projID+'|'+projName"></s:select></td>
        </tr>

        <tr>
            <td>数量</td><td> <s:textfield name="order.num"></s:textfield></td>
        </tr>

        <tr>
            <td>预约时间</td><td> <s:textfield name="order.appotime"></s:textfield></td>
        </tr>

        <tr>
            <td>状态</td>
            <td>
                <s:select name="order.state" list="#{'待支付':'待支付','待就诊':'待就诊','完成':'完成'}"></s:select></td>
        </tr>

        <tr>
            <td> <input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
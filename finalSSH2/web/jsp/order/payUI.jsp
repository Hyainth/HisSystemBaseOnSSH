<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link href="${pageContext.request.contextPath }/bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form action="order_pay.action" method="post">
    <table align="center">

        <tr>
            <td>项目</td><td> <s:textfield name="order.projID" readonly="true" style="color:#CCCCCC"></s:textfield></td>
        </tr>

        <tr>
            <td>数量</td><td> <s:textfield name="order.num" readonly="true" style="color:#CCCCCC"></s:textfield></td>
        </tr>

        <tr>
            <td>预约时间</td><td> <s:textfield name="order.appotime" readonly="true" style="color:#CCCCCC"></s:textfield></td>
        </tr>

        <tr>
            <td>二维码</td><td> <img src="${pageContext.request.contextPath }/img/erweima.png" style="height: 100px;width: 100px"></td>
        </tr>

        <tr>
            <s:hidden name="order.orderID"></s:hidden>
            <td> <input type="submit" value="付费"></td>
        </tr>
    </table>
</form>

</body>
</html>
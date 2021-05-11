<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link href="${pageContext.request.contextPath }/bootstrap/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-3.3.1.min.js"></script>
</head>
<body align="center">
<h1>订单信息</h1>
<form id="form1" action="order_findAllOrder.action" method="post">
    项目：
    <%-- 	<s:select name="staff.depart" list="departs" listKey="departname" listValue="departname"></s:select> --%>
    <select name="order.projID" onchange="topage(1)">
        <option value="">---请选择---</option>
        <s:iterator value="projects" >
            <option ${projID==order.projID?"selected":""} value="${projID}">${projID}|${projName}</option>
        </s:iterator>
    </select>
    会员：<s:textfield name="order.mebID" ></s:textfield>

    <input type="button" value="查询" onclick="topage(1)">

    <p>
    <table width="90%" border="1" align="center">
        <tr>
            <th>订单编号</th>
            <th>会员ID</th>
            <th>项目ID</th>
            <th>数量</th>
            <th>预约时间</th>
            <th>订单状态</th>
            <th>操作</th>
        </tr>
        <s:iterator value="page.records" >
            <tr>
                <td align="center">${orderID}</td>
                <td align="center">${mebID}</td>
                <td align="center">${projID}</td>
                <td align="center">${num}</td>
                <td align="center">${appotime}</td>
                <td align="center">${state}</td>
                <td><s:a action="order_editUI">
                    <s:param name="order.orderID" value="%{orderID}"></s:param>
                    修改
                </s:a>
                </td>
            </tr>
        </s:iterator>
    </table>
    <!-- 分页的开始 -->
    <%@ include file="/jsp/common/page.jsp" %>
    <!-- 分页的结束 -->
</form>
</body>
</html>
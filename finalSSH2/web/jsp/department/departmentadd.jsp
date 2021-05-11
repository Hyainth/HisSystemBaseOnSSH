<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>医院预约管理系统</title>
<link href="${pageContext.request.contextPath }/bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1 align="center">
	新增部门信息

</h1>
<form action="department_save.action" method="post">
<table align="center">
	<tr>
		<td>部门ID</td><td> <s:textfield name="department.depID" ></s:textfield></td>
	</tr>
	<tr>
		<td>部门名</td><td> <s:textfield name="department.depName" ></s:textfield></td>
	</tr>
	<tr>
		<td>联系电话</td><td> <s:textfield name="department.phone" ></s:textfield></td>
	</tr>
	<tr>
		<td> <input type="submit" value="提交"></td>
	</tr>
</table>
</form>
</body>
</html>
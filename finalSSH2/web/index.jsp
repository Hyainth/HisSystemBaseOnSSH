<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link href="${pageContext.request.contextPath }/bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<s:debug></s:debug>
<div align="center">
<h2>欢迎使用医院收费管理系统！${message }</h2>
<form action="account_login.action" method="post">
	<table>
		<tr>
			<td>账号</td>
			<td><input type="text" name=account.userID> </td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name=account.pwd> </td>
		</tr>
		<tr>
			<td><input type="submit"  value="登录"> </td>
			<td><input type="reset"  value="重置"></td>
			<td><a href="account_registerUI.action">注册</a></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>
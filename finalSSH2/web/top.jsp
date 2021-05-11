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
<table width="100%">
	<tr>
		<td width="60%" align="right"><h2>医院挂号管理系统</h2></td>
		<td width="40%" align="right">
			当前用户：${account.userID} 类型： ${account.kindStr}<a href="account_pwdUI.action" target="main"> 修改密码</a>
			<a href="account_logout.action" target="_top">退出</a>
		</td>
	</tr>
</table>
</body>
</html>
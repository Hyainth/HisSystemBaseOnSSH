<%@ page import="org.hibernate.Session" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>医院挂号管理系统</title>
    <link href="${pageContext.request.contextPath }/bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1 align="center">
    修改密码

</h1>
<form action="account_changePWD.action" method="post" target="main">
    <br>
    <table align="center">
        <tr>
            <td>原密码</td>
            <td><s:password name="oldpwd"></s:password></td>
        </tr>
        <tr>
            <td>新密码</td>
            <td><s:password name="pwd"></s:password></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交" id="submitButton"></td>
        </tr>
    </table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册</title>
    <link href="${pageContext.request.contextPath }/bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1 align="center">
    注册账号

</h1>
<form action="account_register.action" method="post">
    <table align="center">
        <tr>
            <td>账号</td><td> <s:textfield name="member.mebID" ></s:textfield></td>
        </tr>
        <tr>
            <td>密码</td><td> <s:password name="account.pwd" ></s:password></td>
        </tr>
        <tr>
            <td>姓名</td><td> <s:textfield name="member.mebName" ></s:textfield></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <s:radio list="#{'男':'男','女':'女'}" name="member.sex" value="男"/>
            </td>
        </tr>

        <tr>
            <td>手机号</td><td> <s:textfield name="member.phone" ></s:textfield></td>
        </tr>
        <tr>
            <td> <input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
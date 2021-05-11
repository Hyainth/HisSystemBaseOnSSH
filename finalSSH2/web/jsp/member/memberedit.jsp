<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>医院收费管理系统</title>
    <link href="${pageContext.request.contextPath }/bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1 align="center">
    <s:if test="#session.account.kind==0">
        修改会员
    </s:if>

    <s:if test="#session.account.kind==1">
        修改个人信息
    </s:if>

</h1>
<form action="account_update.action" method="post">
    <table align="center">
        <tr>
            <td>姓名</td>
            <td><s:textfield name="member.mebName"></s:textfield></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <s:radio list="#{'男':'男','女':'女'}" name="member.sex"/>
            </td>
        </tr>

        <tr>
            <td>手机号</td>
            <td><s:textfield name="member.phone"></s:textfield></td>
        </tr>

        <s:if test="#session.account.kind==0">
            <tr>
                <td>注册日期</td>
                <td><s:textfield name="member.resdate"></s:textfield></td>
            </tr>
        </s:if>

        <tr>
            <s:if test="#session.account.kind==1">
                <s:hidden name="member.resdate"></s:hidden>
            </s:if>
            <s:hidden name="member.mebID"></s:hidden>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>医院收费管理系统</title>
    <link href="${pageContext.request.contextPath }/bootstrap/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-3.3.1.min.js"></script>
    <script>
        function delOne(mebID) {
            // alert(projID);
            var sure = window.confirm("确定删除吗？");
            if (sure) {
                window.location.href = "account_removeMember.action?member.mebID=" + mebID;
            }
        }
    </script>
</head>
<body align="center">
<h1>会员信息</h1>
<form id="form1" action="account_findAllMember.action" method="post">
    会员名：<s:textfield name="member.mebName"></s:textfield>

    <input type="button" value="查询" onclick="topage(1)">

    <p>
    <table width="90%" border="1" align="center">
        <tr>
            <th>会员ID</th>
            <th>会员名</th>
            <th>性别</th>
            <th>手机号</th>
            <th>注册时间</th>
            <th>操作</th>
        </tr>
        <s:iterator value="page.records">
            <tr>
                <td align="center">${mebID}</td>
                <td align="center">${mebName}</td>
                <td align="center">${sex}</td>
                <td align="center">${phone}</td>
                <td align="center">${resdate}</td>
                <td>
                    <s:a action="account_editUI.action">
                        <s:param name="member.mebID" value="%{mebID}"></s:param>
                        修改
                    </s:a>

                    <s:a href="javascript:delOne('%{mebID}')">删除</s:a>
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
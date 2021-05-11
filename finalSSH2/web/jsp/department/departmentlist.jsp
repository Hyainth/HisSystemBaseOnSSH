<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>企业员工管理系统</title>
    <link href="${pageContext.request.contextPath }/bootstrap/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/bootstrap.min.js"></script>
    <script>

        function delOne(depID) {
            //alert(id);
            var sure = window.confirm("确定删除吗？");
            if (sure) {
                window.location.href = "department_removeDepartment.action?department.depID=" + depID + "";
            }
        }

    </script>
</head>
<body align="center">
<h2>部门信息列表</h2>
<form id="form1" action="department_findAllDepartment.action" method="post">
    名称：<s:textfield name="department.depName"></s:textfield>

    <input type="submit" value="查询">
</form>
<p>
<table width="90%" border="1" align="center">
    <tr>
        <th>部门编号</th>
        <th>部门名</th>
        <th>联系电话</th>
        <s:if test="#session.account.kind==0">
            <th>操作</th>
        </s:if>
    </tr>
    <s:iterator value="departments">
        <tr>
            <td align="center">${depID}</td>
            <td align="center">${depName}</td>
            <td align="center">${phone}</td>
            <s:if test="#session.account.kind==0">
                <td>
                    <s:a action="department_editUI">
                        <s:param name="department.depID" value="%{depID}"></s:param>
                        修改
                    </s:a>
                    <s:a href="javascript:delOne('%{depID}')">删除</s:a>
                </td>
            </s:if>
        </tr>
    </s:iterator>
</table>

</div>
</body>
</html>
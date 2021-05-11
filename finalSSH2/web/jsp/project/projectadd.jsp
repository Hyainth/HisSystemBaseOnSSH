<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link href="${pageContext.request.contextPath }/bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1 align="center">
    新增项目信息

</h1>
<form action="project_save.action" method="post">
    <table align="center">
        <tr>
            <td>部门</td>
            <td>
                <s:select name="project.depID" list="departments" listKey="depID" listValue="depID+'|'+depName"></s:select></td>
        </tr>
        <tr>
            <td>项目ID</td><td> <s:textfield name="project.projID" ></s:textfield></td>
        </tr>

        <tr>
            <td>项目名</td><td> <s:textfield name="project.projName" ></s:textfield></td>
        </tr>

        <tr>
            <td>单位</td><td> <s:textfield name="project.unit" ></s:textfield></td>
        </tr>

        <tr>
            <td>价格</td><td> <s:textfield name="project.price" ></s:textfield></td>
        </tr>

        <td>简介</td><td> <s:textarea name="project.notes" cols="30" rows="5"></s:textarea> </td>

        <tr>
            <td> <input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
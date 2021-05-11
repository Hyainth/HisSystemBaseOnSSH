<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link href="${pageContext.request.contextPath }/bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<h4>功能列表：</h4>
<ul>
    <li>项目管理
        <ul>
            <s:if test="#session.account.kind==0">
                <li><a href="project_saveUI.action" target=main>新增项目</a><br></li>
            </s:if>
            <li><a href="project_findAllProject.action" target=main>项目列表</a>
            </li>
        </ul>
    </li>
    <li>部门管理
        <ul>
            <s:if test="#session.account.kind==0">
                <li><a href="department_saveUI.action" target=main>新增部门 </a></li>
            </s:if>
            <li><a href="department_findAllDepartment.action" target=main>部门列表</a></li>
        </ul>
    </li>
    <li>会员管理
        <ul>
            <s:if test="#session.account.kind==1">
                <li>
                    <a href="account_editMy.action" target="main">
                        个人信息修改
                    </a>
                </li>
            </s:if>

            <s:if test="#session.account.kind==0">
                <li><a href="account_findAllMember.action" target="main">会员列表</a></li>
            </s:if>
        </ul>
    </li>
    <li>挂号订单
        <ul>
            <s:if test="#session.account.kind==0">
                <li><a href="order_saveUI.action" target=main>新增订单</a></li>
                <li><a href="order_findAllOrder.action" target=main>订单汇总</a></li>
            </s:if>
            <s:if test="#session.account.kind==1">
                <li><a href="order_findMyOrder.action" target=main>我的订单</a></li>
            </s:if>
        </ul>
    </li>
</ul>
</body>
</html>
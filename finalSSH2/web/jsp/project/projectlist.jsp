<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link href="${pageContext.request.contextPath }/bootstrap/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/bootstrap.min.js"></script>
    <script>

        function delOne(projID) {
            // alert(projID);
            var sure = window.confirm("确定删除吗？");
            if (sure) {
                window.location.href = "project_removeProject.action?project.projID=" + projID;
            }
        }

        function order(projID, projName) {
            // alert(projID);
            $('#form_order').get(0).reset();
            $('#form_order [name="order.projID"]').val(projID);
            $('#form_order [name="projName"]').val(projName);
            $('#form_order [name="order.num"]').val(1);
            $('#modal_order').modal('show');
        }

        function saveOrder() {
            var obj = new Object();
            var array = $('#form_order').serializeArray();
            if (array == null || array.length == 0) {
                return;
            } else {
                for (var i = 0; i < array.length; i++) {
                    obj[array[i].name] = array[i].value;
                }
            }
            var num = $('#form_order [name="order.num"]').val();
            if (num == '') {
                alert('数量必须填写');
                $('#form_order [name="order.num"]').focus();
                return false;
            }
            $.post('order_savemyorder.action', obj, function (data) {
                alert(data);
            });
            $('#modal_order').modal('hide');
        }

    </script>
</head>
<body align="center">
<h1>信息显示</h1>
<form id="form1" action="project_findAllProject.action" method="post">
    部门：
    <%-- 	<s:select name="staff.depart" list="departs" listKey="departname" listValue="departname"></s:select> --%>
    <select name="project.depID" onchange="topage(1)">
        <option value="">---请选择---</option>
        <s:iterator value="departments">
            <option ${depID==project.depID?"selected":""} value="${depID}">${depID}|${depName}</option>
        </s:iterator>
    </select>
    项目名：<s:textfield name="project.projName"></s:textfield>

    <input type="button" value="查询" onclick="topage(1)">


<p>
<table width="90%" border="1" align="center">
    <tr>
        <th>项目ID</th>
        <th>项目名</th>
        <th>部门ID</th>
        <th>单位</th>
        <th>价格</th>
        <th>备注</th>
        <th>操作</th>
    </tr>
    <s:iterator value="page.records">
        <tr>
            <td align="center">${projID}</td>
            <td align="center">${projName}</td>
            <td align="center">${depID}</td>
            <td align="center">${unit}</td>
            <td align="center">${price}</td>
            <td align="center">${notes}</td>

            <td>
                <s:if test="#session.account.kind==1">
                    <s:a href="javascript:order('%{projID}','%{projName}')">预约</s:a>
                </s:if>

                <s:if test="#session.account.kind==0">
                    <s:a action="project_editUI">
                        <s:param name="project.projID" value="%{projID}"></s:param>
                        修改
                    </s:a>
                </s:if>

                <s:if test="#session.account.kind==0">
                    <s:a href="javascript:delOne('%{projID}')">删除</s:a>
                </s:if>
            </td>
        </tr>
    </s:iterator>
</table>

<!-- 分页的开始 -->
<%@ include file="/jsp/common/page.jsp" %>
<!-- 分页的结束 -->

</form>

<div class="modal fade" id="modal_order" tabindex="-1" role="dialog" aria-labelledby="modal_login_label"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modal_login_label">预约</h4>
            </div>
            <div class="modal-body">

                <form id="form_order" class="form-horizontal" role="form" onsubmit="return false;">

                    <div class="form-group">
                        <label for="username" class="col-sm-2 control-label">项目ID</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="order.projID" readonly="readonly">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="username" class="col-sm-2 control-label">项目名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="projName" readonly="readonly">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="username" class="col-sm-2 control-label">数量</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="order.num">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="username" class="col-sm-2 control-label">预约时间</label>
                        <div class="col-sm-10">
                            <input type="date" class="form-control" name="order.appotime">
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="saveOrder()">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

</body>
</html>
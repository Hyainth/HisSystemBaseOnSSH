<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>医院预约管理系统</TITLE>

<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<FRAMESET frameSpacing=0 rows=80,* frameBorder=0>
	<FRAME name=top src="top.jsp" frameBorder=0 noResize
		scrolling=no>
		<FRAMESET frameSpacing=0 frameBorder=0 cols=220,*>
				<FRAME name=menu src="companymenu.jsp" frameBorder=0 noResize>
				<FRAME name=main src="companywelcome.jsp" frameBorder=0>
		</FRAMESET>
	<NOFRAMES>
		<p>This page requires frames, but your browser does not support
			them.</p>
	</NOFRAMES>
</FRAMESET>

<s:if test="#session.account==null">
<jsp:forward page="index.jsp" ></jsp:forward>
</s:if>
</HTML>
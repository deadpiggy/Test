<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'orderMyself.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>

	<c:forEach items="${listNum }" var="list">
		<table style="width: 400px margin : auto " border=1px>
			<tr><td>商品编号</td><td>名称</td><td>样式</td><td>单价</td><td>数量</td><td>小计</td></tr>
			<c:forEach items="${list }" var="order">
				<tr>
					<td>${order.cate_id }</td><td>${order.cate_name }</td><td>${order.picture }</td>
					<td>${order.price }</td><td>${order.amount }</td><td>${order.price * order.amount }</td>
				</tr>
				<c:set var="id" value="${order.id }"/>
				<c:set var="address" value="${order.address }"/>
				<c:set var="words" value="${order.words }"/>
			</c:forEach>
		</table>
		<p>订单编号: ${id }&nbsp;&nbsp;送货地址: ${address }&nbsp;&nbsp;附言: ${words }</p>
		<br>
	</c:forEach>
	
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>BackDemo</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<!-- Custom Theme files -->
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<!-- Custom Theme files -->
	<script src=""></script>

  </head>
  
  
	<body>
		<!--页头-->
		<div class="back_head">
			<div class="back_left">
				<a href="backdemo"><img src="images/logo.png" alt="" /></a>
				<a>后台管理系统</a>
				<a href="index"><span style="background: #1fcd75;">前台首页</span></a>
				<a href="logout"><span style="background: #ec3531" ;>退出登录</span></a>
			</div>
		</div>
		<!--主题-->
		<div class="main">
			<div class="container">
				<!--类别-->
				<div id="category_box">
					<ul id="category">
						<li id="active">
							<a href="backdemo" style="color: #aba530;">订单管理</a>
						</li>
						<li>
							<a href="productform">商品管理</a>
						</li>
						<li>
							<a href="backAddCate.jsp">增加商品</a>
						</li>
						<li>
							<a href="backuserform?str=all">用户管理</a>
						</li>
						<li>
							<a href="backuserform?str=manage">管理人员</a>
						</li>
					</ul>
				</div>
				<div id="from">
					<div class="select">
						<form method="post" action="backdemomohu">
							高级查询 &nbsp; &nbsp; 用户编号：<input name="in1" type="text" /> 
							订单编号:<input name="in2" type="text"/>—<input name="in3" type="text"/> 
							订单状态:
							<select>
								<option name="in4" selected="selected">--订单状态--</option>
								<option value="已收货">已收货</option>
								<option value="配送中">配送中</option>
							</select>
							订单日期:<input name="in5" type="text">
                            <input type="submit" value="搜索"/><input type="reset" value="重置"/>
						</form>
					</div>
					<h4 style="width: 10%;margin: auto;color: #aba530;">订单列表</h4>
					<table class="form_table" style="border-collapse:collapse ;">
						<tr>
							<td>订单编号</td>
							<td>用户编号</td>
							<td>送货地址</td>
							<td>订单日期</td>
							<td>交易状态</td>
							<td>查看详情</td>
						</tr>
						
						<c:forEach items="${pb.data }" var="on">
						<tr>
							<td>${on.id }</td>
							<td>${on.user_id }</td>
							<td>${on.address }</td>
							<td>${on.order_date }</td>
							<td>${on.status }</td>
							<td><a href="orderdetail?id=${on.id }&user_id=${on.user_id }">查看详情</a></td>
						</tr>
						</c:forEach>
				
					</table>
					<h3>总共${pb.totalRows }条记录,共${pb.totalPage }页，当前第${pb.pageNo }页</h3>
	    			<h3>
	    				<a href="backdemo?pageNo=${pb.firstPage }&str=all">首页</a>
	    				<a href="backdemo?pageNo=${pb.upPage }&str=all">上一页</a>
	    				<a href="backdemo?pageNo=${pb.downPage }&str=all">下一页</a>
	    				<a href="backdemo?pageNo=${pb.lastPage }&str=all">末页</a>
	    			</h3>
				</div>
			</div>
		</div>
		<!--页尾-->
		<div class="footer">
			<div class="copy">
				<p>
					Copyright &copy; 版权所有&nbsp;（中国）LHLPH夕阳小组投资
				</p>
			</div>
		</div>
		</div>
		<div style="display:none">
			<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script>
		</div>
	</body>
	

</html>

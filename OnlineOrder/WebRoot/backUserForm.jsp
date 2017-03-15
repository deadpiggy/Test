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
    
    <title>My JSP 'backUserForm.jsp' starting page</title>
    
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
						<li>
							<a href="backdemo" >订单管理</a>
						</li>
						<li>
							<a href="productform">商品管理</a>
						</li>
						<li>
							<a href="backAddCate.jsp">增加商品</a>
						</li>
						<li id="active">
							<a href="backuserform?str=all" style="color: #aba530;">用户管理</a>
						</li>
						<li>
							<a href="backuserform?str=manage">管理人员</a>
						</li>
					</ul>
				</div>
				<div id="from">
					<div class="select">
						<form method="post" action="#">
							高级查询 &nbsp; &nbsp; 
							用户编号:<input type="text" />—<input type="text" /> 
							用户账户名:<input type="text" />
							用户状态:
							<select>
								<option selected="selected">--用户状态--</option>
								<option>激活</option>
								<option>未激活</option>
							</select>
                            <input type="button" value="搜索"/><input type="reset" value="重置"/>
						</form>
					</div>
					<h4 style="width: 10%;margin: auto;color: #aba530;">用户列表</h4>
					<table class="form_table" style="border-collapse:collapse ;">
						<tr class="table_td1">
							<td>用户编号</td>
							<td>用户账号</td>
							<td>用户状态</td>
							<td>用户详情</td>
							<td>权限设置</td>
						</tr>
						<c:forEach items="${list }" var="user">
							<tr>
							    <td>${user.user_id }</td>
								<td>${user.ch_name }</td>
								<c:if test="${user.type==1 }">
									<td>激活</td>
								</c:if>
								<c:if test="${user.type==0 }">
									<td>未激活</td>
								</c:if>
								<td><a href="backuserform?str=detail&user_id=${user.user_id }">查看详情</a></td>
								<td>
									<a href="backuserform?str=up&user_id=${user.user_id }" onclick="return confirm('确定将其设为管理员吗？')">设为管理员</a>
								</td>
							</tr>
						</c:forEach>
					</table>
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

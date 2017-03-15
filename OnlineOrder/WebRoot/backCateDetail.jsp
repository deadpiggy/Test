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
    
    <title>My JSP 'productForm.jsp' starting page</title>
    
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
							<a href="backdemo">订单管理</a>
						</li>
						<li id="active">
							<a href="productform" style="color: #aba530;">商品管理</a>
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
						
					</div>
					<h4 style="width: 10%;margin: auto;color: #aba530;">商品详情</h4>
					
					<form method="post" action="backcatedetail?str=update">
						<input type="hidden" name="cate_id" value="${cate.cate_id }">
						<table class="form_table" style="border-collapse:collapse ; margin: auto">
							<tr>
								<td>商品名</td><td><input type="text" name="cate_name" value="${cate.cate_name }"></td>
							</tr>
							<tr>
								<td>商品单价</td><td><input type="text" name="price" value="${cate.price }"></td>
							</tr>
							<tr>
								<td>商品描述</td><td><input type="text" name="describe" value="${cate.describe }"></td>
							</tr>
							<tr>
								<c:if test="${cate.type==2001 }">
									<td>菜系</td><td><input type="text" name="type" value="川菜"></td>
								</c:if>
								<c:if test="${cate.type==2002 }">
									<td>菜系</td><td><input type="text" name="type" value="湘菜"></td>
								</c:if>
								<c:if test="${cate.type==2003 }">
									<td>菜系</td><td><input type="text" name="type" value="粤菜"></td>
								</c:if>
							</tr>
							<tr>
								<td>类别</td><td><input type="text" name="speces" value="${cate.speces }"></td>
							</tr>
							<tr>
								<td>商品样式</td><td><img src="images/${cate.img_path }" style="width: 90px ; height: 50px"></td>
							</tr>
							<tr>
								<td colspan="2"  style="margin: auto">
									<input type="submit" value="提交修改">&nbsp;<input type="submit" value="重 置">
								</td>
							</tr>
						</table>
						
					</form>
					
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

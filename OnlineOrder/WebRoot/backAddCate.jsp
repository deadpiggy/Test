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
	
	<script type="text/javascript">
		function save() {
			var cate_name = document.form1.cate_name.value.trim();
			var price = document.form1.price.value.trim();
			var img_path = document.form1.img_path.value; 
			var describe = document.form1.describe.value.trim();
			var type = document.form1.type.value.trim();
			var speces = document.form1.speces.value.trim();
		
			document.form1.action = "backcatedetail?str=add&cate_name="+cate_name+"&price="+price
				+"&img_path="+img_path+"&describe="+describe+"&type="+type+"&speces="+speces;
			document.form1.submit();	//提交表单
		}
	</script>
  
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
						<li id="active">
							<a href="backAddCate.jsp?str=all" style="color: #aba530;">增加商品</a>
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
					
					<h4 style="width: 10%;margin: auto;color: #aba530;">添加商品</h4>
				<div class="orderForm">
					<form name="form1" method="post" enctype="multipart/form-data">
						<table style="margin-left: 8%;">
							<tr>
								<td>
									<div style="text-align: center;">菜品名：</div>
								</td>
								<td><input type="text" name="cate_name"></td>
							</tr>
							<tr>
								<td height="40px">
									<div style="text-align: center;">价格：</div>
								</td>
								<td><input type="text" name="price"></td>
							</tr>
							<tr>
								<td>
									<div style="text-align: center;">菜品图片：</div>
								</td>
								<td><input type="file" name="img_path"></td>
							</tr>
							<tr>
								<td>
									<div style="text-align: center;">菜品描述：</div>
								</td>
								<td><input type="text" name="describe"></td>
							</tr>
							<tr>
								<td height="40px">
									<div style="text-align: center;">菜品类型：</div>
								</td>
								<td><input type="text" name="type"></td>
							</tr>
							<tr>
								<td height="40px">
									<div style="text-align: center;">餐时：</div>
								</td>
								<td><input type="text" name="speces"></td>
							</tr>
						</table>
						<div class="orderForm_bottom" style="margin-left: 38%;">
							<input type="button" value="保存" onclick="save()">
						</div>
					</form>
				</div>
					
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

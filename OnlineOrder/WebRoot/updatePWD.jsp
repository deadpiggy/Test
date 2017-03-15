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
    
    <title>My JSP 'updatePWD.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<!-- Custom Theme files -->
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<!-- Custom Theme files -->
	<script src="js/project.js"></script>


  </head>
  
	<body>
		<!--页头-->
		<div class="header">
			<div class="container">
				<!--样式属于style.css-->
				<!--页头顶部-->
				<div class="header_top">
					<ul class="phone">
						<li class="phone_left"><i class="mobile"> </i><span>158-8111-3831</span></li>
						<li class="phone_right">购买商品范围在￥100元以上免配送费</li>
						<div class="clearfix"></div>
					</ul>
					<ul class="social">
						<li>
							<a href=""> <i class="tw"> </i> </a>
						</li>
						<li>
							<a href=""><i class="fb"> </i> </a>
						</li>
						<li>
							<a href=""><i class="rss"> </i> </a>
						</li>
						<li>
							<a href=""><i class="msg"> </i> </a>
						</li>
						<div class="clearfix"> </div>
					</ul>
					<!--购物车-->
					<ul class="shopping_cart">
						<c:if test="${a != 1 }">
				   			<a href="index" onclick="demo()"><li class="shop_left"><i class="cart"> </i><span>购物车</span></li></a>
				   			<a><li class="shop_right"><span>￥0.00</span></li></a>
			   			</c:if>
			   			<c:if test="${a == 1 }">
			   				<a href="shoppingcar"><li class="shop_left"><i class="cart"> </i><span>购物车(${listNum })</span></li></a>
				   			<a><li class="shop_right"><span>￥${total }</span></li></a>
			   			</c:if>
						<div class="clearfix"> </div>
					</ul>
					<div class="clearfix"></div>
				</div>
				<!--页头下面部分-->
				<div class="header_bottom">
					<!--logo图片样式属于style.css-->
					<div class="logo">
						<a href="index.html"><img src="images/logo.png" alt="" /><br></a>
					</div>
					<nav class="navbar navbar-default menu" role="navigation">
						<ul class="nav navbar-nav menu1" >
							<li class="active">
								<a href="index">首页</a>
							</li>
							<li>
								<c:if test="${a==1 }"><a href="order">个人中心</a></c:if>
								<c:if test="${a!=1 }"><a onclick="demo()">个人中心</a></c:if>
							</li>
							<li>
								<a href="store.html">帮助中心</a>
							</li>
						</ul>
<!-- 登录按钮 -->
						<ul class="login">
							 <!-- <a href="account.html">
								<li class="login_top"><i class="sign"> </i><span>登录</span></li>
							</a>
							<a href="index" onclick="demo( ${a } )">
								<li class="login_bottom"><i class="register"> </i><span>注册</span></li>
							</a>  -->
							
							<c:if test="${a==1 }">
							<a>
								<li class="login_top"><i class="sign"> </i><span>${loginer.ch_name }${sexDemo }</span></li>
							</a>
							<a href="logout">
								<li class="login_bottom"><i class="register"> </i><span>注销</span></li>
							</a>
							</c:if>
							<c:if test="${a!=1 }">
							<a href="login.jsp">
								<li class="login_top"><i class="sign"> </i><span>登录</span></li>
							</a>
							<a href="register.jsp">
								<li class="login_bottom"><i class="register"> </i><span>注册</span></li>
							</a>
							</c:if>	
						</ul>
						
						<div class="clearfix"></div>

					</nav>
					<div class="clearfix"></div>
					<div class="search">
						<input type="text" class="text" value="输入菜品" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '输入菜品';}">
						<input type="submit" value="搜  索">
					</div>
				</div>
			</div>
		</div>
		<!--主要部分-->
		<div class="main">
			<div class="container">
				<div class="Product_top">
					<div class="register-top-grid">
						<h3>个人信息</h3>
						<table class="register_table">
							<tr>
								<td style="font-size: 14px;">账户名：</td>
								<td>${loginer.ch_name }</td>
							</tr>
						</table>
					</div>
					<div class="clearfix"> </div>
					<form action="updatepwd" method="post" onsubmit="return updatePaw()">
					<div class="register-bottom-grid">
						<h3>新密码信息</h3>
						<div>
							<span>新密码：<label>*</label></span>
							<input type="password" id="paw1" name="paw1">
						</div>
						<div>
							<span>确认新密码：<label>*</label></span>
							<input type="password" id="paw" name="paw">
						</div>
					</div>

					<div class="clearfix"> </div>
					<div class="register-but">
						<input type="submit" value="提交">
						<div class="clearfix"> </div>
					</div>
					</form>
				</div>
			</div>
		</div>
		<!--页尾-->
		<div class="footer">
			<div class="container">
				<div class="footer-grid footer-grid1">

					<ul class="list1">
						<li>
							<a href="index.html">首页</a>
						</li>
						<li>
							<a href="#">关于我们</a>
						</li>
						<li>
							<a href="account.html">登录</a>
						</li>
						<li>
							<a href="contact.html">联系我们</a>
						</li>
					</ul>
				</div>
				<ul class="social">
					<li>
						<a href=""> <i class="tw"> </i> </a>
					</li>
					<li>
						<a href=""><i class="fb"> </i> </a>
					</li>
					<li>
						<a href=""><i class="rss"> </i> </a>
					</li>
					<li>
						<a href=""><i class="msg"> </i> </a>
					</li>
					<div class="clearfix"> </div>
				</ul>
			</div>
			<div class="clearfix"> </div>
			<div class="copy">
				<p>
					Copyright &copy; 版权所有&nbsp;（中国）LHLPH夕阳小组投资
				</p>
			</div>
		</div>
		</div>
	</body>

</html>

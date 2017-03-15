<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
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
    
    <script>
    	function demo() {
    		alert( "请登录！" );
    	}
    </script>

  </head>
  
  
	<body>
		<!--页头-->
		<div class="header">
			<div class="container">
				<!--样式属于style.css-->
				<!--页头顶部-->
				<div class="header_top">
					<ul class="phone">
						<li class="phone_left"><span>1-511-148-1429</span></li>
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
						<a href="register.jsp" onclick="demo()"><li class="shop_left"><i class="cart"> </i><span>购物车</span></li></a>
				 		  	<a><li class="shop_right"><span>￥0.00</span></li></a>
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
						<ul class="nav navbar-nav menu1">
							<li >
								<a href="index">首页</a>
							</li>
							<li>
								<c:if test="${a==1 }"><a href="order">个人中心</a></c:if>
								<c:if test="${a==2 }"><a href="order">个人中心</a></c:if>
								<c:if test="${a!=1&&a!=2 }"><a onclick="demo()">个人中心</a></c:if>
							</li>
							<li>
								<a href="contact.html">联系我们</a>
							</li>
						</ul>
						<ul class="login">
							<a href="login.jsp">
								<li class="login_top"><i class="sign"> </i><span>登录</span></li>
							</a>
							<a href="register.jsp">
								<li class="login_bottom"><i class="register"> </i><span>注册</span></li>
							</a>
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
					<form action="register" method="post" onsubmit="return submits()">
						<div class="register-top-grid">
							<h3>个人信息</h3>
							<div>
								<span>账户名：<label>*</label></span>
								<input type="text" name="username" id="username">
							</div>
							<div>
								<span>姓名：<label>*</label></span>
								<input type="text" name="name" id="name">
							</div>
							<div>
								<span>邮箱：<label>*</label></span>
								<input type="text" name="email" id="email">
							</div>
							<div>
								<span>您的手机号：<label>*</label></span>
								<input type="text" name="mobile" id="mobile">
							</div>
							<div>
								<span>地址：<label>*</label></span>
								<input type="text" name="address" id="address">
							</div>
							<div class="clearfix"> </div>
							<div class="news-letter ">
								<label>您的性别：</label>
								<label><input type="radio" name="sex" value="男" checked="checked">男</label>
								<label><input type="radio" name="sex" value="女">女</label>
							</div>
						</div>
						<div class="clearfix"> </div>
						<div class="register-bottom-grid">
							<h3>密码信息</h3>
							<div>
								<span>账户密码：<label>*</label></span>
								<input type="password" name="paw1" id="paw1">
							</div>
							<div>
								<span>确认账户密码：<label>*</label></span>
								<input type="password" name="paw" id="paw">
							</div>
						</div>

						<div class="clearfix"> </div>
						<div class="register-but">
							<input type="submit" value="提交">
							<div class="clearfix"> </div>
					</form>
					</div>
				</div>
			</div>
		</div>
		<!--页尾-->
		<div class="footer">
			<div class="container">
				<div class="footer-grid footer-grid1">

					<ul class="list1">
						<li>
							<a href="index">首页</a>
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

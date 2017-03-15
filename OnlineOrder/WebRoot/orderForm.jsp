<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'orderForm.jsp' starting page</title>
    
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
						<li class="phone_right">各位新老顾客，欢迎您的光临！</li>
						<div class="clearfix"></div>
					</ul>
					<ul class="social">
						<li>
							<a> <i class="tw"> </i> </a>
						</li>
						<li>
							<a><i class="fb"> </i> </a>
						</li>
						<li>
							<a><i class="rss"> </i> </a>
						</li>
						<li>
							<a><i class="msg"> </i> </a>
						</li>
						<div class="clearfix"> </div>
					</ul>
					<!--购物车-->
					<ul class="shopping_cart">
			   			<c:if test="${a != 1&&a != 2 }">
				   			<a href="index" onclick="demo()"><li class="shop_left"><i class="cart"> </i><span>购物车</span></li></a>
				 		  	<a><li class="shop_right"><span>￥0.00</span></li></a>
			   			</c:if>
			   			<c:if test="${a == 1 }">
			   				<a href="shoppingcar"><li class="shop_left"><i class="cart"> </i><span>购物车(${listNum })</span></li></a>
				  	 		<a><li class="shop_right"><span>￥${total }</span></li></a>
			   			</c:if>
			   			<c:if test="${a == 2 }">
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
						<ul class="nav navbar-nav menu1">
							<li>
								<a href="index">首页</a>
							</li>
							<li>
								<c:if test="${a==1 }"><a href="order">个人中心</a></c:if>
								<c:if test="${a==2 }"><a href="order">个人中心</a></c:if>
								<c:if test="${a!=1&&a!=2 }"><a onclick="demo()">个人中心</a></c:if>
							</li>
							<li>
								<a>帮助中心</a>
							</li>
						</ul>
<!-- 登录按钮 -->
						<ul class="login">
							<c:if test="${a==1 }">
							<a>
								<li class="login_top"><i class="sign"> </i><span>${loginer.ch_name }${sexDemo }</span></li>
							</a>
							<a href="logout">
								<li class="login_bottom"><i class="register"> </i><span>注销</span></li>
							</a>
							</c:if>
							<c:if test="${a!=1&&a!=2 }">
							<a href="login.jsp">
								<li class="login_top"><i class="sign"> </i><span>登录</span></li>
							</a>
							<a href="register.jsp">
								<li class="login_bottom"><i class="register"> </i><span>注册</span></li>
							</a>
							</c:if>
							<c:if test="${a==2 }">
							<a href="backdemo">
								<li class="login_top"><i class="sign"> </i><span>${loginer.ch_name }${sexDemo }</span></li>
							</a>
							<a href="logout">
								<li class="login_bottom"><i class="register"> </i><span>注销</span></li>
							</a>
							</c:if>
							
						</ul>
						<div class="clearfix"></div>

					</nav>
					<div class="clearfix"></div>
					<div class="search">
						<form action="Seek" method="post" >
							<input type="text" class="text" value="输入菜品" name="seek"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = '输入菜品';}"> <input
						type="submit" value="搜  索">
						</form>
					</div>
				</div>
			</div>
		</div>
		<!--主题-->
		<div class="main">
			<div class="container">
				<div class="col-md-3 content_top" style="margin: 25px 0px;">
					<!--类别-->
					<div class="category_box" style="height: 400px;margin-bottom: 50px;">
						<h3 class="cate_head">类别</h3>
						<ul class="category">
								<li>
									<span onclick="classify('早餐')">早餐</span>
									<ul class="classify" id="classify1">
										<li><a href="#">包子</a></li>
										<li><a href="#">粥</a></li>
										<li><a href="#">豆浆油条</a></li>
									</ul>
								</li>
								<li>
									<span onclick="classify('正餐')">正餐</span>
									<ul class="classify" id="classify2">
										<li><a href="selectcate?type=2001">川菜</a></li>
										<li><a href="selectcate?type=2002">湘菜</a></li>
										<li><a href="selectcate?type=2003">粤菜</a></li>
									</ul>
								</li>
								<li>
									<span onclick="classify('夜宵')">夜宵</span>
									<ul class="classify" id="classify3">
										<li><a href="selectcate?type=3001">烧烤</a></li>
										<li><a href="selectcate?type=3002">酒水</a></li>
										<li><a href="selectcate?type=3003">烤鱼</a></li>
									</ul>
								</li>
							</ul>
					</div>
				</div>
				<div class="orderForm">
					<form method="post" action="orderform">
						<table >
							<tr>
								<td colspan="3">
									<div style="text-align: center;"><h2>请确认订单信息</h2></div>
								</td>
							</tr>
							<tr>
								<td>
									<div style="text-align: center;">订餐人：</div>
								</td>
								<td colspan="2">${loginer.ch_name }</td>
							</tr>
							<tr>
								<td height="40px">
									<div style="text-align: center;">菜品项：</div>
								</td>
								<td colspan="3">
									<c:forEach items="${listSC }" var="sc">
										${sc.cate_name }&nbsp;
									</c:forEach>
								</td>
								<td colspan="2"></td>
							</tr>
							<tr>
								<td>
									<div style="text-align: center;">送货地址：</div>
								</td>
								<td colspan="2">
									<input type="text" name="address" class="text" value="请输入送餐地址" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请输入送餐地址';}">
								</td>
							</tr>
							<tr>
								<td>
									<div style="text-align: center;">手机号码：</div>
								</td>
								<td colspan="2">
									<input type="text" name="phone" class="text" value="请输入联系电话" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请输入联系电话';}">
								</td>
							</tr>
							<tr>
								<td height="40px">
									<div style="text-align: center;">配送方式：</div>
								</td>
								<td>
									<input type="checkbox" value="送餐上门">送餐上门
								</td>
								<td>10元以上起送</td>
							</tr>
							<tr>
								<td height="40px">
									<div style="text-align: center;">支付方式：</div>
								</td>
								<td>
									<input type="checkbox" value="货到付款">货到付款
								</td>
								<td></td>
							</tr>
							<tr>
								<td height="40px">
									<div style="text-align: center;">订单总价：</div>
								</td>
								<td colspan="2">
									￥${total }
								</td>
							</tr>
							<tr>
								<td>
									<div style="text-align: center;">订单附言：</div>
								</td>
								<td colspan="2"><textarea name="words" rows="" cols=""></textarea></td>
							</tr>
						</table>
						<div class="orderForm_bottom">
							<input type="submit" name="" id="" value="确认以上信息无误，提交" />
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
							<a>首页</a>
						</li>
						<li>
							<a>关于我们</a>
						</li>
						<li>
							<a>登录</a>
						</li>
						<li>
							<a>联系我们</a>
						</li>
					</ul>
				</div>
				<ul class="social">
						<li>
							<a> <i class="tw"> </i> </a>
						</li>
						<li>
							<a><i class="fb"> </i> </a>
						</li>
						<li>
							<a><i class="rss"> </i> </a>
						</li>
						<li>
							<a><i class="msg"> </i> </a>
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
		<div style="display:none">
			<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script>
		</div>
	</body>
</html>

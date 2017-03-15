<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'personal.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<link href='http://fonts.googleapis.com/css?family=Exo+2:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>

  </head>
  
  
	<body>
		<div class="header">
			<div class="container">
				<div class="header_top">
					<ul class="phone">
						<li class="phone_left"><i class="mobile"> </i><span>158-8111-3831</span></li>
						<li class="phone_right">购买商品在$100元以上免费配送 </li>
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
					<ul class="account">
						<li>
							<a href="account.html">我的账户</a>
						</li>
					</ul>
<!-- 购物车 -->
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
				<div class="header_bottom">
					<div class="header_nav">
						<div class="logo">
							<a href="index.html"><img src="images/logo.png" alt="" /><br></a>
						</div>
						<nav class="navbar navbar-default menu" role="navigation">
							<h3 class="nav_right"><a href="index.html"><img src="images/logo.png" class="img-responsive" alt=""/></a></h3>
							<div class="container-fluid">
								<!-- Brand and toggle get grouped for better mobile display -->
								<div class="navbar-header">
									<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
								</div>
								<!-- Collect the nav links, forms, and other content for toggling -->
								<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
									<ul class="nav navbar-nav menu1">
										<li>
											<a href="index">首页</a>
										</li>
										<li class="active">
											<c:if test="${a==1 }"><a href="order">个人中心</a></c:if>
											<c:if test="${a==2 }"><a href="order">个人中心</a></c:if>
											<c:if test="${a!=1&&a!=2 }"><a onclick="demo()">个人中心</a></c:if>
										</li>
										<li>
											<a href="store.html">帮助中心</a>
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
									<c:if test="${a==2 }">
										<a href="backdemo">
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
										<a href="index" onclick="demo( ${a } )">
											<li class="login_bottom"><i class="register"> </i><span>注册</span></li>
										</a>
								</c:if>
								
									</ul>
									<div class="clearfix"></div>
								</div>
								<!-- /.navbar-collapse -->
							</div>
							<!-- /.container-fluid -->
						</nav>
						<div class="clearfix"></div>
					</div>
					<div class="search">
						<input type="text" class="text" value="您想选购的菜品" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '您想选购的菜品';}">
						<input type="submit" value="搜索">
					</div>
				</div>
			</div>
		</div>
		<div class="main">
			<div class="container">
				<div class="Product_top">
					<div class="row content">
						<div class="col-md-3">
							<div class="category_box">
								<h3 class="cate_head">导 航</h3>
								<ul class="category">
									<li>
										<a href="updatePWD.jsp">修改账户密码</a>
									</li>
								</ul>
							</div>
							
							<ul class="product_reviews">
							<h3><i class="arrow"> </i><span>菜品评论</span></h3>
							
							<c:forEach items="${listDis }" var="dis">
							<li>
								<ul class="review1">
									<li class="review1_img">
										<a href="single?cate_id=${dis.cate_id }">
											<img src="images/${dis.img_path }" class="img-responsive" alt="" />
										</a>
									</li>
									<li class="review1_desc">
										<h3>${dis.content }</h3>
										<p>${dis.user_name }</p>
										<p>${dis.dis_date }</p>
									</li>
									<div class="clearfix"> </div>
								</ul>
							</li>
							</c:forEach>
							
						</ul>
						
							<ul class="product_reviews">
								<h3><i class="arrow"> </i><span>支付方式</span></h3>
								<img src="images/payment.png" class="img-responsive" alt="" />
							</ul>
						</div>
						<div class="col-md-9">
							<div id="sorter" class="tie2">
								<div class="tie2-indent">
								</div>
							</div>
							<div class="pagenation">
								<div id="allProductsListingTopNumber" class="navSplitPagesResult back"></div>
								<div id="allProductsListingTopLinks" class="navSplitPagesLinks forward"> &nbsp;<strong class="current">1</strong>&nbsp;&nbsp;
									<a href="" title=" Page 2 ">2</a>&nbsp;&nbsp;
									<a href="" title=" Page 3 ">3</a>&nbsp;&nbsp;
									<a href="" title=" Page 4 ">4</a>&nbsp;&nbsp;
									<a href="" title=" Page 5 ">5</a>&nbsp;&nbsp;
									<a href="" title=" Next Page ">Next&nbsp;&gt;&gt;</a>&nbsp;
								</div>
								<div class="clearfix"> </div>
							</div>

<!-- 评论详情 -->							
							<c:forEach items="${list }" var="detail">
								<form method="post" action="addDis?did=${detail.did }&cate_id=${cate_id }&size=${size }&picture=${detail.picture }">
									<table>
										<tr>
											<td><img src="images/${detail.picture }"></td>
											<td><h5>${detail.cate_name }</h5></td>
											<td><h5>${detail.price }</h5></td>
										</tr>
										<tr>
											<td colspan="2"><input type="text" name="content" /></td>
										</tr>
										<tr>
											<td><input type="submit" value="提交评论"></td>
										</tr>
									</table>
									
								</form>
							</c:forEach>
							
						</div>
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
							<a href="index.html">首页</a>
						</li>
						<li>
							<a href="">关于我们</a>
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
		<div style="display:none">
			<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script>
		</div>
	</body>


</html>